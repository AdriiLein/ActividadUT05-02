package es.guzmanadriana.actividadut0502.Repositorios;

import es.guzmanadriana.actividadut0502.Entidades.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
