package repositories;

import models.gate.Gate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GateRepository {
    private final Map<Long, Gate> gateMap;
    private Long idCount;

    public GateRepository() {
        gateMap = new HashMap<>();
        idCount = 0L;
    }

    public Gate save(Gate gate) {
        if (gate.getId() == null) {
            gate.setId(++idCount);
        }
        gateMap.put(gate.getId(), gate);
        return gate;
    }

    public Optional<Gate> findById(Long id) {
        if (gateMap.get(id) == null) {
            return Optional.empty();
        }
        return Optional.of(gateMap.get(id));
    }
}
