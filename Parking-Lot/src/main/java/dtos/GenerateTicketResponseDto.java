package dtos;

import lombok.Builder;
import lombok.Data;
import models.vehicle.VehicleType;

import java.time.LocalDateTime;

@Data
@Builder
public class GenerateTicketResponseDto {
    LocalDateTime entryTime;
    int gateNumber;
    int parkingSpotNumber;
    String operator;
    Vehicle vehicle;

    @Data
    @Builder
    public static class Vehicle {
        String vehicleNumber;
        VehicleType vehicleType;
        String vehicleOwner;
    }
}
