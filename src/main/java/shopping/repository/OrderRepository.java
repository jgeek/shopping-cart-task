package shopping.repository;

import org.springframework.data.repository.CrudRepository;
import shopping.entity.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
