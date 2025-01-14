package es.guzmanadriana.actividadut0502.Entidades;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@AllArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
    private Double price;
    private Integer stock;
    private String sku;
    private String name;
    private String description;

    public Product() {}

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;
}