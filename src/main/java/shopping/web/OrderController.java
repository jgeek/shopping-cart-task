package shopping.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import shopping.entity.Order;
import shopping.entity.Product;
import shopping.service.OrderService;

import java.util.List;

@Controller
@RequestMapping("/orders")
//@SessionAttributes("tacoOrder")
public class OrderController {

    private final OrderService orderService;


    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping()
    public String listOrders(Model model) {
        model.addAttribute("orders", getOrders());
        return "orders";
    }


    @ModelAttribute(name = "selectedProducts")
    public SelectedProducts selectedProducts() {
        return new SelectedProducts();
    }

    private Iterable<Order> getOrders() {
        return orderService.getAllOrders();
    }

}
