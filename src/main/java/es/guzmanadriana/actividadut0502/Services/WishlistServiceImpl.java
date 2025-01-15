package es.guzmanadriana.actividadut0502.Services;

import es.guzmanadriana.actividadut0502.Dto.WishlistDTO;
import es.guzmanadriana.actividadut0502.Entidades.Customer;
import es.guzmanadriana.actividadut0502.Entidades.Wishlist;
import es.guzmanadriana.actividadut0502.Repositorios.CustomerRepository;
import es.guzmanadriana.actividadut0502.Repositorios.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WishlistServiceImpl implements WishlistService {

    @Autowired
    private WishlistRepository wishlistRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<WishlistDTO> getWishlistsByCustomer(Integer customerId) {
        return wishlistRepository.findByCustomerCustomerId(customerId).stream()
                .map(wishlist -> new WishlistDTO(wishlist.getWishlistId(), wishlist.getName(), wishlist.getShared()))
                .collect(Collectors.toList());
    }

    @Override
    public WishlistDTO createWishlist(Integer customerId, WishlistDTO wishlistDTO) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        Wishlist wishlist = new Wishlist(null, wishlistDTO.getName(), wishlistDTO.getShared(), customer);
        wishlist = wishlistRepository.save(wishlist);
        return new WishlistDTO(wishlist.getWishlistId(), wishlist.getName(), wishlist.getShared());
    }

    @Override
    public void deleteWishlist(Integer wishlistId) {
        Wishlist wishlist = wishlistRepository.findById(wishlistId).orElseThrow(() -> new RuntimeException("Lista de deseos no encontrada"));
        if (!wishlistRepository.findProductsInWishlist(wishlistId).isEmpty()) {
            throw new RuntimeException("No se puede eliminar una lista de deseos que no está vacía");
        }
        wishlistRepository.delete(wishlist);
    }

    @Override
    public List<WishlistDTO> getWishlistItems(Integer wishlistId) {
        Wishlist wishlist = wishlistRepository.findById(wishlistId).orElseThrow(() -> new RuntimeException("Lista de deseos no encontrada"));
        return wishlistRepository.findProductsInWishlist(wishlistId).stream()
                .map(product -> new WishlistDTO(product.getProductId(), product.getName(), null))
                .collect(Collectors.toList());
    }
}
