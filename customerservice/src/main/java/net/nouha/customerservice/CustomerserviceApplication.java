package net.nouha.customerservice;

import net.nouha.customerservice.config.CustomerConfigParams;
import net.nouha.customerservice.entities.Customer;
import net.nouha.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(CustomerConfigParams.class)
public class CustomerserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerserviceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner( CustomerRepository customerRepository){
        return args -> {
            customerRepository.save(Customer.builder().name("Nouha").email("nouha@gmail.com").build());
            customerRepository.save(Customer.builder().name("Nouhaila").email("nouhaila@gmail.com").build());
            customerRepository.save(Customer.builder().name("Nupii").email("nupii@gmail.com").build());

            customerRepository.findAll().forEach(c->{
                System.out.println("================");
                System.out.println(c.getId());
                System.out.println(c.getName());
                System.out.println(c.getEmail());
                System.out.println("================");
            });
        };
    }
}
