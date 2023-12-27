package com.example.socialmediafollowservice.Models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "following")
public class UserFollowing {
    @Id
    String id;
    @NotBlank(message = "Username cannot be blank")
    String myUsername;
    @Email(message = "Need valid email address")
    String email;
    String userToFollow;
    ArrayList<String> followList;


    public UserFollowing(String id, String myUsername, ArrayList<String> followList) {
        this.id = id;
        this.myUsername = myUsername;
        this.followList = followList;
    }

    public UserFollowing(String username, ArrayList<String> emptyFollowList) {
        this.myUsername = username;
        this.followList = emptyFollowList;
    }
}
