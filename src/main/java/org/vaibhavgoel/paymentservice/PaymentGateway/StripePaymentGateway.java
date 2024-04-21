package org.vaibhavgoel.paymentservice.PaymentGateway;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentLink;
import com.stripe.model.Price;
import com.stripe.param.PaymentLinkCreateParams;
import org.springframework.beans.factory.annotation.Value;
import java.util.ArrayList;
import java.util.List;

import java.util.HashMap;
import java.util.Map;

public class StripePaymentGateway implements PaymentGateway{

    @Value("${stripe.key.secret}")
    private String stripeKey;
    @Override
    public String generatePaymentLink(String order,String email, String phoneNo, Long amount) throws StripeException {
        Stripe.apiKey = stripeKey;//"sk_test_51P7ieiSDxYMGVZ7t6U4fH2gxmiVQW7RsGFpx8zz2R7N77h4dIO3C3Cc4fgoczc59ehVniGY5HRvzXhMZeDvyknIe00GXwSXJOi";

//        PaymentLinkCreateParams params =
//                PaymentLinkCreateParams.builder()
//                        .addLineItem(
//                                PaymentLinkCreateParams.LineItem.builder()
//                                        .setPrice("{{PRICE_ID}}")
//                                        .setQuantity(1L)
//                                        .build()
//                        )
//                        .build();
        HashMap<String, Object> params = new HashMap<>();
        params.put("unit_amount",amount);
        params.put("currency","INR");

        HashMap<String,Object> productData = new HashMap<>();
        productData.put("name","iPhone 15 Pro max");
        Price price = Price.create(params);
        HashMap<String, Object> priceData = new HashMap<>();
        priceData.put("price",price);

        Map<String,Object> lineItems = new HashMap<>();
        lineItems.put("price",price.getId());

        List<Object> lineItemsList = new ArrayList<>();
        lineItemsList.add(lineItems);




        PaymentLink paymentLink = PaymentLink.create(params);
        return null;
    }
}
