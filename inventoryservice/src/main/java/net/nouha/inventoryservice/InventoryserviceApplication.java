package net.nouha.inventoryservice;

import net.nouha.inventoryservice.entities.Product;
import net.nouha.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class InventoryserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryserviceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository){
        return args -> {
            productRepository.save(Product.builder().id(UUID.randomUUID().toString()).name("Laptop").price(3200).quantity(3).build());
            productRepository.save(Product.builder().id(UUID.randomUUID().toString()).name("SmartPhone").price(7400).quantity(8).build());
            productRepository.save(Product.builder().id(UUID.randomUUID().toString()).name("Computer").price(9000).quantity(5).build());


        };
    }
}
