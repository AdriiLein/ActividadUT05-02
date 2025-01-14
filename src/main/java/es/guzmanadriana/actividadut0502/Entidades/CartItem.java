package es.guzmanadriana.actividadut0502.Entidades;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@AllArgsConstructor
@Table(name = "cart_items", uniqueConstraints = {@UniqueConstraint(columnNames = {"customer_id", "product_id"})})
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartItemId;
    private Integer quantity;

    public CartItem() {}

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
}