package es.guzmanadriana.actividadut0502.Services;

import es.guzmanadriana.actividadut0502.Dto.OrderDTO;
import es.guzmanadriana.actividadut0502.Dto.ShipmentDTO;

public interface OrderService {
    OrderDTO createOrder(Integer customerId);
    ShipmentDTO sendOrder(Integer orderId, ShipmentDTO shipmentDTO);
}