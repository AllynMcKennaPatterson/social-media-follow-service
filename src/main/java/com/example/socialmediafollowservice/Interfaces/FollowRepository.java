package com.example.socialmediafollowservice.Interfaces;

import com.example.socialmediafollowservice.Models.UserFollowing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface FollowRepository extends MongoRepository<UserFollowing, String> {
    Boolean existsByMyUsername(String myUsername);

    UserFollowing getUserFollowingByMyUsername(String myUsername);

    Boolean existsByFollowListContainingAndMyUsername(String username, String myUsername);

}
