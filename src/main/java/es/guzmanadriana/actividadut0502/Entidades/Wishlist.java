package es.guzmanadriana.actividadut0502.Entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@Entity
@AllArgsConstructor
@Table(name = "wishlists")
public class Wishlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer wishlistId;
    private String name;
    private Boolean shared;

    public Wishlist() {}

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

}