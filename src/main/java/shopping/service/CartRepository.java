package shopping.service;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import shopping.entity.Cart;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long> {

    @Query("select c from Cart c where c.username = :username and c.open = true")
    Cart findCurrentCartOfUser(@Param("username") String username);
}
