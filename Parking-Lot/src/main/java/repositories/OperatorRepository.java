package repositories;

import models.gate.Operator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OperatorRepository {
    private final Map<Long, Operator> operatorMap;
    private Long idCount;

    public OperatorRepository() {
        operatorMap = new HashMap<>();
        idCount = 0L;
    }

    public Operator save(Operator operator) {
        if (operator.getId() == null) {
            operator.setId(++idCount);
        }
        operatorMap.put(operator.getId(), operator);
        return operator;
    }

    public Optional<Operator> findById(Long id) {
        if (operatorMap.get(id) == null) {
            return Optional.empty();
        }
        return Optional.of(operatorMap.get(id));
    }
} 