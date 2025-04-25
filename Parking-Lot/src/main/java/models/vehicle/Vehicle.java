package models.vehicle;

import lombok.Getter;
import lombok.Setter;
import models.BaseModel;

@Getter
@Setter
public class Vehicle extends BaseModel {
    String vehicleNumber;
    VehicleType vehicleType;
    String owner;
}
