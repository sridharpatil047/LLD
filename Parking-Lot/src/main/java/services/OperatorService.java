package services;

import models.gate.Operator;
import repositories.OperatorRepository;

public class OperatorService {
    private final OperatorRepository operatorRepository;

    public OperatorService(OperatorRepository operatorRepository) {
        this.operatorRepository = operatorRepository;
    }

    public Operator createOperator(Operator operator) {
        return operatorRepository.save(operator);
    }

    public Operator getOperator(Long id) {
        return operatorRepository.findById(id).orElse(null);
    }
} 