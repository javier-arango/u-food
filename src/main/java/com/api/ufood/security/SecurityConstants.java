package com.api.ufood.security;


import org.apache.tomcat.util.codec.binary.Base64;

import java.nio.ByteBuffer;
import java.util.UUID;

public class SecurityConstants {
    public static final long JWT_EXPIRATION = 864_000_000; // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";

    // TODO: Use a better way to generate the secret key
    public static final String JWT_SECRET = uuidToBase64("6fcb514b-b878-4c9d-95b7-8dc3a7ce6fd8");

    private static String uuidToBase64(String str) {
        UUID uuid = UUID.fromString(str);
        ByteBuffer bb = ByteBuffer.wrap(new byte[256]);
        bb.putLong(uuid.getMostSignificantBits());
        bb.putLong(uuid.getLeastSignificantBits());

        return Base64.encodeBase64URLSafeString(bb.array());
    }

}
