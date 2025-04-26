package repositories;

import models.payment.Payment;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PaymentRepository {
    private final Map<Long, Payment> paymentMap;
    private Long idCount;

    public PaymentRepository() {
        paymentMap = new HashMap<>();
        idCount = 0L;
    }

    public Payment save(Payment payment) {
        if (payment.getId() == null) {
            payment.setId(++idCount);
        }
        paymentMap.put(payment.getId(), payment);
        return payment;
    }

    public Optional<Payment> findById(Long id) {
        if (paymentMap.get(id) == null) {
            return Optional.empty();
        }
        return Optional.of(paymentMap.get(id));
    }
} 