package com.api.ufood.security;

import org.springframework.beans.factory.annotation.Value;

public interface SecurityConstants {
    long JWT_EXPIRATION = 864_000_000; // 10 days
    String TOKEN_PREFIX = "Bearer ";
    String JWT_SECRET = "SecretKeyToGenJWTsasdfghvbnjklhgvfghvgybhjkn";
}
