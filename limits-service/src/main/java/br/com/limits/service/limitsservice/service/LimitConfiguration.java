package br.com.limits.service.limitsservice.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LimitConfiguration {

    private Integer minimun;
    private Integer maximum;


}
