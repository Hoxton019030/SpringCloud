package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.entity.FraudCheckHistory;
import org.example.dao.FraudCheckHistoryRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class FraudCheckService {

    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    public boolean isFraudulentCustomer(Integer customerId) {
        fraudCheckHistoryRepository.save(FraudCheckHistory.builder()
                .customerId(customerId)
                .isFraudster(false)
                .createAt(LocalDateTime.now())
                .build());
        return false;

    }

}
