package models.vehicle;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import models.BaseModel;

@Getter
@Setter
@Builder
public class Vehicle extends BaseModel {
    String vehicleNumber;
    VehicleType vehicleType;
    String owner;
}
