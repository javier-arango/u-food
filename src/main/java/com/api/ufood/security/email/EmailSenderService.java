package com.api.ufood.security.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService implements EmailSender {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    @Async
    public void send(String to, String email) {

    }
}
