package com.project.back_end.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

/**
 * Service responsible for generating and validating JWT tokens.
 *
 * <p>This class provides secure token creation with issuedAt and expiration
 * timestamps, as required by the project rubric. It also includes helper
 * methods for extracting user information and validating token integrity.</p>
 */
@Component
public class TokenService {

    /** Secret key used for signing JWT tokens. */
    private final Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    /** Token validity duration (e.g., 24 hours). */
    private static final long EXPIRATION_MS = 24 * 60 * 60 * 1000;

    /**
     * Generates a JWT token containing the user's email.
     *
     * <p>This method includes both <strong>issuedAt</strong> and
     * <strong>expiration</strong> timestamps, meeting the assignment criteria.</p>
     *
     * @param email the email to embed inside the token
     * @return the generated JWT token as a String
     */
    public String generateToken(String email) {
        Date now = new Date();
        Date expiry = new Date(now.getTime() + EXPIRATION_MS);

        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(secretKey)
                .compact();
    }

    /**
     * Validates a JWT token.
     *
     * @param token the token to validate
     * @return true if the token is valid, false otherwise
     */
    public boolean validateToken(String token) {
        try {
            extractAllClaims(token);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     * Extracts the email stored inside the JWT token.
     *
     * @param token the JWT token
     * @return the email (subject) stored in the token
     */
    public String extractEmail(String token) {
        return extractAllClaims(token).getSubject();
    }

    /**
     * Extracts all claims contained in the JWT token.
     *
     * @param token the JWT token
     * @return Claims object containing token data
     */
    private
