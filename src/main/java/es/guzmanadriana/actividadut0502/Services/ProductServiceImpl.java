package es.guzmanadriana.actividadut0502.Services;

import es.guzmanadriana.actividadut0502.Entidades.Product;
import es.guzmanadriana.actividadut0502.Repositorios.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<Product> getPagedProducts(int page, int pageSize) {
        return productRepository.findAll(PageRequest.of(page, pageSize));
    }

    @Override
    public Page<Product> searchProducts(String query, int page, int pageSize) {
        return productRepository.findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(
                query, query, PageRequest.of(page, pageSize)
        );
    }
}