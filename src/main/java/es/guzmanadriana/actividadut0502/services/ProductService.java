package es.guzmanadriana.actividadut0502.services;

import es.guzmanadriana.actividadut0502.entities.Product;
import org.springframework.data.domain.Page;

public interface ProductService {
    Page<Product> getPagedProducts(int page, int pageSize);
    Page<Product> searchProducts(String query, int page, int pageSize);
}
