package org.interaction.interactionservice.repository;

import org.interaction.interactionservice.model.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("SELECT c FROM Comment c WHERE c.userId = :userId AND c.postId = :postId")
    Optional<Comment> getCommentByUserIdAndPostId(Long userId, Long postId);

    @Query("SELECT c FROM Comment c WHERE c.postId = :postId")
    List<Comment> getCommentsByPostId(Long postId);

    Integer countByPostId(Long postId);
}
