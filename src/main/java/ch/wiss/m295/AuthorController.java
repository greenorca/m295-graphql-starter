package ch.wiss.m295;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import ch.wiss.m295.model.Author;
import ch.wiss.m295.model.Post;

@Controller
public class AuthorController {

    private AuthorDao authorDao = new AuthorDao();

    @SchemaMapping(typeName="Post", field="author")
    public Author getAuthor(Post post) {
        return authorDao.getAuthor(post.getAuthorId());
    }

    @QueryMapping
    public List<Author> authors() {
        return authorDao.getAuthors();
    }

    @MutationMapping
    public Author createAuthor(@Argument String name) {
        Author author = new Author();
        author.setId(authorDao.getAuthors().stream().map(Author::getId).max(Long::compare).orElse(0L) + 1);
        author.setName(name);
        authorDao.getAuthors().add(author);
        return author;
    }
}