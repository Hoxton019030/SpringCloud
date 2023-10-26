package hoxton.customer.service;

import hoxton.customer.entity.Customer;
import hoxton.customer.repository.CustomerRepository;
import hoxton.customer.request.CustomerRegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public void registerCustomer(CustomerRegisterRequest customerRegisterRequest) {

        Customer customer = Customer.builder()
                .firstName(customerRegisterRequest.getFirstName())
                .lastName(customerRegisterRequest.getLastName())
                .email(customerRegisterRequest.getEmail())
                .build();
        customerRepository.save(customer);
    }
}
