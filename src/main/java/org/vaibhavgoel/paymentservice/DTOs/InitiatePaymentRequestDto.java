package org.vaibhavgoel.paymentservice.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InitiatePaymentRequestDto {
    private String orderId;
    private Long amount;
    private String email;
    private String phoneNo;
}
