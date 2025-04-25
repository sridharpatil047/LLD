package models;

import lombok.Getter;
import lombok.Setter;
import models.gate.Gate;

import java.util.List;

@Getter
@Setter
public class ParkingLot extends BaseModel {
    List<ParkingFloor> parkingFloors;
    List<Gate> gates;
}
