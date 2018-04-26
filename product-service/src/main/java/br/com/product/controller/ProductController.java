package br.com.product.controller;

import br.com.product.model.Product;
import br.com.product.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") Integer id) {
        return productService.read(id);
    }

    @GetMapping
    public List<Product> findAll() {
        List<Product> products = productService.findAll();
        logger.info("{}", products);
        return products;
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Product create(@RequestBody Product product) {
        return productService.save(product);
    }

    @PutMapping
    public Product update(@RequestBody Product product) {
        return productService.save(product);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id) {
        productService.delete(id);
    }

}
