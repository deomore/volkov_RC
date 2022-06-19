package com.vlsu.volkov.config;

import com.vlsu.volkov.utils.exception.ErrorCode;
import com.vlsu.volkov.utils.jwt.Claim;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Data
@Accessors(chain = true)
@Component
@ConfigurationProperties(prefix = "application")
public class ApplicationProperties {
    private Map<ErrorCode, ErrorDefinition> errorMapping;
    private String passwordRegEx;
    private String jwtSecret;
    private String emailRegEx;
    private Long expirationTime;
    private String authHeader;
    private List<Claim> claimForJwt;


    @Data
    @Accessors(chain = true)
    public static class ErrorDefinition {
        private String code;
        private String message;
    }
}