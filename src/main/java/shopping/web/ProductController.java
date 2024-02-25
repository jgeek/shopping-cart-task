package shopping.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import shopping.entity.Product;
import shopping.service.OrderService;
import shopping.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final OrderService orderService;
    private final ProductService productService;

    public ProductController(OrderService orderService, ProductService productService) {
        this.orderService = orderService;
        this.productService = productService;
    }

    @GetMapping()
    public String listProducts(Model model) {
        model.addAttribute("products", getProducts());
        return "products";
    }

    @ModelAttribute(name = "selectedProducts")
    public SelectedProducts selectedProducts() {
        return new SelectedProducts();
    }

    private Iterable<Product> getProducts() {
        return productService.getAllProduct();
    }
}
