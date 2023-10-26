package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.response.FraudCheckResponse;
import org.example.service.FraudCheckService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud-check")
@RequiredArgsConstructor
public class FraudController {

    private final FraudCheckService fraudCheckService;
    @GetMapping("{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId){
        boolean fraudulentCustomer = fraudCheckService.isFraudulentCustomer(customerId);
        return FraudCheckResponse.builder().isFraudster(fraudulentCustomer).build();
    }
}
