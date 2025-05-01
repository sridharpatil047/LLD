package repositories;

import models.ParkingFloor;
import models.ParkingLot;

import java.util.*;

public class ParkingLotRepository {
    private final Map<Long, ParkingLot> parkingLotMap;
    private Long idCount;

    public ParkingLotRepository() {
        parkingLotMap = new HashMap<>();
        idCount = 0L;
    }

    public ParkingLot save(ParkingLot parkingLot) {
        if (parkingLot.getId() == null) {
            parkingLot.setId(++idCount);
        }
        parkingLotMap.put(parkingLot.getId(), parkingLot);
        return parkingLot;
    }

    public Optional<ParkingLot> findById(Long id) {
        if (parkingLotMap.get(id) == null) {
            return Optional.empty();
        }
        return Optional.of(parkingLotMap.get(id));
    }

    public List<ParkingFloor> parkingFloors() {
        return new ArrayList<>();
    }
} 