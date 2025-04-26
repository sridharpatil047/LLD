package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import models.gate.Gate;
import models.spot.ParkingSpot;
import models.vehicle.Vehicle;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class Ticket extends BaseModel{
    private Vehicle vehicle;
    private Gate entryGate;
    private Gate exitGate;
    private ParkingSpot parkingSpot;
}
