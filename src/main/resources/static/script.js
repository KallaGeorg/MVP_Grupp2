let loginBtn = document.getElementById('loginBtn');
let productBtn = document.getElementById('productBtn');
let orderBtn = document.getElementById('orderBtn');
let inspirationBtn = document.getElementById('inspirationBtn');
let homeBtn = document.getElementById('homeBtn');
let chartBtn = document.getElementById('chartBtn');
let pageContent = document.getElementById('pageContent');
let startContent = document.getElementById('startContent');
let startContentText = startContent;

let chartNumber = 3;

let buttonContent = chartBtn.innerHTML;

chartBtn.innerHTML = chartNumber + " " + buttonContent;

loginBtn.addEventListener("click", function() {
    console.log("loginBtn clicked");
    flush();
    loginContent();
    pageContent 
});
productBtn.addEventListener("click", function() {
    console.log("productBtn clicked");
});
orderBtn.addEventListener("click", function() {
    console.log("orderBtn clicked");
});
inspirationBtn.addEventListener("click", function() {
    console.log("inspirationBtn clicked");
});
homeBtn.addEventListener("click", function() {
    console.log("homeBtn clicked");
    flush();
    homeContent();
});
chartBtn.addEventListener("click", function() {
    console.log("chartBtn clicked");
});

function flush() {
    pageContent.innerHTML = "";
}

function loginContent() {
    let loginContent = document.createElement('h1');
    loginContent.innerHTML = "loginFormulär här!";
    pageContent.appendChild(loginContent);
}

function homeContent() {
    let homeContent = document.createElement('h1');
    homeContent.innerHTML = startContentText.innerText;
    pageContent.appendChild(homeContent);
}