package net.nouha.customerservice.repository;

import jakarta.persistence.Id;
import net.nouha.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
