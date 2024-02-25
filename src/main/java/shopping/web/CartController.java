package shopping.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import shopping.entity.Cart;
import shopping.service.CartService;

import java.security.Principal;

@Controller
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;


    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping()
    public String getCartInfo(Model model, Principal principal) {
        model.addAttribute("cart", getCart(principal.getName()));
        return "cart";
    }

    private Cart getCart(String username) {
        return cartService.findCurrentCartOf(username);
    }

    @PostMapping("/add")
    public String addToCart(
            @RequestParam(value = "add") Long productId, Principal principal) {

        cartService.addToCurrentCart(principal.getName(), productId);
        return "redirect:/products";
    }

    @PostMapping("/remove")
    public String removeFromCard(
            @RequestParam(value = "remove") Long productId, Principal principal) {

        cartService.removeItemFromCard(principal.getName(), productId);
        return "redirect:/cart";
    }

    @PostMapping("/confirm")
    public String confirm(Principal principal) {
        cartService.confirm(principal.getName());
        return "redirect:/orders";
    }
}
