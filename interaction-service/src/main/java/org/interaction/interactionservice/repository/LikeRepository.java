package org.interaction.interactionservice.repository;

import org.interaction.interactionservice.model.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    @Query("SELECT CASE WHEN COUNT(l) > 0 THEN TRUE ELSE FALSE END FROM Like l WHERE l.userId = :userId AND l.postId = :postId")
    boolean existsByUserIdAndPostId(@Param("userId") Long userId, @Param("postId") Long postId);


    @Modifying
    @Query("""
        delete from Like
        where userId = :userId
        and postId = :postId
""")
    void deleteByUserIdAndPostId(Long userId, Long postId);


    @Query("SELECT l FROM Like l WHERE l.userId = :userId AND l.postId = :postId")
    Optional<Like> findByUserIdAndPostId(Long userId, Long postId);

    @Query("SELECT COUNT(l) FROM Like l WHERE l.postId = :postId")
    Integer countByPostId(Long postId);
}
