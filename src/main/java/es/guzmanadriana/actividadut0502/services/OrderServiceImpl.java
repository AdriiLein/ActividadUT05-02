package es.guzmanadriana.actividadut0502.services;

import es.guzmanadriana.actividadut0502.dto.OrderDTO;
import es.guzmanadriana.actividadut0502.dto.ShipmentDTO;
import es.guzmanadriana.actividadut0502.entities.*;
import es.guzmanadriana.actividadut0502.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ShipmentRepository shipmentRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    @Transactional
    public OrderDTO createOrder(Integer customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        List<CartItem> cartItems = cartItemRepository.findByCustomerCustomerId(customerId);

        if (cartItems.isEmpty()) {
            throw new RuntimeException("El carrito está vacío");
        }

        double total = 0;
        for (CartItem cartItem : cartItems) {
            Product product = cartItem.getProduct();
            if (product.getStock() < cartItem.getQuantity()) {
                throw new RuntimeException("Stock insuficiente para el producto: " + product.getName());
            }
            product.setStock(product.getStock() - cartItem.getQuantity());
            productRepository.save(product);
            total += cartItem.getQuantity() * product.getPrice();
        }

        Order order = new Order();
        order.setCustomer(customer);
        order.setOrderTotal(total);
        order.setOrderDate(Timestamp.valueOf(LocalDateTime.now()));
        order = orderRepository.save(order);

        for (CartItem cartItem : cartItems) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setProduct(cartItem.getProduct());
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setUnitPrice(cartItem.getProduct().getPrice());
            orderItemRepository.save(orderItem);
        }

        cartItemRepository.deleteByCustomer(customer);

        return new OrderDTO(order.getOrderId(), total, order.getOrderDate());
    }

    @Override
    @Transactional
    public ShipmentDTO sendOrder(Integer orderId, ShipmentDTO shipmentDTO) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Pedido no encontrado"));

        if (order.getShipment() != null) {
            throw new RuntimeException("El pedido ya fue enviado");
        }

        Shipment shipment = new Shipment();
        shipment.setOrder(order);
        shipment.setShipmentDate(Timestamp.valueOf(LocalDateTime.now()));
        shipment.setAddress(shipmentDTO.getAddress());
        shipment.setCity(shipmentDTO.getCity());
        shipment.setCountry(shipmentDTO.getCountry());
        shipment.setState(shipmentDTO.getState());
        shipment.setZipCode(shipmentDTO.getZipCode());

        shipment = shipmentRepository.save(shipment);

        return new ShipmentDTO(
                shipment.getShipmentId(),
                shipment.getShipmentDate(),
                shipment.getAddress(),
                shipment.getCity(),
                shipment.getCountry(),
                shipment.getState(),
                shipment.getZipCode()
        );
    }
}