package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ParkingSpot extends BaseModel {
    private int spotNumber;
    private ParkingSpotType spotType;
    private ParkingSpotStatus status;
}