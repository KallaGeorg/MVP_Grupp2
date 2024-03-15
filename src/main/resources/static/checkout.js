const stripe = Stripe("pk_test_51OmWP0DYlwtrgVcMwJHIMlNRU3WSPoDMSVpVmoxwO4XIHwIkR6UjU7qpc5GrIQULzPPrrNRA6PUtkUcvB8npFW3400LGqj3zkD");
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