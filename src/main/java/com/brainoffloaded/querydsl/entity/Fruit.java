package com.brainoffloaded.querydsl.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class Fruit {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NonNull
  private String name;
  @NonNull
  private String color;
  private String description;
  @NonNull
  private String region;
  @NonNull
  @Enumerated(EnumType.STRING)
  private Category category;
  @NonNull
  @Enumerated(EnumType.STRING)
  private Taste taste;

  @ManyToMany
  private Set<Batch> batches;
}
