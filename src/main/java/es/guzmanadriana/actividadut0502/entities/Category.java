package es.guzmanadriana.actividadut0502.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

@Getter
@Entity
@AllArgsConstructor
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    private String name;
    private String description;

    public Category() {}

    @ManyToMany(mappedBy = "categories")
    private Set<Product> products;

}