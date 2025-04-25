package models;

import lombok.Getter;
import lombok.Setter;
import models.vehicle.Vehicle;
import models.vehicle.VehicleType;

import java.util.List;

@Getter
@Setter
public class ParkingSpot extends BaseModel {
    int slotNumber;
    List<VehicleType> vehicleTypes;
    Vehicle vehicle;
    ParkingSpotStatus parkingSpotStatus;
}
