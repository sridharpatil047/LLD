package services.strategies;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import models.ParkingFloor;
import models.gate.Gate;
import models.vehicle.Vehicle;

import java.util.List;

@Getter
@Setter
@Builder
public class AssignmentRequest {
    private Vehicle vehicle;
    private List<ParkingFloor> parkingFloors;
    private Gate entryGate;
    private Gate exitGate;
}
