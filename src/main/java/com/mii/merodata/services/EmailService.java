package com.mii.merodata.services;

import com.mii.merodata.models.LoanDetail;
import com.mii.merodata.models.SubmitionDetail;
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

  public void sendEmailUser(UserRequest userRequest) {
    try {

      MimeMessage message = mailSender.createMimeMessage();
      MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, 
            StandardCharsets.UTF_8.name());
            
      Context context = new Context();
      
      context.setVariable("email_to", userRequest.getEmail());
      context.setVariable("name", userRequest.getName());
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
  
  public void sendEmailLoan(LoanDetail loanDetail) {
    try {
      MimeMessage message = mailSender.createMimeMessage();
      MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
  
      Context context = new Context();
      
      context.setVariable("email_to", loanDetail.getLoan().getEmployee().getEmail());
      context.setVariable("name", loanDetail.getLoan().getEmployee().getName());
      context.setVariable("loanDate", loanDetail.getLoan().getLoanDate());
      context.setVariable("status", loanDetail.getLoan().getStatus().getName());
      context.setVariable("productName", loanDetail.getProduct().getName());
      context.setVariable("quantity", loanDetail.getProduct().getQuantity());
  
      String html;
      String subject;
      
      if (loanDetail.getLoan().getStatus().getName().equals("approved")) {
        html = templateEngine.process("AcceptanceEmailLoan", context);
        subject = "Loan Application Accepted";
      } else {
        html = templateEngine.process("RejectionEmailLoan", context);
        subject = "Loan Application Rejected";
      }
      
      helper.setTo(loanDetail.getLoan().getEmployee().getEmail());
      helper.setSubject(subject);
      helper.setText(html, true);
  
      mailSender.send(message);
    } catch (Exception e) {
      System.out.println("Something went wrong.");
    }   
  }

  public void sendEmailSubmition(SubmitionDetail submitionDetail) {
    try {
      MimeMessage message = mailSender.createMimeMessage();
      MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
  
      Context context = new Context();
      
      context.setVariable("email_to", submitionDetail.getSubmition().getEmployee().getEmail());
      context.setVariable("name", submitionDetail.getSubmition().getEmployee().getName());
      context.setVariable("submitiondate", submitionDetail.getSubmition().getSubmitionDate());
      context.setVariable("status", submitionDetail.getSubmition().getStatus().getName());
      context.setVariable("productName", submitionDetail.getProduct().getName());
      context.setVariable("quantity", submitionDetail.getProduct().getQuantity());
  
      String html;
      String subject;
      
      if (submitionDetail.getSubmition().getStatus().getName().equals("approved")) {
        html = templateEngine.process("AcceptanceEmailLoan", context);
        subject = "Submition Application Accepted";
      } else {
        html = templateEngine.process("RejectionEmailLoan", context);
        subject = "Submition Application Rejected";
      }
      
      helper.setTo(submitionDetail.getSubmition().getEmployee().getEmail());
      helper.setSubject(subject);
      helper.setText(html, true);
  
      mailSender.send(message);
    } catch (Exception e) {
      System.out.println("Something went wrong.");
    }   
  }
  
}