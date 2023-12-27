package com.example.socialmediafollowservice.Interfaces;

import com.example.socialmediafollowservice.Models.UserFollowing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface FollowRepository extends MongoRepository<UserFollowing, String> {
    Boolean existsByMyUsername(String myUsername);

    Boolean existsByFollowListContainingAndMyUsername(String username, String myUsername);

    Optional<UserFollowing> getUserFollowingByMyUsername(String myUsername);

}
