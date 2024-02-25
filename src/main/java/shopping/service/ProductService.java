package shopping.service;

import org.springframework.stereotype.Service;
import shopping.entity.Product;
import shopping.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;


    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Iterable<Product> getAllProduct() {
        return productRepository.findAll();
    }
}

