package org.hoxton.clients.fraud;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FraudCheckResponse {
    Boolean isFraudster;
}
