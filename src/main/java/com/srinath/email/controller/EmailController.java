package com.srinath.email.controller;

import com.srinath.email.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    EmailService emailService;

    @GetMapping("/send")
    public String sendEmail() throws AddressException {
        return emailService.sendEmail();
    }

    @GetMapping("/sendAttachment")
    public String sendEmailWithAttachment() {
        return emailService.sendEmailWithAttachment();
    }

}
