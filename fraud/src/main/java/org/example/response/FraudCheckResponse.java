package org.example.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FraudCheckResponse {
    Boolean isFraudster;
}
