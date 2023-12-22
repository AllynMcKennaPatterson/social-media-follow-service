package com.example.socialmediafollowservice.Models;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "following")
public class UserFollowing {
    @Id
    String id;
    @NotBlank(message = "Username cannot be blank")
    String username;
    ArrayList<String> following;
}
