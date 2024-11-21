package net.nouha.billingservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import net.nouha.billingservice.model.Product;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class ProductItem {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Bill bill;
    private String productId;
    private int quantity;
    private double unitPrice;
    @Transient
    private Product product;

}
