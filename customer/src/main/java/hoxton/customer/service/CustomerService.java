package hoxton.customer.service;

import hoxton.customer.entity.Customer;
import hoxton.customer.repository.CustomerRepository;
import hoxton.customer.request.CustomerRegisterRequest;
import lombok.RequiredArgsConstructor;
import org.hoxton.clients.fraud.FraudCheckResponse;
import org.hoxton.clients.fraud.FraudClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final RestTemplate restTemplate;
    private final CustomerRepository customerRepository;
    private final FraudClient fraudClient;

    public void registerCustomer(CustomerRegisterRequest customerRegisterRequest) {

        Customer customer = Customer.builder()
                .firstName(customerRegisterRequest.getFirstName())
                .lastName(customerRegisterRequest.getLastName())
                .email(customerRegisterRequest.getEmail())
                .build();
        customerRepository.saveAndFlush(customer);

        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                "http://FRAUD-SERVICE/api/v1/fraud-check/{customerId}", FraudCheckResponse.class, customer.getId());

        FraudCheckResponse fraudster = fraudClient.isFraudster(customer.getId());

        if (fraudCheckResponse.getIsFraudster()) {
            throw new IllegalStateException("舞弊者");
        }
    }
}
