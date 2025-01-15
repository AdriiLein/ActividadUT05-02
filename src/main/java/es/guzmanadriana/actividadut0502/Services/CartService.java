package es.guzmanadriana.actividadut0502.Services;

import java.util.List;
import es.guzmanadriana.actividadut0502.Dto.CartItemDTO;

public interface CartService {
    List<CartItemDTO> getCartItems(Integer customerId);
    List<CartItemDTO> addProductToCart(Integer customerId, CartItemDTO cartItemDTO);
    List<CartItemDTO> removeProductFromCart(Integer customerId, Integer productId);
    List<CartItemDTO> emptyCart(Integer customerId);
}