package br.com.offer.controller;

import br.com.offer.model.Offer;
import br.com.offer.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/offers")
public class OfferController {

    @Autowired
    private OfferService offerService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Offer create(@RequestBody Offer offer) {
        return offerService.save(offer);
    }

    @GetMapping("/{id}")
    public Offer read(@PathVariable("id") Integer id) {
        return offerService.read(id);
    }

    @PatchMapping
    public Offer update(@RequestBody Offer offer) {
        return offerService.save(offer);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id) {
        offerService.delete(id);
    }

    @GetMapping
    public List<Offer> findAll() {
        return offerService.findAll();
    }

}
