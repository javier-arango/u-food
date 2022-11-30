package com.api.ufood.security.email;

public interface EmailSender {
    void send(String emailTo, String personName, String confirmationLink);
}
