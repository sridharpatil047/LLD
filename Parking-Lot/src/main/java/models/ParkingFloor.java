package models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ParkingFloor extends BaseModel {
    int floorNumber;
    List<ParkingSpot> parkingSpots;
    ParkingFloorStatus parkingFloorStatus;
}
