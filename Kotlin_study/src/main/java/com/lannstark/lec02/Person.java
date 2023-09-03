package com.lannstark.lec02;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Person {

  private final String name;

  public Person(String name) {
    this.name = name;
  }
  @NotNull
  //@Nullable
  public String getName() {
    return name;
  }

}


