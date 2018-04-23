package br.com.offer.service;

import br.com.offer.model.Product;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "api-gateway-server", fallback = ProductFallback.class)
@RibbonClient(name = "product-service")
public interface ProductServiceProxy {

    @GetMapping("/product-service/products")
    public List<Product> retriveProducts();
}
