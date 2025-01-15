package es.guzmanadriana.actividadut0502.Repositorios;

import es.guzmanadriana.actividadut0502.Entidades.CartItem;
import es.guzmanadriana.actividadut0502.Entidades.Customer;
import es.guzmanadriana.actividadut0502.Entidades.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
    List<CartItem> findByCustomerCustomerIdOrderByProductNameAsc(Integer customerId);
    Optional<CartItem> findByCustomerAndProduct(Customer customer, Product product);
    void deleteByCustomerAndProduct(Customer customer, Product product);
    void deleteByCustomer(Customer customer);

    List<CartItem> findByCustomerCustomerId(Integer customerId);
}