package ch.wiss.m295;

import java.util.ArrayList;
import java.util.List;

import ch.wiss.m295.model.Author;

public class AuthorDao {

  private List<Author> authors;

  public AuthorDao(){
    // initializing demo data
    authors = new ArrayList();
    authors.add(new Author(1, "John Doe"));
    authors.add(new Author(2, "Jane Fonda"));
  }

  public Author getAuthor(int authorId) {
    return authors.stream().filter(a -> a.getId() == authorId).findFirst().orElse(null);
  }

  public List<Author> getAuthors() {
    return authors;
  }

}
