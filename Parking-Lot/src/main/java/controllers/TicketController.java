package controllers;

import dtos.GenerateTicketRequestDto;
import dtos.GenerateTicketResponseDto;
import models.Ticket;
import models.vehicle.VehicleType;
import services.TicketService;

public class TicketController {
    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public GenerateTicketResponseDto generateTicket(GenerateTicketRequestDto requestDto) {
        GenerateTicketRequestDto generateTicketRequestDto = GenerateTicketRequestDto.builder()
                .owner(requestDto.getOwner())
                .vehicleNumber(requestDto.getVehicleNumber())
                .vehicleType(requestDto.getVehicleType())
                .gateId(requestDto.getGateId())
                .build();

        Ticket ticket = ticketService.generateTicket(requestDto.getVehicleNumber(), VehicleType.valueOf(requestDto.getVehicleType()),
                requestDto.getOwner(), requestDto.getGateId());

        return GenerateTicketResponseDto.builder()
                .gateNumber(ticket.getEntryGate().getGateNumber())
                .entryTime(ticket.getEntryTime())
                .operator(ticket.getEntryGate().getOperator().getName())
                .build();
    }
}
