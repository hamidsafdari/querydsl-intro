package com.brainoffloaded.querydsl.service;

import com.brainoffloaded.querydsl.BatchRepository;
import com.brainoffloaded.querydsl.FruitRepository;
import com.brainoffloaded.querydsl.entity.Batch;
import com.brainoffloaded.querydsl.entity.Category;
import com.brainoffloaded.querydsl.entity.Fruit;
import com.brainoffloaded.querydsl.entity.QBatch;
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

import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class FruitServiceTest {
  @Autowired
  private FruitRepository fruitRepository;
  @Autowired
  private BatchRepository batchRepository;

  private QFruit fruit = QFruit.fruit;
  private QBatch batch = QBatch.batch;

  @Test
  void testSaveFruits() {
    Fruit apple = fruitRepository.save(new Fruit("apple", "yellow", "everywhere", Category.CORE, Taste.SWEET));
    Fruit banana = fruitRepository.save(new Fruit("banana", "yellow", "tropical areas", Category.TROPICAL, Taste.SWEET));
    Fruit blueberries = fruitRepository.save(new Fruit("blueberries", "blue", "humid northern areas", Category.BERRY, Taste.SWEET));
    fruitRepository.flush();

    Set<Fruit> batch1 = new HashSet<>();
    batch1.add(apple);
    batch1.add(banana);
    batchRepository.save(new Batch(100L, ZonedDateTime.now(), 200.0, 18.0, "AKO-02838", batch1));
    batchRepository.save(new Batch(40L, ZonedDateTime.now(), 360.0, 26.0, "WDF-08021", Collections.singleton(blueberries)));
    batchRepository.flush();

    Pageable pageable = PageRequest.of(0, 10, Sort.by("name"));
    Predicate predicate = fruit.taste.eq(Taste.SWEET)
        .and(fruit.color.eq("yellow"))
        .and(fruit.category.in(Category.CORE, Category.TROPICAL));

    Page<Fruit> result = fruitRepository.findAll(predicate, pageable);
    assertEquals(2, result.getTotalElements());

    Page<Batch> batchResult = batchRepository.findAll(batch.fruits.any().name.eq("apple"), PageRequest.of(0, 10));
    assertEquals(1, batchResult.getTotalElements());
    assertEquals("AKO-02838", batchResult.getContent().get(0).getOrderNumber());
  }

}
