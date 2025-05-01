package services;

import models.ParkingSpot;
import models.Ticket;
import models.gate.Gate;
import models.gate.GateStatus;
import models.gate.GateType;
import models.vehicle.Vehicle;
import models.vehicle.VehicleType;
import repositories.TicketRepository;
import services.strategies.AssignmentRequest;
import services.strategies.AssignmentStrategy;
import services.strategies.RandomAssignmentStrategy;

public class TicketService {
    private final TicketRepository ticketRepository;
    private final ParkingLotService parkingLotService;
    private final AssignmentStrategy assignmentStrategy;

    public TicketService(TicketRepository ticketRepository, ParkingLotService parkingLotService) {
        this.ticketRepository = ticketRepository;
        this.parkingLotService = parkingLotService;
        this.assignmentStrategy = new RandomAssignmentStrategy();
    }

    public Ticket generateTicket(String vehicleNumber, VehicleType vehicleType, String owner, long gateId) {
        if (vehicleNumber == null) {
            throw new IllegalArgumentException("Vehicle number cannot be null");
        }
        if (vehicleType == null) {
            throw new IllegalArgumentException("Vehicle type cannot be null");
        }

        AssignmentRequest assignmentRequest = AssignmentRequest.builder()
                .parkingFloors(parkingLotService.getAllParkingFloors())
                .build();
        ParkingSpot parkingSpot = assignmentStrategy.assignParkingSpot(assignmentRequest);


        Gate gate = Gate.builder()
                .gateNumber(1)
                .gateType(GateType.ENTRY)
                .gateStatus(GateStatus.OPEN)
                .build();
        gate.setId(gateId);
        
        Ticket ticket = Ticket.builder()
                .vehicle(Vehicle.builder().vehicleNumber(vehicleNumber).vehicleType(vehicleType).build())
                .entryGate(gate)
                .parkingSpot(parkingSpot)
                .build();
        return ticketRepository.save(ticket);
    }
}
