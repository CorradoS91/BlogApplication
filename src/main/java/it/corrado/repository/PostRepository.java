package it.corrado.repository;

import it.corrado.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
    Optional<Post> getPostByTitle(String title);
    Optional <Post> getPostBySubtitle(String subtitle);
    @Query("SELECT p.id FROM Post p JOIN p.tagSet t WHERE t.id = :tagId")
    List<Long> findPostIdsByTagId(@Param("tagId") Long tagId);
}
