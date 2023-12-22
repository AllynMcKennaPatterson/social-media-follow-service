package com.example.socialmediafollowservice.Interfaces;

import com.example.socialmediafollowservice.Models.UserFollowing;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FollowRepository extends MongoRepository<UserFollowing, String> {

    Boolean existsByUsername(String username);
}
