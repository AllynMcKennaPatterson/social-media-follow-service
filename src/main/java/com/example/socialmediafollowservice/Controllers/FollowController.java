package com.example.socialmediafollowservice.Controllers;

import com.example.socialmediafollowservice.Interfaces.FollowRepository;
import com.example.socialmediafollowservice.Models.UserFollowing;
import com.example.socialmediafollowservice.Services.FollowService;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bson.json.JsonObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class FollowController {
    FollowService followService;
    FollowRepository followRepository;
    public FollowController(FollowService followService, FollowRepository followRepository){
        this.followService = followService;
        this.followRepository = followRepository;
    }

    @PostMapping("/addUserToFollowList")
    Map<String, Boolean> addFollowToList(@RequestBody UserFollowing userFollowing){
        Map<String,Boolean> response = new HashMap<>();
        response.put("Follow user", followService.addFollow(userFollowing));
        return response;
    }

    @PostMapping("/initFollowList")
    Map<String, Boolean> initFollowList(@RequestBody String username){
        Map<String,Boolean> response = new HashMap<>();
        response.put("Initialised follow list", followService.initFollow(username));
        return response;
    }


}
