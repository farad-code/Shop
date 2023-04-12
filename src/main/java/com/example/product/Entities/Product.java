package com.example.product.Entities;

import java.util.List;

import com.example.product.Enumerations.ProductInfo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false, columnDefinition = "Decimal(10,2) default '0'")
    private double price;
    @Column(length = 32, columnDefinition = "varchar(32) default 'AVAILABLE'")
    @Enumerated(value = EnumType.STRING)
    private ProductInfo productInfo = ProductInfo.AVAILABLE;
    private String description;

    // relationship
    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    private List<ProductImage> productImages;

    public Product(String name, double price, ProductInfo productInfo, String description, Category category) {
        this.name = name;
        this.price = price;
        this.productInfo = productInfo;
        this.description = description;
        this.category = category;
    }
}
