package es.guzmanadriana.actividadut0502.controllers;

import es.guzmanadriana.actividadut0502.dto.CartItemDTO;
import es.guzmanadriana.actividadut0502.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/{customerId}")
    public List<CartItemDTO> getCartItems(@PathVariable Integer customerId) {
        return cartService.getCartItems(customerId);
    }

    @PostMapping("/{customerId}")
    public List<CartItemDTO> addProductToCart(@PathVariable Integer customerId, @RequestBody CartItemDTO cartItemDTO) {
        return cartService.addProductToCart(customerId, cartItemDTO);
    }

    @DeleteMapping("/{customerId}/{productId}")
    public List<CartItemDTO> removeProductFromCart(@PathVariable Integer customerId, @PathVariable Integer productId) {
        return cartService.removeProductFromCart(customerId, productId);
    }

    @PostMapping("/empty/{customerId}")
    public List<CartItemDTO> emptyCart(@PathVariable Integer customerId) {
        return cartService.emptyCart(customerId);
    }
}
