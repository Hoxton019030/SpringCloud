package hoxton.customer.service;

import hoxton.customer.Customer;
import hoxton.customer.request.CustomerRegisterRequest;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    public void registerCustomer(CustomerRegisterRequest customerRegisterRequest) {

        Customer customer = Customer.builder()
                .firstName(customerRegisterRequest.getFirstName())
                .lastName(customerRegisterRequest.getLastName())
                .email(customerRegisterRequest.getEmail())
                .build();
    }
}
