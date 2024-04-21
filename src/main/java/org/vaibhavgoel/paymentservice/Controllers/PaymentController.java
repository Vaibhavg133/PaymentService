package org.vaibhavgoel.paymentservice.Controllers;

import com.razorpay.RazorpayException;
import org.springframework.web.bind.annotation.*;
import org.vaibhavgoel.paymentservice.DTOs.InitiatePaymentRequestDto;
import org.vaibhavgoel.paymentservice.Services.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private PaymentService paymentService;
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    @PostMapping("/")
    public String intiatePayment(@RequestBody InitiatePaymentRequestDto initiatePaymentRequestDto) throws RazorpayException {
        return paymentService.initiatePayment(initiatePaymentRequestDto.getOrderId(), initiatePaymentRequestDto.getEmail(),initiatePaymentRequestDto.getPhoneNo(), initiatePaymentRequestDto.getAmount());
    }
}
