package org.vaibhavgoel.paymentservice.Services;

import com.razorpay.RazorpayException;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.vaibhavgoel.paymentservice.PaymentGateway.PaymentGateway;

@Service
public class PaymentService {
    private final PaymentGateway paymentGateway;
    public PaymentService(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }
    public String initiatePayment(String orderId, String emailID, String phoneNumber, Long amount) throws RazorpayException {
        return paymentGateway.generatePaymentLink(orderId,emailID,phoneNumber,amount);
    }
}
