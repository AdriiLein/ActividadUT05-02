package es.guzmanadriana.actividadut0502.services;

import es.guzmanadriana.actividadut0502.dto.OrderDTO;
import es.guzmanadriana.actividadut0502.dto.ShipmentDTO;

public interface OrderService {
    OrderDTO createOrder(Integer customerId);
    ShipmentDTO sendOrder(Integer orderId, ShipmentDTO shipmentDTO);
}