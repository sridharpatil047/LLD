package main;

import models.*;
import models.gate.Gate;
import models.gate.GateStatus;
import models.gate.GateType;
import models.gate.Operator;
import models.spot.ParkingSpot;
import models.spot.ParkingSpotStatus;
import models.spot.ParkingSpotType;
import models.vehicle.VehicleType;
import repositories.*;
import services.*;

public class Application {
    public static void main(String[] args) {
        // Initialize repositories
        OperatorRepository operatorRepository = new OperatorRepository();
        GateRepository gateRepository = new GateRepository();
        ParkingSpotRepository parkingSpotRepository = new ParkingSpotRepository();
        ParkingFloorRepository parkingFloorRepository = new ParkingFloorRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        TicketRepository ticketRepository = new TicketRepository();
        PaymentRepository paymentRepository = new PaymentRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();

        // Initialize services
        OperatorService operatorService = new OperatorService(operatorRepository);
        GateService gateService = new GateService(gateRepository);
        ParkingSpotService parkingSpotService = new ParkingSpotService(parkingSpotRepository);
        ParkingFloorService parkingFloorService = new ParkingFloorService(parkingFloorRepository);
        ParkingLotService parkingLotService = new ParkingLotService(parkingLotRepository);
        TicketService ticketService = new TicketService(ticketRepository);
        PaymentService paymentService = new PaymentService(paymentRepository);
        VehicleService vehicleService = new VehicleService(vehicleRepository);

        // Create operators
        Operator operator1 = operatorService.createOperator(Operator.builder()
                .name("John Doe")
                .email("john@parking.com")
                .build());

        // Create gates
        Gate entryGate = gateService.createGate(Gate.builder()
                .gateNumber(1)
                .gateType(GateType.ENTRY)
                .gateStatus(GateStatus.OPEN)
                .operator(operator1)
                .build());

        Gate exitGate = gateService.createGate(Gate.builder()
                .gateNumber(2)
                .gateType(GateType.EXIT)
                .gateStatus(GateStatus.OPEN)
                .operator(operator1)
                .build());

        // Create parking spots
        ParkingSpot spot1 = parkingSpotService.createParkingSpot(ParkingSpot.builder()
                .spotNumber(1)
                .spotType(ParkingSpotType.CAR)
                .status(ParkingSpotStatus.AVAILABLE)
                .build());

        // Create parking floor
        ParkingFloor floor1 = parkingFloorService.createParkingFloor(ParkingFloor.builder()
                .floorNumber(1)
                .build());

        // Create parking lot
        ParkingLot parkingLot = parkingLotService.createParkingLot(ParkingLot.builder()
                .name("Central Parking")
                .address("123 Main St")
                .build());

        // Example usage
        Ticket ticket = ticketService.generateTicket("ABC123", VehicleType.CAR, "John Smith", entryGate.getId());
        System.out.println("Generated ticket: " + ticket.getId());
    }


    private void setUp() {
        // Operators

        // Gates

        // Parking Spots

        // Parking Floors

        // Parking Lot
    }
}
