package repositories;

import models.Ticket;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TicketRepository {
    private final Map<Long, Ticket> ticketMap;
    private Long idCount;

    public TicketRepository() {
        ticketMap = new HashMap<>();
        idCount = 0L;
    }

    public Ticket save(Ticket ticket) {
        if (ticket.getId() == null){
            ticket.setId(++idCount);
        }
        ticketMap.put(ticket.getId(), ticket);
        return ticket;
    }

    public Optional<Ticket> findById(Long id) {
        if (ticketMap.get(id) == null){
            return Optional.empty();
        }
        return Optional.of(ticketMap.get(id));
    }
}
