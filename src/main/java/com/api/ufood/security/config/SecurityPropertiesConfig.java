package com.api.ufood.security.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Getter
@Setter
@Configuration
@PropertySource("classpath:custom.properties")
@ConfigurationProperties("ufood-security")
public class SecurityPropertiesConfig {
    private int tokenExpirationTime;
    private String tokenSecret;
}
