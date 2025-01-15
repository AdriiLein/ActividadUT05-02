package es.guzmanadriana.actividadut0502.repositories;

import es.guzmanadriana.actividadut0502.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {}
