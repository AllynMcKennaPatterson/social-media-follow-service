package com.example.socialmediafollowservice.Models;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MailStructure {
    private String subject;
    private String message;
}