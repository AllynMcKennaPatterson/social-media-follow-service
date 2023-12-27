package com.example.socialmediafollowservice.Services;

import com.example.socialmediafollowservice.Interfaces.FollowRepository;
import com.example.socialmediafollowservice.Models.UserFollowing;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class FollowService {

    FollowRepository followRepository;
    MongoTemplate mongoTemplate;

    public FollowService(FollowRepository followRepository, MongoTemplate mongoTemplate) {
        this.followRepository = followRepository;
        this.mongoTemplate = mongoTemplate;
    }

    public Boolean addFollow(UserFollowing userFollowing){
        if(followRepository.existsByMyUsername(userFollowing.getMyUsername())) {
            if (!followRepository.existsByFollowListContainingAndMyUsername(userFollowing.getUserToFollow(), userFollowing.getMyUsername())) {
                Query query = new Query();
                query.addCriteria(Criteria.where("myUsername").is(userFollowing.getMyUsername()));
                Update update = new Update();
                update.addToSet("followList", userFollowing.getUserToFollow());
                mongoTemplate.updateFirst(query, update, "following");
                System.out.println("User (" + userFollowing.getUserToFollow() + ") added to " + userFollowing.getMyUsername() + "'s follow list");
                return true;
            } else {
                System.out.println("User (" + userFollowing.getUserToFollow() + ") already exists in " + userFollowing.getMyUsername() + "'s follow list");
                return false;
            }
        }
        else{
            System.out.println("Error: User does not exist in database");
            return false;
        }
    }

    public Boolean initFollow(String username){
        if(!followRepository.existsByMyUsername(username)){
            ArrayList<String> emptyFollowList = new ArrayList<>();
            UserFollowing newFollowList = new UserFollowing(username, emptyFollowList);
            followRepository.save(newFollowList);
            System.out.println("Initialised follow list for user: " + username + " \n");
            return true;
        }
        else{
            System.out.println("User (" + username + ") already exists");
            return false;
        }

    }

}
