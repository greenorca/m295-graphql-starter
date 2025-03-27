package ch.wiss.m295;

import java.util.ArrayList;
import java.util.List;

import ch.wiss.m295.model.Author;

public class AuthorDao {

  private List<Author> authors;

  public AuthorDao(){
    authors = new ArrayList();
    authors.add(new Author(1, "John"));
    authors.add(new Author(2, "Jane"));
  }

  public Author getAuthor(int authorId) {
    return authors.stream().filter(a -> a.getId() == authorId).findFirst().orElse(null);
  }

  public List<Author> getAuthors() {
    return authors;
  }

}
