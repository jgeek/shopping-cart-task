package shopping.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

    @Column(name = "username")
    private String username;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @OneToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    public Date getCreatedAt() {
        return createdAt;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
