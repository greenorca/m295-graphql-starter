package ch.wiss.m295.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Valid
public class Author {
  @NotNull
  private long id;
  @NotBlank
  private String name;

  public Author(long id,String name) {
    this.id = id;
    this.name = name;
  }
}
