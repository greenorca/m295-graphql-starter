package ch.wiss.m295.model;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Post {
  private long id;
  private String title;
  private String category;
  private int authorId;
  private Date createdAt;
  private String text;
}