package dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GenerateTicketRequestDto {
    String vehicleNumber;
    String vehicleType;
    String owner;
    long gateId;
}
