package com.srinath.email.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class EmailService {

    @Autowired
    JavaMailSender javaMailSender;

    public String sendEmail() throws AddressException {

        String emailFromAddress = " Srinath S <srinath2679@gmail.com>";

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(String.valueOf(new InternetAddress(emailFromAddress)));
        message.setTo("srinath2679@gmail.com");
        message.setSubject("Simple Email using SpringBoot");
        message.setText("Test Body");

        javaMailSender.send(message);

        return "Mail sent Successfully !!!";
    }

    public String sendEmailWithAttachment() {

        String emailFromAddress = " Srinath S <srinath2679@gmail.com>";

        try {
            MimeMessage message = javaMailSender.createMimeMessage();

            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);

            messageHelper.setFrom(String.valueOf(new InternetAddress(emailFromAddress)));
            messageHelper.setTo("srinath2679@gmail.com");
            messageHelper.setSubject("Email with Attachment using SpringBoot");
            messageHelper.setText("Test Body");

            File file = new File("D:\\Bridgelabz\\CFP\\SpringBoot\\SpringBoot_Email\\src\\main\\resources\\Hello.txt");

            messageHelper.addAttachment(file.getName(), file);

            javaMailSender.send(message);

            return "Mail sent Successfully !!!";

        } catch (Exception e) {
            return "OOPS !!! Error in Sending mail :" + e;
        }
    }
}
