package net.nouha.billingservice;

import net.nouha.billingservice.entities.Bill;
import net.nouha.billingservice.entities.ProductItem;
import net.nouha.billingservice.feign.CustomerRestClient;
import net.nouha.billingservice.feign.ProductRestClient;
import net.nouha.billingservice.model.Customer;
import net.nouha.billingservice.model.Product;
import net.nouha.billingservice.repository.BillRepository;
import net.nouha.billingservice.repository.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class BillingserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingserviceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(BillRepository billRepository,
										ProductItemRepository productItemRepository,
										CustomerRestClient customerRestClient,
										ProductRestClient productRestClient){
		return args -> {
			Collection<Customer> customers = customerRestClient.getAllCustomers().getContent();
			Collection<Product> products = productRestClient.getAllProducts().getContent();

			customers.forEach(customer ->{
				Bill bill = Bill.builder().billingDate(new Date()).customerId(customer.getId()).build();
				billRepository.save(bill);
				products.forEach(product ->{
					ProductItem productItem = ProductItem.builder().productId(product.getId()).bill(bill)
							.unitPrice(product.getPrice()).quantity(1+new Random().nextInt(10)).build();
					productItemRepository.save(productItem);
				});
			});
		};
	}
}
