package com.mii.merodata.services;

import com.mii.merodata.models.LoanProduct;
import com.mii.merodata.models.SubmitionProduct;
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
  
//   public void sendEmailLoan(LoanProduct loanProduct) {
//     try {
//       MimeMessage message = mailSender.createMimeMessage();
//       MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
  
//       Context context = new Context();
      
//       context.setVariable("email_to", loanProduct.getLoan().getEmployee().getEmail());
//       context.setVariable("name", loanProduct.getLoan().getEmployee().getName());
//       context.setVariable("loanDate", loanProduct.getLoan().getLoanDate());
//       context.setVariable("status", loanProduct.getLoan().getStatus().getName());
//       context.setVariable("productName", loanProduct.getProduct().getName());
//       context.setVariable("quantity", loanProduct.getProduct().getQuantity());
  
//       String html = "";
//       String subject = "";
      
//       if (loanProduct.getLoan().getStatus().getId() == 2) {
//         html = templateEngine.process("AcceptanceEmailLoan", context);
//         subject = "Loan Application Accepted";
//       } else if(loanProduct.getLoan().getStatus().getId() == 3){
//         html = templateEngine.process("RejectionEmailLoan", context);
//         subject = "Loan Application Rejected";
//       }
//       else {
//         System.out.println("Status tidak membutuhkan pengiriman email.");
//       }
      
//       helper.setTo(loanProduct.getLoan().getEmployee().getEmail());
//       helper.setSubject(subject);
//       helper.setText(html, true);
  
//       mailSender.send(message);
//     } catch (Exception e) {
//       System.out.println("Something went wrong.");
//     }   
//   }

//   public void sendEmailSubmition(SubmitionProduct submitionProduct) {
//     try {
//       MimeMessage message = mailSender.createMimeMessage();
//       MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
  
//       Context context = new Context();
      
//       context.setVariable("email_to", submitionProduct.getSubmition().getEmployee().getEmail());
//       context.setVariable("name", submitionProduct.getSubmition().getEmployee().getName());
//       context.setVariable("submitiondate", submitionProduct.getSubmition().getSubmitionDate());
//       context.setVariable("status", submitionProduct.getSubmition().getStatus().getName());
//       context.setVariable("productName", submitionProduct.getProduct().getName());
//       context.setVariable("quantity", submitionProduct.getProduct().getQuantity());
  
//       String html = "";
//       String subject = "";
      
//       if (submitionProduct.getSubmition().getStatus().getName().equals("APPROVED")) {
//         html = templateEngine.process("AcceptanceEmailSub", context);
//         subject = "Submition Application Accepted";
//       } 
//       else if(submitionProduct.getSubmition().getStatus().getName().equals("REJECTED")) {
//         html = templateEngine.process("AcceptanceEmailSub", context);
//         subject = "Submition Application Accepted";
//       }
//       else {
//         System.out.println("Status tidak membutuhkan pengiriman email.");
//       }

//       helper.setTo(submitionProduct.getSubmition().getEmployee().getEmail());
//       helper.setSubject(subject);
//       helper.setText(html, true);
  
//       mailSender.send(message);
//     } catch (Exception e) {
//       System.out.println("Something went wrong.");
//     }   
//   }
  
}
