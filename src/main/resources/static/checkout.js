const stripe = Stripe("pk_test_51OqXrwITRkRLeIiFw7GXzcCkfnG3sjv6O8pX344pLBeWmp0evITiPKcymd7cd4VzD4t1gTDfNZo2VAw0616SKYlj00FiEa37vb");
let checkout = null;

async function initializeCheckoutSession() {
    const response = await fetch("http://localhost:8080/create-checkout-session", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: localStorage.getItem("cart"),
    });
    const { clientSecret } = await response.json();
    checkout = await stripe.initEmbeddedCheckout({
        clientSecret,
    });
    checkout.mount("#checkout");
}