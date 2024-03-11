package com.MVP_Grupp2.MVP_Grupp2.Controller;

import java.util.*;
import org.springframework.web.bind.annotation.*;
import com.stripe.Stripe;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;

@RestController
public class CheckoutController {
    @PostMapping("/create-checkout-session")
    public Map<String, String> createCheckoutSession() {
        Stripe.apiKey = "sk_test_51OmWP0DYlwtrgVcMUgWLNGfpXVs8IHt2nJHp4g5vRZKIvmIIWGUS1uYMjeIDl1BNVZQLC4ryedpIJ4cA4AFeyRRc003bsWz612";
        SessionCreateParams params = SessionCreateParams.builder()
            .setUiMode(SessionCreateParams.UiMode.EMBEDDED)
            .setMode(SessionCreateParams.Mode.PAYMENT)
            .setReturnUrl("http://localhost:8080/confirmed")
            .addLineItem(
                SessionCreateParams.LineItem.builder()
                    .setQuantity(1L)
                    .setPrice("price_1OpcxjDYlwtrgVcMpffSclxX")
                    .build())
            .addLineItem(
                SessionCreateParams.LineItem.builder()
                    .setQuantity(1L)
                    .setPrice("price_1OpcxjDYlwtrgVcMpffSclxX")
                    .build())
            .addLineItem(
                SessionCreateParams.LineItem.builder()
                    .setQuantity(1L)
                    .setPrice("price_1OpcwTDYlwtrgVcMhSmHZOTe")
                    .build())
            .build();
        Map<String, String> map = new HashMap<>();
        try {
            map.put("clientSecret", Session.create(params).getRawJsonObject().getAsJsonPrimitive("client_secret").getAsString());
        } catch (Exception e) {
            System.out.println("Fel: " + e.getMessage());
        }
        return map;
    }
}

/*
 * 
 * CustomerCreateParams customParams = CustomerCreateParams.builder()
 * .setName("Jenny Rosen")
 * .setEmail("jennyrosen@example.com")
 * .build();
 * Customer customer = null;
 * 
 * try {
 * Customer.create(customParams);
 * } catch (Exception e) {
 * 
 * }
 * 
 * ProductCreateParams productParams = ProductCreateParams.builder()
 * .setName("Strumpor")
 * .setDescription("Håller för evigt.")
 * .addImage(
 * "https://www.strumpbudet.se/cdn/shop/products/roligastrumporkorvbla.jpg?v=1664797809")
 * .build();
 * Product product = null;
 * 
 * try {
 * product = Product.create(productParams);
 * } catch (Exception e) {
 * 
 * }
 * 
 * PriceCreateParams priceParams = PriceCreateParams.builder()
 * .setCurrency("usd")
 * .setUnitAmount(1000L)
 * .setProductData(
 * PriceCreateParams.ProductData.builder()
 * .setName("Strumpor").build())
 * .build();
 * Price price = null;
 * try {
 * price = Price.create(priceParams);
 * } catch (Exception e) {
 * 
 * }
 */