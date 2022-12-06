package com.api.ufood.security;

public class SecurityConstants {
    public static final long JWT_EXPIRATION = 86400;

    // Other people can't see this in production
    public static final String JWT_SECRET = "this_is_my_secret_key_that_can_not_be_taken";
}
