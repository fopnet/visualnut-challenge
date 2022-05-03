package visualnut.challenge.ex2Application.config;

import java.util.Locale;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WebConfig {

    @Bean
    public ObjectMapper configureJson() {
        return new Jackson2ObjectMapperBuilder()
                .indentOutput(true)
                .locale(new Locale("pt", "BR"))
                .build();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}