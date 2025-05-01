package services;

import models.ParkingFloor;
import models.ParkingLot;
import models.ParkingSpot;
import repositories.ParkingLotRepository;

import java.util.List;

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
    public List<ParkingFloor> getAllParkingFloors(){return parkingLotRepository.parkingFloors();}
} 