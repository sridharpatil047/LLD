package services;

import models.ParkingLot;
import repositories.ParkingLotRepository;

public class ParkingLotService {
    private final ParkingLotRepository parkingLotRepository;

    public ParkingLotService(ParkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;
    }

    public ParkingLot createParkingLot(ParkingLot parkingLot) {
        return parkingLotRepository.save(parkingLot);
    }

    public ParkingLot getParkingLot(Long id) {
        return parkingLotRepository.findById(id).orElse(null);
    }
} 