package org.vaibhavgoel.paymentservice.Config;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentGatewayConfig {
    @Value("${razorpay.key.id}")
    private String razorpayKeyId;
    @Value("${razorpay.key.secret}")
    private String razorpayKeySecret;
    @Bean
    public RazorpayClient createRazorpayClient() throws RazorpayException {
        System.out.println("ID:"+razorpayKeyId);
        System.out.println("Secret:"+razorpayKeySecret);
        return new RazorpayClient(razorpayKeyId,razorpayKeySecret);
    }
}
