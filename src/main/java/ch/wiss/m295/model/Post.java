package ch.wiss.m295.model;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Post {
  @NotNull
  private long id;
  @NotBlank
  private String title;
  private String category;
  private int authorId;
  private Date createdAt;
  private String text;
}