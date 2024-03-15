package com.MVP_Grupp2.MVP_Grupp2.Controller;

import java.util.*;
import org.springframework.web.bind.annotation.*;
import com.stripe.Stripe;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import com.stripe.param.checkout.SessionCreateParams.LineItem;

@RestController
public class CheckoutController {
    @PostMapping("/create-checkout-session")
    public Map<String, String> createCheckoutSession() {

        Stripe.apiKey = "sk_test_51OmWP0DYlwtrgVcMUgWLNGfpXVs8IHt2nJHp4g5vRZKIvmIIWGUS1uYMjeIDl1BNVZQLC4ryedpIJ4cA4AFeyRRc003bsWz612";

        SessionCreateParams params = SessionCreateParams.builder()
                .setUiMode(SessionCreateParams.UiMode.EMBEDDED)
                .setMode(SessionCreateParams.Mode.PAYMENT)
                .setReturnUrl("http://127.0.0.1:5500/MVP_Grupp2/src/main/resources/templates/confirmed.html")
                .addLineItem(
                        addProduct(
                                "Strumpa",
                                "https://www.strumpbudet.se/cdn/shop/products/roligastrumporkorvbla.jpg?v=1664797809",
                                20000L,
                                10L))
                .build();

        Map<String, String> map = new HashMap<>();
        try {
            map.put("clientSecret",
                    Session.create(params).getRawJsonObject().getAsJsonPrimitive("client_secret").getAsString());
        } catch (Exception e) {
            System.out.println("Fel: " + e.getMessage());
        }

        return map;
    }

    private LineItem addProduct(String title, String imagePath, Long price, Long quantity) {
        return SessionCreateParams.LineItem.builder()
            .setPriceData(
                SessionCreateParams.LineItem.PriceData.builder()
                    .setCurrency("sek")
                    .setProductData(
                        SessionCreateParams.LineItem.PriceData.ProductData.builder()
                        .setName(title)
                        .addImage(imagePath)
                        .build()
                     )
                    .setUnitAmount(price)
                    .build()
            )
            .setQuantity(quantity)
            .build();
    }
}