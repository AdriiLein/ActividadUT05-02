package es.guzmanadriana.actividadut0502.Entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Entity
@AllArgsConstructor
@Table(name = "shipments")
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer shipmentId;
    private Timestamp shipmentDate = Timestamp.valueOf(LocalDateTime.now());
    private String zipCode;
    private String city;
    private String country;
    private String state;
    private String address;

    public Shipment() {}

    @OneToOne
    @JoinColumn(name = "order_id", nullable = true)
    private Order order;

}