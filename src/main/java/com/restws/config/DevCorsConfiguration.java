//package com.restws.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Profile("development")
//@Configuration
//public class DevCorsConfiguration implements WebMvcConfigurer {
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/api/**").allowedOrigins("http://localhost:4200")
//        .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
//        .allowedHeaders("authorization", "content-type", "x-auth-token")
//        .exposedHeaders("x-auth-token");
//
//    }
//}
