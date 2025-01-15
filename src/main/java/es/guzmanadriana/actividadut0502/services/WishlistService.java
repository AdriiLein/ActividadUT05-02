package es.guzmanadriana.actividadut0502.services;


import es.guzmanadriana.actividadut0502.dto.WishlistDTO;
import java.util.List;

public interface WishlistService {
    List<WishlistDTO> getWishlistsByCustomer(Integer customerId);
    WishlistDTO createWishlist(Integer customerId, WishlistDTO wishlistDTO);
    void deleteWishlist(Integer wishlistId);
    List<WishlistDTO> getWishlistItems(Integer wishlistId);
}
