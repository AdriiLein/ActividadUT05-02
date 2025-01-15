package es.guzmanadriana.actividadut0502.Controladores;

import es.guzmanadriana.actividadut0502.Entidades.Product;
import es.guzmanadriana.actividadut0502.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{page}/{pageSize}")
    public Page<Product> getPagedProducts(@PathVariable int page, @PathVariable int pageSize) {
        return productService.getPagedProducts(page, pageSize);
    }

    @GetMapping("/search/{query}/{page}/{pageSize}")
    public Page<Product> searchProducts(@PathVariable String query, @PathVariable int page, @PathVariable int pageSize) {
        return productService.searchProducts(query, page, pageSize);
    }
}

