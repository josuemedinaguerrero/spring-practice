package com.example.springsecurityclient.event.listener;

import com.example.springsecurityclient.entity.User;
import com.example.springsecurityclient.event.RegistrationCompleteEvent;
import com.example.springsecurityclient.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

   @Autowired
   private UserService userService;

   @Override
   public void onApplicationEvent( RegistrationCompleteEvent event ) {
      User user = event.getUser();
      String token = UUID.randomUUID().toString();
      userService.saveVerificationTokenForUser( token, user );

      // Send mail to user
      String url = event.getApplicationUrl() + "/verifyRegistration?token=" + token;

      // Send mail to user
      log.info("Click the link to verify your account: {}", url);
   }
}
