package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration
public class LoadHolidayFileConfig {

    @Bean
    public Resource loadHolidayFile() {
        return new ClassPathResource("syukujitsu.csv");
    }
}
