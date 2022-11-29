package com.api.ufood.security.email;

public interface EmailSender {
    void send(String to, String email);
}
