package com.api.ufood.security.filter;

import com.api.ufood.security.SecurityConstants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;

import org.springframework.stereotype.Component;

import java.security.*;
import java.util.Date;

@Component
public class JWTGenerator {

    /**
     * The compact representation of a signed JWT is a string that has three parts, each separated by a .:
     * Each part is Base64URL-encoded.
     * The first part is the header, which at a minimum needs to specify the algorithm used to sign the JWT.
     * The second part is the body. This part has all the claims of this JWT encoded in it.
     * The final part is the signature. It's computed by passing a combination of the header and body through the algorithm specified in the header.
     * @param authentication This is the user authentication
     * @return token
     */
    public String generateToken(Authentication authentication) {
        String username = authentication.getName();
        Date currentDate = new Date();
        Date expireDate = new Date(currentDate.getTime() + SecurityConstants.JWT_EXPIRATION);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(expireDate)
                .signWith(getSigningKey())
                .compact();

        // TODO: Find something that can work with SignatureAlgorithm.HS512 for signWith algorithms
        //  I remove it from the methods bc the key I am generating is smaller that the require one
        // .signWith(getSigningKey(), SignatureAlgorithm.HS512)
    }

    public String getUsernameFromJWT(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    public boolean validateToken(String token) {

        try {
            Jwts.parserBuilder()
                    .setSigningKey(getSigningKey())
                    .build()
                    .parseClaimsJws(token);

            return true;
        // JWT signature does not match locally computed signature. JWT validity cannot be asserted and should not be trusted.
        } catch (Exception e) {
            throw new AuthenticationCredentialsNotFoundException("JWT was expired or incorrect");
        }
    }

    // TODO: Generate a pair of keys (private, public)
//    private KeyPair generateSigintKeyPair() throws NoSuchAlgorithmException {
//        KeyPairGenerator keyGenerator = KeyPairGenerator.getInstance("RSA");
//        keyGenerator.initialize(2048);
//
//        return keyGenerator.generateKeyPair();
//    }

    private Key getSigningKey() {
        byte[] keyBytes = java.util.Base64.getDecoder().decode(SecurityConstants.JWT_SECRET);

        return Keys.hmacShaKeyFor(keyBytes);
    }
}
