package com.mii.merodata.services;

import com.mii.merodata.models.dto.request.UserRequest;

import java.nio.charset.StandardCharsets;

import javax.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.context.Context;
@Service
@AllArgsConstructor
public class EmailService {
  private JavaMailSender mailSender;
  private SpringTemplateEngine templateEngine;

  // User
  public void sendEmailUser(UserRequest userRequest) {
    try {

      MimeMessage message = mailSender.createMimeMessage();
      MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, 
            StandardCharsets.UTF_8.name());
            
      Context context = new Context();
      
      context.setVariable("email_to", userRequest.getEmail());
      context.setVariable("username", userRequest.getUsername());
      context.setVariable("password", userRequest.getPassword());
      
      String html = templateEngine.process("Email", context);
      
      helper.setTo(userRequest.getEmail());
      helper.setSubject("Registration Account Success ");
      helper.setText(html, true);

      mailSender.send(message);
    } catch (Exception e) {
      System.out.println("Something went wrong.");
      }
      
  }

  
}