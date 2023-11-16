package org.sid.customerservice;

import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
        return args -> {
            customerRepository.saveAll(List.of(
                    Customer.builder().Name("Marouane").Email("marwane@emsi.ma").build(),
                    Customer.builder().Name("Adam").Email("Adam@emsi.ma").build(),
                    Customer.builder().Name("Houssam").Email("Houssam@emsi.ma").build(),
                    Customer.builder().Name("Hatim").Email("hatim@emsi.ma").build()
            ));
            customerRepository.findAll().forEach(System.out::println);
        };
    }

}
