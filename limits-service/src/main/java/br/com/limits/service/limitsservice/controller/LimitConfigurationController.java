package br.com.limits.service.limitsservice.controller;

import br.com.limits.service.limitsservice.config.Configuration;
import br.com.limits.service.limitsservice.service.LimitConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitConfigurationController {

    @Autowired
    private Configuration configuration;

    @GetMapping("/limits")
    public LimitConfiguration retrieveLimitsFromConfiguration() {
        return new LimitConfiguration( configuration.getMinimum(), configuration.getMaximum());
    }
}
