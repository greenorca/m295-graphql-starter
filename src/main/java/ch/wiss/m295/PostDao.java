package ch.wiss.m295;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import ch.wiss.m295.model.Post;

public class PostDao {

  private List<Post> posts;

  public PostDao() {
    posts = new ArrayList<>();

    for (int i = 0; i < 10; i++) {
      Post post = new Post();
      post.setId(i);
      post.setTitle("Hello World"+1);
      post.setText("This is my "+i+"th post");
      post.setCategory("Programming");
      post.setAuthorId(i%2+1);
      post.setCreatedAt(Calendar.getInstance().getTime());
      posts.add(post);
    }
  }

  public List<Post> getRecentPosts(int count, int offset) {
    return posts.stream().sorted((x,y) -> y.getCreatedAt().compareTo(x.getCreatedAt())).skip(offset).limit(count).toList();
  }

  public void savePost(Post post) {
    post.setCreatedAt(Calendar.getInstance().getTime());
    posts.add(post);
  }

  public List<Post> getPostsFrom(int authorId) {
    return posts.stream().filter(p -> p.getAuthorId() == authorId).toList();
  }

  public Collection<Post> getPosts() {
    return posts;
  }

}
