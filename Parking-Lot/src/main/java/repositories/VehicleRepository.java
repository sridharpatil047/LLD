package repositories;

import models.vehicle.Vehicle;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class VehicleRepository {
    private Map<Long, Vehicle> vehicles;
    private Long idCounter;

    public VehicleRepository() {
        vehicles = new HashMap<>();
    }

    public Vehicle save(Vehicle vehicle) {
        if (vehicle.getId() == null) {
            vehicle.setId(++idCounter);
        }
        vehicles.put(vehicle.getId(), vehicle);
        return vehicle;
    }
    public Optional<Vehicle> findById(Long id) {
        if (vehicles.get(id) == null) {
            return Optional.empty();
        }
        return Optional.of(vehicles.get(id));
    }
}
