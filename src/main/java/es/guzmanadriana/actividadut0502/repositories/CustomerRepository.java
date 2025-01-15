package es.guzmanadriana.actividadut0502.repositories;

import es.guzmanadriana.actividadut0502.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
