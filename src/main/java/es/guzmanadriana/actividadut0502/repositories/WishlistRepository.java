package es.guzmanadriana.actividadut0502.repositories;

import es.guzmanadriana.actividadut0502.entities.Product;
import es.guzmanadriana.actividadut0502.entities.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WishlistRepository extends JpaRepository<Wishlist, Integer> {
    List<Wishlist> findByCustomerCustomerId(Integer customerId);

    @Query("SELECT w.products FROM Wishlist w WHERE w.wishlistId = :wishlistId")
    List<Product> findProductsInWishlist(@Param("wishlistId") Integer wishlistId);
}