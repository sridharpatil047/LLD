package services;

import models.Ticket;
import models.gate.Gate;
import models.gate.GateStatus;
import models.gate.GateType;
import models.vehicle.Vehicle;
import models.vehicle.VehicleType;
import repositories.TicketRepository;

public class TicketService {
    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket generateTicket(String vehicleNumber, VehicleType vehicleType, String owner, long gateId) {
        if (vehicleNumber == null) {
            throw new IllegalArgumentException("Vehicle number cannot be null");
        }
        if (vehicleType == null) {
            throw new IllegalArgumentException("Vehicle type cannot be null");
        }

        Gate gate = Gate.builder()
                .gateNumber(1)
                .gateType(GateType.ENTRY)
                .gateStatus(GateStatus.OPEN)
                .build();
        gate.setId(gateId);
        
        Ticket ticket = Ticket.builder()
                .vehicle(Vehicle.builder().vehicleNumber(vehicleNumber).vehicleType(vehicleType).build())
                .entryGate(gate)
                .build();
        return ticketRepository.save(ticket);
    }
}
