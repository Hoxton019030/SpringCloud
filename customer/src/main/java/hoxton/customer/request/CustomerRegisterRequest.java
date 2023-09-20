package hoxton.customer.request;

import lombok.Data;

@Data
public class CustomerRegisterRequest {
    String firstName;
    String lastName;
    String email;
}
