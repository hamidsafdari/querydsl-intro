package com.brainoffloaded.querydsl.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
