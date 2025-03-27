package ch.wiss.m295;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import ch.wiss.m295.model.Post;

@Controller
public class PostController {

    // aka PostRepository
    private PostDao postDao = new PostDao();

    @QueryMapping
    public List<Post> recentPosts(@Argument int count, @Argument int offset) {
        return postDao.getRecentPosts(count, offset);
    }

    @QueryMapping
    public List<Post> postsFrom(@Argument int authorId) {
        return postDao.getPostsFrom(authorId);
    }

    @MutationMapping
    public Post createPost(@Argument String title, @Argument String text,
      @Argument String category, @Argument int authorId) {

        Post post = new Post();
        post.setId(postDao.getPosts().stream().map(Post::getId).max(Long::compare).orElse(0L) + 1);
        post.setTitle(title);
        post.setText(text);
        post.setCategory(category);
        post.setAuthorId(authorId);

        postDao.savePost(post);
        return post;
    }

}