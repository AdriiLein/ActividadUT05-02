package es.guzmanadriana.actividadut0502.Repositorios;

import es.guzmanadriana.actividadut0502.Entidades.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {}
