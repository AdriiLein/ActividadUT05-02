package es.guzmanadriana.actividadut0502.services;

import es.guzmanadriana.actividadut0502.dto.CartItemDTO;
import es.guzmanadriana.actividadut0502.entities.CartItem;
import es.guzmanadriana.actividadut0502.entities.Customer;
import es.guzmanadriana.actividadut0502.entities.Product;
import es.guzmanadriana.actividadut0502.repositories.CartItemRepository;
import es.guzmanadriana.actividadut0502.repositories.CustomerRepository;
import es.guzmanadriana.actividadut0502.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<CartItemDTO> getCartItems(Integer customerId) {
        List<CartItem> cartItems = cartItemRepository.findByCustomerCustomerIdOrderByProductNameAsc(customerId);
        return cartItems.stream()
                .map(cartItem -> new CartItemDTO(
                        cartItem.getProduct().getProductId(),
                        cartItem.getProduct().getName(),
                        cartItem.getQuantity(),
                        cartItem.getProduct().getPrice(),
                        cartItem.getQuantity() * cartItem.getProduct().getPrice()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public List<CartItemDTO> addProductToCart(Integer customerId, CartItemDTO cartItemDTO) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        Product product = productRepository.findById(cartItemDTO.getProductId()).orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        CartItem cartItem = cartItemRepository.findByCustomerAndProduct(customer, product)
                .orElse(new CartItem(null, cartItemDTO.getQuantity(), customer, product));

        cartItem.setQuantity(cartItem.getQuantity() + cartItemDTO.getQuantity());
        cartItemRepository.save(cartItem);

        return getCartItems(customerId);
    }

    @Override
    public List<CartItemDTO> removeProductFromCart(Integer customerId, Integer productId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        cartItemRepository.deleteByCustomerAndProduct(customer, product);
        return getCartItems(customerId);
    }

    @Override
    public List<CartItemDTO> emptyCart(Integer customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        cartItemRepository.deleteByCustomer(customer);
        return getCartItems(customerId);
    }
}
