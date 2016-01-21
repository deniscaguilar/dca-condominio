package br.com.dca.condominio.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Created by denis on 04/01/16.
 */
@SpringBootApplication
public class CondominioApplication {

    public static void main(String[] args) {
        SpringApplication.run(CondominioApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
