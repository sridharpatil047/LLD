package services;

import models.spot.ParkingSpot;
import repositories.ParkingSpotRepository;

public class ParkingSpotService {
    private final ParkingSpotRepository parkingSpotRepository;

    public ParkingSpotService(ParkingSpotRepository parkingSpotRepository) {
        this.parkingSpotRepository = parkingSpotRepository;
    }

    public ParkingSpot createParkingSpot(ParkingSpot parkingSpot) {
        return parkingSpotRepository.save(parkingSpot);
    }

    public ParkingSpot getParkingSpot(Long id) {
        return parkingSpotRepository.findById(id).orElse(null);
    }
} 