package models.gate;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import models.BaseModel;

@Getter
@Setter
@Builder
public class Gate extends BaseModel {
    int gateNumber;
    GateType gateType;
    Operator operator;
    GateStatus gateStatus;
}
