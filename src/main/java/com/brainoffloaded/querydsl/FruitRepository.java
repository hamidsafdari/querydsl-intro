package com.brainoffloaded.querydsl;

import com.brainoffloaded.querydsl.entity.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface FruitRepository extends JpaRepository<Fruit, Long>, QuerydslPredicateExecutor<Fruit> {
}
