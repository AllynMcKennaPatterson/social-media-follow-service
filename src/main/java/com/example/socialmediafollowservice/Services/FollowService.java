package com.example.socialmediafollowservice.Services;

import com.example.socialmediafollowservice.Interfaces.FollowRepository;
import com.example.socialmediafollowservice.Models.UserFollowing;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class FollowService {

    FollowRepository followRepository;

    public FollowService(FollowRepository followRepository) {
        this.followRepository = followRepository;
    }

    public UserFollowing addFollow(UserFollowing userFollowing){
        if(followRepository.existsByUsername(userFollowing.getMyUsername()) && followRepository.existsByUsername(userFollowing.getUserToFollow())){
            ArrayList<String> currentFollowList = new ArrayList<>();
            currentFollowList = userFollowing.getFollowList();
            currentFollowList.add(userFollowing.getUserToFollow());
            userFollowing.setFollowList(currentFollowList);
            followRepository.save(userFollowing);
            System.out.println("User (" + userFollowing.getUserToFollow() + ") added to " + userFollowing.getMyUsername() + "'s follow list\n");
        }
        else{
            System.out.println("Failed to add user to follow list\n");
        }
        return userFollowing;
    }

}
