package com.brainoffloaded.querydsl.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

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
