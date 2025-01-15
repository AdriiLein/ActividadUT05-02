package es.guzmanadriana.actividadut0502.repositories;

import es.guzmanadriana.actividadut0502.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {

}

