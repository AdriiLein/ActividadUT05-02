package es.guzmanadriana.actividadut0502.Entidades;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "shipments")
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer shipmentId;

    private Timestamp shipmentDate;

    private String zipCode;

    private String city;

    private String country;

    private String state;

    private String address;

    @OneToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;
}
