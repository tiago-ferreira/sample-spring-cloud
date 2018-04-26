package br.com.offer.service;

import br.com.offer.exceptions.ResourceNotFoundException;
import br.com.offer.model.Offer;
import br.com.offer.model.Product;
import br.com.offer.repository.OfferRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferService {


    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private OfferRepository offerRepository;

    @Autowired
    private ProductServiceProxy proxy;

    public Offer save(Offer offer) {
        List<Product> products = proxy.retriveProducts();
        logger.info("{}", products);
        offer.setProducts(products);
        return offerRepository.save(offer);
    }

    public Offer read(Integer id) {
        return offerRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Offer", "id", id));
    }

    public void delete(Integer id) {
        Offer offer = read(id);
        offerRepository.delete(offer);
    }

    public List<Offer> findAll() {
        return offerRepository.findAll();
    }
}
