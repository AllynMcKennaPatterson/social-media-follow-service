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

    public Boolean addFollow(UserFollowing userFollowing){
        ArrayList<String> currentFollowList;
        UserFollowing followListToDb = new UserFollowing(userFollowing.getId(), userFollowing.getMyUsername(), userFollowing.getFollowList());
        currentFollowList = followListToDb.getFollowList();
        currentFollowList.add(userFollowing.getUserToFollow());
        followListToDb.setFollowList(currentFollowList);
        followRepository.save(followListToDb);
        System.out.println("User (" + userFollowing.getUserToFollow() + ") added to " + followListToDb.getMyUsername() + "'s follow list\n");
        return true;
    }

}
