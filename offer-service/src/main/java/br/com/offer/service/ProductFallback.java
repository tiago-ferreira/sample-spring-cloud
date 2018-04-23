package br.com.offer.service;

import br.com.offer.model.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class ProductFallback implements ProductServiceProxy {

    @Override
    public List<Product> retriveProducts() {
        return Arrays.asList(new Product(888, "Produto Default", BigDecimal.valueOf(1000)));
    }
}
