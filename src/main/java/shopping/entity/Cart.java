package shopping.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "cart")
public class Cart extends BaseEntity {

    @Column(name = "username")
    private String username;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "cart_products",
            joinColumns = {@JoinColumn(name = "cart_id")},
            inverseJoinColumns = {@JoinColumn(name = "product_id")})
    private List<Product> items = new ArrayList<>();

    private boolean open = true;

    public List<Product> getItems() {
        return items;
    }

    public void setItems(List<Product> items) {
        this.items = items;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public void addItem(Product product) {
        items.add(product);
    }

    public void removeItem(Long productId) {
        items = items.stream().filter(i -> i.getId() != productId).collect(Collectors.toList());
    }
}
