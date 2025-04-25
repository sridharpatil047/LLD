package models.gate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Gate {
    int gateNumber;
    GateType gateType;
    Operator operator;
    GateStatus gateStatus;
}
