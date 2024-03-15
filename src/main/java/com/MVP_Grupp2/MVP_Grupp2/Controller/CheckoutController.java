package com.MVP_Grupp2.MVP_Grupp2.Controller;

import java.util.*;
import org.springframework.web.bind.annotation.*;
import com.MVP_Grupp2.MVP_Grupp2.Model.Item;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.stripe.Stripe;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import com.stripe.param.checkout.SessionCreateParams.LineItem;

@RestController
public class CheckoutController {
    @PostMapping("/create-checkout-session")
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    public Map<String, String> createCheckoutSession(@RequestBody List<Item> cart) {
        Stripe.apiKey = "sk_test_51OmWP0DYlwtrgVcMUgWLNGfpXVs8IHt2nJHp4g5vRZKIvmIIWGUS1uYMjeIDl1BNVZQLC4ryedpIJ4cA4AFeyRRc003bsWz612";
        List<LineItem> lineItems = new ArrayList<>();
        for (Item item : cart) {
            lineItems.add(addProduct(
                item.getName(),
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSmmA0rmPVNNxzgIVKhml78459yH03aSZqKgsFhOc0X01v9BkQaywliXY9KJB-aiXiyjx8&usqp=CAU",
                item.getPrice(),
                item.getCount()));
        }
                                
        SessionCreateParams params = SessionCreateParams.builder()
                .setUiMode(SessionCreateParams.UiMode.EMBEDDED)
                .setMode(SessionCreateParams.Mode.PAYMENT)
                .setReturnUrl("http://127.0.0.1:5500/MVP_Grupp2/src/main/resources/templates/confirmed.html")
                .addAllLineItem(
                        lineItems)
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