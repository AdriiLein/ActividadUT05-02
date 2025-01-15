package es.guzmanadriana.actividadut0502.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
public class OrderDTO {
    private Integer orderId;
    private Double total;
    private Timestamp orderDate;
}
