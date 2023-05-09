package id.co.mii.sima.serverapp.controllers;

import lombok.AllArgsConstructor;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import freemarker.template.TemplateException;
import id.co.mii.sima.serverapp.models.dto.requests.EmailRequest;
import id.co.mii.sima.serverapp.models.dto.responses.EmailRespones;
import id.co.mii.sima.serverapp.services.EmailService;

@RestController
@RequestMapping("/email")
@AllArgsConstructor
public class EmailController {

  private EmailService emailService;

  @PostMapping("/html")
  public EmailRequest dynamic(@RequestBody EmailRequest emailRequest) {
      return emailService.dynamic(emailRequest);
  }
    
    @PostMapping("/sendingEmail")
    public EmailRespones sendEmail(@RequestBody EmailRequest request) throws MessagingException, TemplateException, IOException {
        Map<String, Object> model = new HashMap<>();
        model.put("Name", "Muhammad Raihan Alfirzie");
        model.put("location", "Jakarta Selatan");
        model.put("email", "alraihan77@gmail.com");
        return emailService.sendEmail(request, model);
    }

  @PostMapping("/simple")
  public EmailRequest sendSimpleMessage(
    @RequestBody EmailRequest emailRequest
  ) {
    return emailService.sendSimpleMessage(emailRequest);
  }

  @PostMapping("/attach")
  public EmailRequest sendMessageWithAttachment(
    @RequestBody EmailRequest emailRequest
  ) {
    return emailService.sendMessageWithAttachment(emailRequest);
  }

  // Cara 1 - Multiple by Email
  @PostMapping("/attach-multiple")
  public EmailRequest sendMessageWithAttachmentMultiple(
    @RequestBody EmailRequest emailRequest
  ) {
    return emailService.sendMessageWithAttachmentMultiple(emailRequest);
  }

  // Cara 2 - Multiple by Object
  @PostMapping("/attach-multiple/object")
  public Iterable<EmailRequest> sendMessageWithAttachmentMultipleObject(
    @RequestBody Iterable<EmailRequest> emailRequests
  ) {
    return emailService.sendMessageWithAttachmentMultipleObject(emailRequests);
  }
}
