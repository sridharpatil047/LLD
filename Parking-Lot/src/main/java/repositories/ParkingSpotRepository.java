package repositories;

import models.spot.ParkingSpot;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ParkingSpotRepository {
    private final Map<Long, ParkingSpot> parkingSpotMap;
    private Long idCount;

    public ParkingSpotRepository() {
        parkingSpotMap = new HashMap<>();
        idCount = 0L;
    }

    public ParkingSpot save(ParkingSpot parkingSpot) {
        if (parkingSpot.getId() == null) {
            parkingSpot.setId(++idCount);
        }
        parkingSpotMap.put(parkingSpot.getId(), parkingSpot);
        return parkingSpot;
    }

    public Optional<ParkingSpot> findById(Long id) {
        if (parkingSpotMap.get(id) == null) {
            return Optional.empty();
        }
        return Optional.of(parkingSpotMap.get(id));
    }
} 