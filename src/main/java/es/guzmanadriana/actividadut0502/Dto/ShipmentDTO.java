package es.guzmanadriana.actividadut0502.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
public class ShipmentDTO {
    private Integer shipmentId;
    private Timestamp shipmentDate;
    private String address;
    private String city;
    private String country;
    private String state;
    private String zipCode;
}