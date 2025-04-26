package services;

import models.gate.Gate;
import repositories.GateRepository;

public class GateService {
    private final GateRepository gateRepository;

    public GateService(GateRepository gateRepository) {
        this.gateRepository = gateRepository;
    }

    public Gate createGate(Gate gate) {
        return gateRepository.save(gate);
    }

    public Gate getGate(Long id) {
        return gateRepository.findById(id).orElse(null);
    }
} 