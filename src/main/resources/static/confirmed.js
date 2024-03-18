let countdown = document.getElementById("countdown");
countdown.innerHTML = 5;
localStorage.removeItem("cart");
setInterval(() => {
    countdown.innerHTML = countdown.innerHTML - 1;
    if (countdown.innerHTML == "0") {
        window.location.replace("index.html");
    }
}, 1000);
