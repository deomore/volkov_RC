package com.vlsu.volkov.utils.jwt;

import com.vlsu.volkov.config.ApplicationProperties;
import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import com.vlsu.volkov.model.User;

import java.security.SignatureException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
@RequiredArgsConstructor
@Slf4j
public class JwtProvider {
    private final ApplicationProperties properties;
    private static final Map<Claim, Function<User, Object>> CLAIMS_FOR_JWT = Map.of(
            Claim.EMAIL, User::getEmail
    );

    public String generateToken(User user) {
        return Jwts.builder()
                .setClaims(setClaims(user))
                .setSubject(user.getEmail())
                .setExpiration(new Date(new Date().getTime() + properties.getExpirationTime()))
                .signWith(SignatureAlgorithm.HS256, properties.getJwtSecret())
                .compact();
    }

    private Map<String, Object> setClaims(User user) {
        Map<String, Object> claims = new HashMap<>();
        //properties.getClaimForJwt().forEach(
        //      claim -> claims.put(claim.toString(), CLAIMS_FOR_JWT.get(claim).apply(user))
        //);
        return claims;
    }

    public boolean validate(String token) {
        try {
            Jwts.parser().setSigningKey(properties.getJwtSecret()).parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException expEx) {
            log.error("Token expired");
        } catch (UnsupportedJwtException unsEx) {
            log.error("Unsupported jwt");
        } catch (MalformedJwtException mjEx) {
            log.error("Malformed jwt");

        } catch (Exception e) {
            log.error("invalid token");
        }
        return false;
    }

    public boolean isAuthorized() {
        return !(SecurityContextHolder.getContext().getAuthentication().getPrincipal() == "anonymousUser");
    }

    public String getRole() {;
        String a = (SecurityContextHolder.getContext().getAuthentication().getAuthorities().toArray()[0]).toString();
        return (SecurityContextHolder.getContext().getAuthentication().getAuthorities().toArray()[0]).toString();
    }

    public String getEmailFromToken(String token) {
        return Jwts.parser().setSigningKey(properties.getJwtSecret()).parseClaimsJws(token).getBody().getSubject();
    }

    public Object getClaimFromToken(Claim claim) {
        String token = SecurityContextHolder.getContext().getAuthentication().getDetails().toString();
        return Jwts.parser().setSigningKey(properties.getJwtSecret()).parseClaimsJws(token).getBody().get(claim.toString());
    }
}