let countdown = document.getElementById("countdown");
countdown.innerHTML = 10;
setInterval(() => {
    countdown.innerHTML = countdown.innerHTML - 1;
    if (countdown.innerHTML == "0") {
        window.location.replace("http://localhost:8080/checkout");
    }
}, 1000);
