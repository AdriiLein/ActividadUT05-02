package es.guzmanadriana.actividadut0502.Entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@Entity
@AllArgsConstructor
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;
    private String phoneNumber;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String address;

    public Customer() {}

}
