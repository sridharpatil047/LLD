package models.spot;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import models.BaseModel;

@Getter
@Setter
@Builder
public class ParkingSpot extends BaseModel {
    private int spotNumber;
    private ParkingSpotType spotType;
    private ParkingSpotStatus status;
} 