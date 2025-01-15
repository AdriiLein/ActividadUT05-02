package es.guzmanadriana.actividadut0502.Controladores;

import es.guzmanadriana.actividadut0502.Dto.WishlistDTO;
import es.guzmanadriana.actividadut0502.Services.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wishlists")
public class WishlistController {

    @Autowired
    private WishlistService wishlistService;

    @GetMapping("/list/{customerId}")
    public List<WishlistDTO> getWishlistsByCustomer(@PathVariable Integer customerId) {
        return wishlistService.getWishlistsByCustomer(customerId);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<WishlistDTO> createWishlist(
            @PathVariable Integer customerId,
            @RequestBody WishlistDTO wishlistDTO) {
        WishlistDTO createdWishlist = wishlistService.createWishlist(customerId, wishlistDTO);
        return ResponseEntity.status(201).body(createdWishlist);
    }

    @DeleteMapping("/{wishlistId}")
    public ResponseEntity<Void> deleteWishlist(@PathVariable Integer wishlistId) {
        wishlistService.deleteWishlist(wishlistId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{wishlistId}")
    public List<WishlistDTO> getWishlistItems(@PathVariable Integer wishlistId) {
        return wishlistService.getWishlistItems(wishlistId);
    }
}

