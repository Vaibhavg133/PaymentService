package org.vaibhavgoel.paymentservice.PaymentGateway;

import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;

public interface PaymentGateway {
    String generatePaymentLink (String order,String email, String phoneNo, Long amount) throws RazorpayException, StripeException;
}
