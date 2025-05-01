package services.strategies;

import models.ParkingSpot;

public interface AssignmentStrategy {
    ParkingSpot assignParkingSpot(AssignmentRequest assignmentRequest);
}
