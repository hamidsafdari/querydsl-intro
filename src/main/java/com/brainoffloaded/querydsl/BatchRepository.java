package com.brainoffloaded.querydsl;

import com.brainoffloaded.querydsl.entity.Batch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface BatchRepository extends JpaRepository<Batch, Long>, QuerydslPredicateExecutor<Batch> {
}
