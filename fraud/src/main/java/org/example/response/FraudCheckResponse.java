package org.example.response;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class FraudCheckResponse implements Serializable {
    Boolean isFraudster;
}
