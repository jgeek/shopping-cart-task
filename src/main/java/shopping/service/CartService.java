package shopping.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shopping.entity.Cart;
import shopping.entity.Order;
import shopping.entity.Product;
import shopping.repository.OrderRepository;
import shopping.repository.ProductRepository;

import java.util.ArrayList;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final OrderService orderService;
    private final OrderRepository orderRepository;

    public CartService(CartRepository cartRepository, ProductRepository productRepository, OrderService orderService, OrderRepository orderRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    public Cart findCurrentCartOf(String username) {
        Cart cart =cartRepository.findCurrentCartOfUser(username);
        if (cart == null) {
            cart = new Cart();
            cart.setUsername(username);
            cart.setItems(new ArrayList<>());
            cartRepository.save(cart);
        }
        return cart;
    }

    @Transactional
    public void addToCurrentCart(String username, Long productId) {
        Cart cart = cartRepository.findCurrentCartOfUser(username);
        if (cart == null) {
            cart = new Cart();
            cart.setOpen(true);
            cart.setUsername(username);
            cartRepository.save(cart);
        }
        Product product = productRepository.findById(productId).orElseThrow();
        cart.addItem(product);
        cartRepository.save(cart);
    }

    public void removeItemFromCard(String username, Long productId) {
        Cart cart = cartRepository.findCurrentCartOfUser(username);
        cart.removeItem(productId);
        cartRepository.save(cart);
    }

    @Transactional
    public void confirm(String username) {
        Cart cart = cartRepository.findCurrentCartOfUser(username);
        cart.setOpen(false);
        Order order = orderService.createOrderFrom(cart);
        orderRepository.save(order);
        cartRepository.save(cart);
    }
}
