package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import models.gate.Gate;

import java.util.List;

@Getter
@Setter
@Builder
public class ParkingLot extends BaseModel {
    String name;
    String address;
    List<ParkingFloor> parkingFloors;
    List<Gate> gates;
}
