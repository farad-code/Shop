package com.example.product.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String imageUrl;
    private String imageId;

    @ManyToOne
    private Product product;

    public ProductImage(String imageUrl, String imageId, Product product) {
        this.product = product;
        this.imageUrl = imageUrl;
        this.imageId = imageId;
    }
}
