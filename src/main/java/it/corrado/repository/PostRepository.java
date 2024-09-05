package it.corrado.repository;

import it.corrado.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
    Optional<Post> getPostByTitle(String title);
    Optional <Post> getPostBySubtitle(String subtitle);
}
