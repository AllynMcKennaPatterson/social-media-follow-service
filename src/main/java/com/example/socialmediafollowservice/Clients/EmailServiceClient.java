package com.example.socialmediafollowservice.Clients;

import com.example.socialmediafollowservice.Models.MailStructure;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface EmailServiceClient {
    @PostMapping("/sendMail/{mail}")
    String sendMail(@PathVariable String mail, @RequestBody MailStructure mailStructure);
}
