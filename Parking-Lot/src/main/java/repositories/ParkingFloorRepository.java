package repositories;

import models.ParkingFloor;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ParkingFloorRepository {
    private final Map<Long, ParkingFloor> parkingFloorMap;
    private Long idCount;

    public ParkingFloorRepository() {
        parkingFloorMap = new HashMap<>();
        idCount = 0L;
    }

    public ParkingFloor save(ParkingFloor parkingFloor) {
        if (parkingFloor.getId() == null) {
            parkingFloor.setId(++idCount);
        }
        parkingFloorMap.put(parkingFloor.getId(), parkingFloor);
        return parkingFloor;
    }

    public Optional<ParkingFloor> findById(Long id) {
        if (parkingFloorMap.get(id) == null) {
            return Optional.empty();
        }
        return Optional.of(parkingFloorMap.get(id));
    }
} 