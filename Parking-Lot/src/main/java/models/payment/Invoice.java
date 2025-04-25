package models.payment;

import lombok.Getter;
import lombok.Setter;
import models.BaseModel;
import models.Ticket;
import models.gate.Gate;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class Invoice extends BaseModel {
    Ticket ticket;
    LocalDateTime exitTime;
    Gate exitGate;
    double amount;
    List<Payment> payments;
}
