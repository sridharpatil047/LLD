package services;

import models.Ticket;
import models.gate.Gate;
import models.gate.GateStatus;
import models.gate.GateType;
import models.gate.Operator;
import models.vehicle.VehicleType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repositories.TicketRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketServiceTest {
    private TicketService ticketService;
    private TicketRepository ticketRepository;
    private ParkingLotService parkingLotService;
    private Gate entryGate;

    @BeforeEach
    void setUp() {
        ticketRepository = new TicketRepository();
        ticketService = new TicketService(ticketRepository, parkingLotService);

        // Setup test gate
        Operator operator = Operator.builder()
                .name("Test Operator")
                .email("test@parking.com")
                .build();

        Gate gate = Gate.builder()
                .gateNumber(1)
                .gateType(GateType.ENTRY)
                .gateStatus(GateStatus.OPEN)
                .operator(operator)
                .build();
        gate.setId(1L);
        entryGate = gate;
    }

    @Test
    void generateTicket_WithValidData_ShouldCreateTicket() {
        // Arrange
        String vehicleNumber = "ABC123";
        VehicleType vehicleType = VehicleType.CAR;
        String owner = "John Smith";

        // Act
        Ticket ticket = ticketService.generateTicket(vehicleNumber, vehicleType, owner, entryGate.getId());

        // Assert
        assertNotNull(ticket);
        assertNotNull(ticket.getId());
        assertEquals(vehicleNumber, ticket.getVehicle().getVehicleNumber());
        assertEquals(vehicleType, ticket.getVehicle().getVehicleType());
        assertEquals(entryGate.getId(), ticket.getEntryGate().getId());
    }

    @Test
    void generateTicket_WithNullVehicleNumber_ShouldThrowException() {
        // Arrange
        String vehicleNumber = null;
        VehicleType vehicleType = VehicleType.CAR;
        String owner = "John Smith";

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            ticketService.generateTicket(vehicleNumber, vehicleType, owner, entryGate.getId());
        });
    }

    @Test
    void generateTicket_WithNullVehicleType_ShouldThrowException() {
        // Arrange
        String vehicleNumber = "ABC123";
        VehicleType vehicleType = null;
        String owner = "John Smith";

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            ticketService.generateTicket(vehicleNumber, vehicleType, owner, entryGate.getId());
        });
    }
} 