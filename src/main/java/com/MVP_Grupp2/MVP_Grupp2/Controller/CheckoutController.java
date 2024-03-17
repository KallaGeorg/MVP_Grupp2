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
        // Kontrollera att varukorgen inte är tom
        if (cart == null || cart.isEmpty()) {
            System.out.println("Varukorgen är tom.");
            return null;  // Eller någon annan lämplig åtgärd
        }

        Stripe.apiKey = "sk_test_51OqXrwITRkRLeIiFdqEOThrTuR8xjni3gObNCtcLUI2MuJ9zTxh5IqWVYGlmxxh8Smmaphdj7BEMnsSik1w8QARq0060TSlul9";
        List<LineItem> lineItems = new ArrayList<>();
        for (Item item : cart) {
            String stripeProductId = item.getStripeProductId();
            // Kontrollera att produkt-ID:t är giltigt
            if (stripeProductId != null && !stripeProductId.isEmpty()) {
                try {
                    com.stripe.model.Product stripeProduct = com.stripe.model.Product.retrieve(item.getStripeProductId());
                    String name = stripeProduct.getName();
                    String imagePath = stripeProduct.getImages().get(0);  // Hämta den första bilden
                    Long price = item.getPrice();  // Antag att priset fortfarande kommer från din `Item`
                    lineItems.add(addProduct(name, imagePath, price, item.getCount()));
                } catch (Exception e) {
                    System.out.println("Fel: " + e.getMessage());
                }
            } else {
                System.out.println("Ogiltig produkt-ID: " + stripeProductId);
            }
        }

        // Kontrollera att lineItems inte är tom
        if (lineItems.isEmpty()) {
            System.out.println("Inga produkter att lägga till i kassan.");
            return null;  // Eller någon annan lämplig åtgärd
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