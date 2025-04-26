package models.gate;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import models.BaseModel;

@Getter
@Setter
@Builder
public class Operator extends BaseModel {
    String name;
    String email;
}
