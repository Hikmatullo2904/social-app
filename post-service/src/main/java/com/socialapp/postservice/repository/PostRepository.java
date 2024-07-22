package com.socialapp.postservice.repository;

import com.socialapp.postservice.model.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {


    @Query("""
        select p from Post p
        where p.userId in (:userIds)
        order by p.createdAt desc
""")
    List<Post> getFollowingPosts(List<Long> userIds);


    @Query("""
        select p from Post p
        where p.userId = :userid
        order by p.createdAt desc
""")
    List<Post> getUserPosts(Long userid);

}
