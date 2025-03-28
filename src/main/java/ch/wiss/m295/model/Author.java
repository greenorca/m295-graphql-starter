package ch.wiss.m295.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Author {
  private long id;
  private String name;

  public Author(long id,String name) {
    this.id = id;
    this.name = name;
  }
}
