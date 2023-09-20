package hoxton.customer.controller;

import hoxton.customer.request.CustomerRegisterRequest;
import hoxton.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    public void registerCustomer(@RequestBody CustomerRegisterRequest customerRequest){
        log.info("new customer registration {}",customerRequest);
        customerService.registerCustomer(customerRequest);
    }
}
