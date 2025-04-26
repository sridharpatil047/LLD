package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import models.spot.ParkingSpot;
import models.floor.ParkingFloorStatus;

import java.util.List;

@Getter
@Setter
@Builder
public class ParkingFloor extends BaseModel {
    private int floorNumber;
    private List<ParkingSpot> parkingSpots;
    private ParkingFloorStatus parkingFloorStatus;
}
