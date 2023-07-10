package com.brainoffloaded.querydsl.service;

import com.brainoffloaded.querydsl.FruitRepository;
import com.brainoffloaded.querydsl.entity.Category;
import com.brainoffloaded.querydsl.entity.Fruit;
import com.brainoffloaded.querydsl.entity.QFruit;
import com.brainoffloaded.querydsl.entity.Taste;
import com.querydsl.core.types.Predicate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class FruitServiceTest {
  @Autowired
  private FruitRepository fruitRepository;

  private QFruit fruit = QFruit.fruit;

  @Test
  void testSaveFruits() {
    fruitRepository.save(new Fruit(0L, "apple", "yellow", "round fruit found all over the earth", "everywhere", Category.CORE, Taste.SWEET));
    fruitRepository.save(new Fruit(0L, "banana", "yellow", "oblong fruit found in tropical areas", "tropical areas", Category.TROPICAL, Taste.SWEET));
    fruitRepository.save(new Fruit(0L, "blueberries", "blue", "bush fruit found in humid northern regions", "humid northern areas", Category.BERRY, Taste.SWEET));
    fruitRepository.flush();

    Pageable pageable = PageRequest.of(1, 10, Sort.by("name"));
    Predicate predicate = fruit.taste.eq(Taste.SWEET)
        .and(fruit.color.eq("yellow"))
        .and(fruit.category.in(List.of(Category.CORE, Category.TROPICAL)));

    Page<Fruit> result = fruitRepository.findAll(predicate, pageable);
    assertEquals(2, result.getTotalElements());
  }

}
