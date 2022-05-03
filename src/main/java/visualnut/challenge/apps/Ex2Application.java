package visualnut.challenge.apps;

import java.util.Arrays;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import visualnut.challenge.ex2.model.Country;
import visualnut.challenge.ex2.service.impl.CountryServiceImpl;

@SpringBootApplication(scanBasePackages = { "visualnut.challenge.ex2" })
public class Ex2Application {

    public static void main(String[] args) {
        SpringApplication.run(Ex2Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            System.out.println("Running Ex2Application... ");

            //create ObjectMapper instance
            ObjectMapper objectMapper = ctx.getBean(ObjectMapper.class);

            //read json file and convert to customer object
            Country[] customers = objectMapper.readValue(ctx.getResource("classpath:countries.json").getInputStream(),
                    Country[].class);

            ctx.getBean(CountryServiceImpl.class).setCountries(Arrays.asList(customers));

        };
    }
}
