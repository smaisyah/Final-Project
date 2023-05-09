package id.co.mii.sima.serverapp.services;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import id.co.mii.sima.serverapp.models.dto.requests.EmailRequest;
import id.co.mii.sima.serverapp.models.dto.responses.EmailRespones;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import freemarker.template.Configuration;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
@AllArgsConstructor
public class EmailService {

  @Autowired
  private JavaMailSender mailSender;

  @Autowired
  private Configuration config;

  private TemplateEngine templateEngine;

    // html
   public EmailRequest dynamic(EmailRequest emailRequest) {
    try {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());

        Context ctx = new Context();
        ctx.setVariables(emailRequest.getMap());

        String html = templateEngine.process("submition", ctx);

        helper.setTo(emailRequest.getTo());
        helper.setText(html, true);
        helper.setSubject(emailRequest.getSubject());

        // FileSystemResource file = new FileSystemResource(new File(emailRequest.getAttach()));

        // helper.addAttachment(file.getFilename(), file);

        mailSender.send(message);
        System.out.println("\nEmail success to send");
    } catch (Exception e) {
        throw new IllegalStateException("Email fail to send");
    }
    return emailRequest;
}

    public EmailRespones sendEmail(EmailRequest request, Map<String, Object> model) throws MessagingException, TemplateException, IOException {
        EmailRespones response = new EmailRespones();
        MimeMessage message = mailSender.createMimeMessage();
        try {
            Template t = config.getTemplate("email-template.ftl");
            System.out.println("Template loaded: " + t.getName());

            String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setSubject(request.getSubject());
            helper.setTo(request.getTo());
            helper.setText(html, true);
            mailSender.send(message);
            response.setMessage("mail send to : " + request.getTo());
            response.setStatus(Boolean.TRUE);

        } catch (MessagingException | IOException | TemplateException e) {
            response.setMessage("Mail Sending failure : "+e.getMessage());
            response.setStatus(Boolean.FALSE);
        }

        return response;
    }

  public EmailRequest sendSimpleMessage(EmailRequest emailRequest) {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setTo(emailRequest.getTo());
    message.setSubject(emailRequest.getSubject());
    message.setText(emailRequest.getBody());

    mailSender.send(message);
    System.out.println();
    System.out.println("Email success to send...");
    return emailRequest;
  }

  public EmailRequest sendMessageWithAttachment(EmailRequest emailRequest) {
    try {
      MimeMessage message = mailSender.createMimeMessage();
      MimeMessageHelper helper = new MimeMessageHelper(message, true);

      helper.setTo(emailRequest.getTo());
      helper.setSubject(emailRequest.getSubject());
      helper.setText(emailRequest.getBody());

      FileSystemResource file = new FileSystemResource(
        new File(emailRequest.getAttach())
      );

      helper.addAttachment(file.getFilename(), file);
      mailSender.send(message);
      System.out.println();
      System.out.println("Email success to send...");
    } catch (Exception e) {
      throw new IllegalStateException("Email failed to send...");
    }
    return emailRequest;
  }

  // Cara 1 - Multiple by Email
  public EmailRequest sendMessageWithAttachmentMultiple(
    EmailRequest emailRequest
  ) {
    try {
      MimeMessage message = mailSender.createMimeMessage();
      MimeMessageHelper helper = new MimeMessageHelper(message, true);

      helper.setTo(InternetAddress.parse(emailRequest.getTo()));
      helper.setSubject(emailRequest.getSubject());
      helper.setText(emailRequest.getBody());

      FileSystemResource file = new FileSystemResource(
        new File(emailRequest.getAttach())
      );

      helper.addAttachment(file.getFilename(), file);
      mailSender.send(message);
      System.out.println();
      System.out.println("Email success to send...");
    } catch (Exception e) {
      throw new IllegalStateException("Email failed to send...");
    }
    return emailRequest;
  }

  // Cara 2 - Multiple by Object
  public Iterable<EmailRequest> sendMessageWithAttachmentMultipleObject(
    Iterable<EmailRequest> emailRequests
  ) {
    emailRequests.forEach(emailRequest -> {
      try {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(emailRequest.getTo());
        helper.setSubject(emailRequest.getSubject());
        helper.setText(emailRequest.getBody());

        FileSystemResource file = new FileSystemResource(
          new File(emailRequest.getAttach())
        );

        helper.addAttachment(file.getFilename(), file);
        mailSender.send(message);
        System.out.println();
        System.out.println("Email success to send...");
      } catch (Exception e) {
        throw new IllegalStateException("Email failed to send...");
      }
    });
    return emailRequests;
  }
}
