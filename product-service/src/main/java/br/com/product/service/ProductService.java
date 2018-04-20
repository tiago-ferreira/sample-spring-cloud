package br.com.product.service;

import br.com.product.exceptions.ResourceNotFoundException;
import br.com.product.model.Product;
import br.com.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Product read(Integer id) {
        return productRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Product", "Id", id));
    }

    public void delete(Integer id) {
        Product product = read(id);
        productRepository.delete(product);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

}
