package models;

import lombok.Getter;
import lombok.Setter;
import models.gate.Gate;
import models.vehicle.Vehicle;

import java.time.LocalDateTime;

@Getter
@Setter
public class Ticket extends BaseModel{
    Vehicle vehicle;
    Gate entryGate;
    LocalDateTime entryTime;
    ParkingSpot parkingSpot;
}
