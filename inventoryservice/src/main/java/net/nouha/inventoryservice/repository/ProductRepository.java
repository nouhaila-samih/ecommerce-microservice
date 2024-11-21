package net.nouha.inventoryservice.repository;

import net.nouha.inventoryservice.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, String> {
}
