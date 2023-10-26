package org.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.response.FraudCheckResponse;
import org.example.service.FraudCheckService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud-check")
@RequiredArgsConstructor
@Slf4j
public class FraudController {

    private final FraudCheckService fraudCheckService;
    @GetMapping("{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId){
        log.info("顧客id是:{}",customerId);
        boolean fraudulentCustomer = fraudCheckService.isFraudulentCustomer(customerId);
        return FraudCheckResponse.builder().isFraudster(fraudulentCustomer).build();
    }
}
