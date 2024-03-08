const stripe = Stripe("pk_test_51OmWP0DYlwtrgVcMwJHIMlNRU3WSPoDMSVpVmoxwO4XIHwIkR6UjU7qpc5GrIQULzPPrrNRA6PUtkUcvB8npFW3400LGqj3zkD");
initialize();

async function initialize() {
    const response = await fetch("/create-checkout-session", {
        method: "POST",
    });
    const { clientSecret } = await response.json();
    const checkout = await stripe.initEmbeddedCheckout({
        clientSecret,
    });
    checkout.mount("#checkout");
}
