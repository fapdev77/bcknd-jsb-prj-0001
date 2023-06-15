package com.bckndjsb.prj0001.config;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {
    private static final Logger logger = Logger.getLogger(WebConfig.class.getName());

	@Value("${cors.origins}")
	private String corsOrigins;

    @Bean
    WebMvcConfigurer corsConfigurer() {
    	//Exibe as configurações
        logger.info("cors.origins: " + corsOrigins);

		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedMethods("*").allowedOrigins(corsOrigins);
			}
		};
	}
	
}
