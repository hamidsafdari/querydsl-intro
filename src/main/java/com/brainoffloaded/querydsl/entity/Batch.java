package com.brainoffloaded.querydsl.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.time.ZonedDateTime;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class Batch {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NonNull
  private Long amountKilo;
  @NonNull
  private ZonedDateTime arrivalDate;
  @NonNull
  private Double cost;
  @NonNull
  private Double shipping;
  @NonNull
  private String orderNumber;

  @NonNull
  @ManyToMany
  private Set<Fruit> fruits;
}
