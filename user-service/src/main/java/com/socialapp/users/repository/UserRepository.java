package com.socialapp.users.repository;

import com.socialapp.users.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    @Query("""
        select u from User u
        where u.id in (select f.followerId from Follow f where f.followingId = :userId)
""")
    List<User> getUserFollowers(Long userId);

    @Query("""
        select u from User u
        where u.id in (select f.followingId from Follow f where f.followerId = :userId)
""")
    List<User> getUserFollowings(Long userId);
}
