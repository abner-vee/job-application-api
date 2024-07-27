package com.vivian.user_app.config.cloudinaryConfig;

import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudinaryConfig {
    @Value("${cloudinary.name}")
    private String cloudName;

    @Value("${cloudinary.api.key}")
    private String cloudinaryApiKey;


    @Value("${cloudinary.api.secret}")
    private String cloudinaryApiSecret;

    @Bean
    public Cloudinary cloudinary(){
        Map<String, String> config = new HashMap<>();

        config.put("cloud_name", cloudName);
        config.put("api_key", cloudinaryApiKey);
        config.put("api_secret", cloudinaryApiSecret);

        return new Cloudinary(config);
    }
}
