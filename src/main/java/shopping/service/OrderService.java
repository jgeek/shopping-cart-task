package shopping.service;

import org.springframework.stereotype.Service;
import shopping.entity.Cart;
import shopping.entity.Order;
import shopping.entity.Product;
import shopping.repository.OrderRepository;
import shopping.repository.ProductRepository;
import shopping.web.SelectedProducts;

import java.util.Date;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public Iterable<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order createOrderFrom(Cart cart) {
        Order order = new Order();
        order.setCreatedAt(new Date());
        order.setCart(cart);
        order.setUsername(cart.getUsername());
        return order;
    }

}
