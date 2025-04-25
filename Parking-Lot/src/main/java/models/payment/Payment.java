package models.payment;

import lombok.Getter;
import lombok.Setter;
import models.BaseModel;

@Getter
@Setter
public class Payment extends BaseModel {
    double amount;
    PaymentMode paymentMode;
    PaymentStatus paymentStatus;
}
