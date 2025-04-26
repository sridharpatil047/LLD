package services;

import models.ParkingFloor;
import repositories.ParkingFloorRepository;

public class ParkingFloorService {
    private final ParkingFloorRepository parkingFloorRepository;

    public ParkingFloorService(ParkingFloorRepository parkingFloorRepository) {
        this.parkingFloorRepository = parkingFloorRepository;
    }

    public ParkingFloor createParkingFloor(ParkingFloor parkingFloor) {
        return parkingFloorRepository.save(parkingFloor);
    }

    public ParkingFloor getParkingFloor(Long id) {
        return parkingFloorRepository.findById(id).orElse(null);
    }
} 