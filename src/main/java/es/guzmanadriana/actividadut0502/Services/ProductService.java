package es.guzmanadriana.actividadut0502.Services;

import es.guzmanadriana.actividadut0502.Entidades.Product;
import org.springframework.data.domain.Page;

public interface ProductService {
    Page<Product> getPagedProducts(int page, int pageSize);
    Page<Product> searchProducts(String query, int page, int pageSize);
}
