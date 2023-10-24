package ie.atu.lab6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableFeignClients
@SpringBootApplication
public class Lab6Application {

    public static void main(String[] args) {
        SpringApplication.run(Lab6Application.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {return new RestTemplate();}
}
