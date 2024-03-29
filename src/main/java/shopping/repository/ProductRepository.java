package shopping.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import shopping.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}
