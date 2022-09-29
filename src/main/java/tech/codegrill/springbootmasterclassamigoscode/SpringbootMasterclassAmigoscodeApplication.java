package tech.codegrill.springbootmasterclassamigoscode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringbootMasterclassAmigoscodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMasterclassAmigoscodeApplication.class, args);
    }

}
