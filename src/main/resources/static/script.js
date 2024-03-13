let loginBtn = document.getElementById("loginBtn");
let productBtn = document.getElementById("productBtn");
let orderBtn = document.getElementById("orderBtn");
let inspirationBtn = document.getElementById("inspirationBtn");
let homeBtn = document.getElementById("homeBtn");
let chartBtn = document.getElementById("chartBtn");
let logoutBtn = document.getElementById("logoutBtn");
let productBtnDiv = document.getElementById("productBtnDiv");
let pageContentDiv = document.getElementById("pageContentDiv");
let startContent = document.getElementById("startContent");
let loginContentDiv = document.getElementById("loginContentDiv");
let chartContentDiv = document.getElementById("chartContentDiv");
let customerNumber = localStorage.getItem("customerNumber");
let productContentDiv = document.getElementById("productContentDiv");
let startContentText = startContent;
let productBtnDiv = document.getElementById("productBtnDiv");
let productContentDiv = document.getElementById("productContentDiv");

if (customerNumber) {
    document.getElementById("chartBtn").style.display = "inline-block";
    document.getElementById("productBtn").style.display = "inline-block";
    document.getElementById("orderBtn").style.display = "inline-block";
    document.getElementById("logoutBtn").style.display = "inline-block";
    document.getElementById("loginBtn").style.display = "none";
}
let chartNumber = 3;

let buttonContent = chartBtn.innerHTML;

chartBtn.innerHTML = chartNumber + " " + buttonContent;


flush();
pageContentDiv.style.display = "block";
homeContent();

loginBtn.addEventListener("click", function () {
    console.log("loginBtn clicked");
    flush();

    document.getElementById("loginContentDiv").style.display = "block";

    loginContent();
});

productBtn.addEventListener("click", function () {
    console.log("productBtn clicked");
    flush();
    document.getElementById("productBtnDiv").style.display = "flow";
    productContent();

});
orderBtn.addEventListener("click", function () {
    console.log("orderBtn clicked");
    flush();
  
});
inspirationBtn.addEventListener("click", function () {
    console.log("inspirationBtn clicked");
    flush();
});
homeBtn.addEventListener("click", function () {
    console.log("homeBtn clicked");
    flush();
  
    document.getElementById("pageContentDiv").style.display = "block";

    homeContent();
});
chartBtn.addEventListener("click", function () {
    console.log("chartBtn clicked");
  
    document.getElementById('pageContentDiv').style.display = 'none';
    document.getElementById('loginContentDiv').style.display = 'none';
    document.getElementById("productContentDiv").style.display = "none";
    document.getElementById("productBtnDiv").style.display = "none";

    pageContentDiv.innerHTML = "";
    loginContentDiv.innerHTML = "";
    productContentDiv.innerHTML = "";
    productBtnDiv.innerHTML = "";
  
    if (document.getElementById("chartContentDiv").style.display === "none") {
        flush();
        document.getElementById("pageContentDiv").style.display = "none";
        document.getElementById("loginContentDiv").style.display = "none";
        document.getElementById("chartContentDiv").style.display = "block";
        chartContent();
    } else {
        flush();
        document.getElementById("pageContentDiv").style.display = "block";
        document.getElementById("loginContentDiv").style.display = "none";
        document.getElementById("chartContentDiv").style.display = "none";
        homeContent();
    }
});
logoutBtn.addEventListener("click", function () {
    localStorage.removeItem("customerNumber");
    document.getElementById("chartBtn").style.display = "none";
    document.getElementById("orderBtn").style.display = "none";
    document.getElementById("logoutBtn").style.display = "none";
    document.getElementById("loginBtn").style.display = "inline-block";
    flush();
    homeContent();
    document.getElementById("pageContentDiv").style.display = "block";
});

function flush() {
    pageContentDiv.innerHTML = "";
    loginContentDiv.innerHTML = "";
    chartContentDiv.innerHTML = "";
    productContentDiv.innerHTML = "";
    productBtnDiv.innerHTML = "";
    document.getElementById('pageContentDiv').style.display = 'none';
    document.getElementById('loginContentDiv').style.display = 'none';
    document.getElementById("productContentDiv").style.display = "none";
    document.getElementById("productBtnDiv").style.display = "none";
    document.getElementById("chartContentDiv").style.display = "none";

}

function loginContent() {
    let loginEmail = document.createElement("h1");
    loginEmail.innerHTML = "E-mail: <input type='text' id='text' name='email'><br><br>";

    let loginPassword = document.createElement("h1");
    loginPassword.innerHTML = "Lösenord: <input type='password' id='password' name='password'><br><br>";

    let loginUserBtn = document.createElement("button");
    loginUserBtn.innerHTML = "Logga in";
    loginUserBtn.className = "formBtns";

    let cancelBtn = document.createElement("button");
    cancelBtn.innerHTML = "Avbryt";
    cancelBtn.style.marginLeft = "65px";
    cancelBtn.className = "formBtns";

    let registerBtn = document.createElement("button");
    registerBtn.innerHTML = "Registrera";
    registerBtn.style.float = "right";
    registerBtn.className = "formBtns";

    loginContentDiv.appendChild(loginEmail);
    loginContentDiv.appendChild(loginPassword);
    loginContentDiv.appendChild(loginUserBtn);
    loginContentDiv.appendChild(cancelBtn);
    loginContentDiv.appendChild(registerBtn);

    cancelBtn.addEventListener("click", function () {
        console.log("cancelBtn clicked");
        flush();
        document.getElementById("pageContentDiv").style.display = "block";
        document.getElementById("loginContentDiv").style.display = "none";
        homeContent();
    });

    registerBtn.addEventListener("click", function () {
        console.log("registerBtn clicked");
        flush();
        document.getElementById("pageContentDiv").style.display = "none";
        document.getElementById("loginContentDiv").style.display = "block";
        showRegisterForm();
    });
    loginUserBtn
        .addEventListener("click", function () {
            let email = document.getElementById("text").value;
            let password = document.getElementById("password").value;

            let loginDetails = {
                email: email,
                password: password,
            };
            console.log(email, password);

            fetch("http://localhost:8080/customer/login", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(loginDetails),
            })
                .then((response) => {
                    if (!response.ok) {
                        throw new Error(`HTTP error! status: ${response.status}`);
                    }
                    return response.json();
                })
                .then((customer) => {
                    console.log(customer);
                    flush();
                    let loginSucces = document.createElement("h1");
                    loginSucces.innerHTML = "Välkommen " + customer.name;
                    localStorage.setItem("customerNumber", customer.customerNumber);
                    document.getElementById("chartBtn").style.display = "inline-block";
                    document.getElementById("orderBtn").style.display = "inline-block";
                    document.getElementById("logoutBtn").style.display = "inline-block";
                    document.getElementById("loginBtn").style.display = "none";
                    loginContentDiv.appendChild(loginSucces);
                });
        })
        .catch((error) => {
            console.error("Error:", error);
        });
}

function productContent(){
    
    let manBtn = document.createElement('button');
    manBtn.innerHTML = "Herr";
    manBtn.style.marginLeft = "40px";
    manBtn.className = "manProductBtns";

    let womanBtn = document.createElement('button');
    womanBtn.innerHTML = "Dam";
    womanBtn.style.marginLeft = "40px";
    womanBtn.className = "womanProductBtns";
    
    productBtnDiv.appendChild(manBtn);
    productBtnDiv.appendChild(womanBtn);
        
    manBtn.addEventListener("click", function() { 
        console.log("manBtn clicked");
        flush();
      
        document.getElementById('productContentDiv').style.display = 'block';
        showManProducts();
    });

    womanBtn.addEventListener("click", function() { 
        console.log("womanBtn clicked");
        flush();
      
        document.getElementById('productContentDiv').style.display = 'block';
        showWomanProducts();
    });

}

function homeContent() {
    let homeContent = document.createElement("h1");
    homeContent.innerHTML = startContentText.innerText;
    pageContentDiv.appendChild(homeContent);
}

function showRegisterForm() {
    let registerName = document.createElement("h3");
    registerName.innerHTML = "Namn: <br><input type='text' id='name' name='name'><br><br>";

    let registerEmail = document.createElement("h3");
    registerEmail.innerHTML = "E-mail: <br><input type='text' id='email' name='email'><br><br>";

    let registerPassword = document.createElement("h3");
    registerPassword.innerHTML = "Lösenord: <br><input type='password' id='password' name='password'><br><br>";

    let confirmPassword = document.createElement("h3");
    confirmPassword.innerHTML = "Bekräfta lösenord: <br><input type='password' id='confirmPassword' name='confirmPassword'><br><br>";

    let registerAdress = document.createElement("h3");
    registerAdress.innerHTML = "Adress: <br><input type='text' id='adress' name='adress'><br><br>";

    let registerPayment = document.createElement("h3");
    registerPayment.innerHTML = "Betalning: <br><input type='hidden' id='payment' name='payment' value='none'><br><br>";

    let cancelBtn = document.createElement("button");
    cancelBtn.innerHTML = "Avbryt";
    cancelBtn.style.marginLeft = "20px";
    cancelBtn.className = "formBtns";

    let registerNewBtn = document.createElement("button");
    registerNewBtn.innerHTML = "Registrera";
    registerNewBtn.style.float = "right";
    registerNewBtn.className = "formBtns";

    loginContentDiv.appendChild(registerName);
    loginContentDiv.appendChild(registerEmail);
    loginContentDiv.appendChild(registerPassword);
    loginContentDiv.appendChild(confirmPassword);
    loginContentDiv.appendChild(registerAdress);
    loginContentDiv.appendChild(registerPayment);
    loginContentDiv.appendChild(registerNewBtn);
    loginContentDiv.appendChild(cancelBtn);

    cancelBtn.addEventListener("click", function () {
        console.log("cancelBtn clicked");
        flush();
        document.getElementById("pageContentDiv").style.display = "block";
        document.getElementById("loginContentDiv").style.display = "none";
        homeContent();
    });

    registerNewBtn.addEventListener("click", function () {
        let name = document.getElementById("name").value;
        let email = document.getElementById("email").value;
        let password = document.getElementById("password").value;
        let confirmPassword = document.getElementById("confirmPassword").value;
        let adress = document.getElementById("adress").value;
        let payment = document.getElementById("payment").value;

        if (!name || !email || !password || !confirmPassword || !adress) {
            alert("Du måste fylla i alla fält!");
            return;
        }

        if (password !== confirmPassword) {
            alert("Lösenord och bekräfta lösenord stämmer inte överens!");
            return;
        }

        let emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        if (!emailRegex.test(email)) {
            alert("Email är inte i korrekt format!");
            return;
        }

        if (password.length < 8) {
            alert("Lösenord måste minst vara 8 tecken långt!");
            return;
        }

        let customerDetails = {
            name: name,
            adress: adress,
            email: email,
            password: password,
            payment: payment,
        };
        alert("Registrering lyckades!");
        console.log(customerDetails);
        flush();
        document.getElementById("pageContentDiv").style.display = "block";
        document.getElementById("loginContentDiv").style.display = "none";
        homeContent();

        fetch("http://localhost:8080/customer/register", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(customerDetails),
        })
            .then((response) => response.json())
            .then((data) => console.log(data))
            .catch((error) => {
                console.error("Error:", error);
            });
    });
}

function chartContent() {
    let message = document.createElement("h3");
    message.innerHTML = "Inga varor i kundvagnen";

    let list = document.createElement("ul");

    let checkoutBtn = document.createElement("button");
    checkoutBtn.innerHTML = "Kassa";
    checkoutBtn.className = "formBtns";

    let emptyBtn = document.createElement("button");
    emptyBtn.innerHTML = "Rensa";
    emptyBtn.style.marginLeft = "70px";
    emptyBtn.className = "formBtns";

    let cancelBtn = document.createElement("button");
    cancelBtn.innerHTML = "Avbryt";
    cancelBtn.style.float = "right";
    cancelBtn.className = "formBtns";

    if (list.childNodes.length == 0) {
        chartContentDiv.appendChild(message);
    } else {
        chartContentDiv.appendChild(list);
    }

    chartContentDiv.appendChild(checkoutBtn);
    chartContentDiv.appendChild(emptyBtn);
    chartContentDiv.appendChild(cancelBtn);

    checkoutBtn.addEventListener("click", () => {
        console.log("checkoutBtn clicked");
        flush();
        let checkoutDiv = document.createElement("div");
        checkoutDiv.setAttribute("id", "checkout");
        console.log(checkoutDiv.getAttribute("id"));
        pageContentDiv.appendChild(checkoutDiv);
        initializeCheckoutSession();
    });
    cancelBtn.addEventListener("click", () => {
        console.log("cancelBtn clicked");
        flush();
        document.getElementById("pageContentDiv").style.display = "block";
        document.getElementById("loginContentDiv").style.display = "none";
        document.getElementById("chartContentDiv").style.display = "none";
        homeContent();
    });
}

function showManProducts() {
 
    let productTypes = ["bottom", "top", "shoes"];
    let imageNames = ["herrbyxor", "t-shirt_herr", "herrskor"];

    productTypes.forEach(function(productType, index) {

        fetch('http://localhost:8080/api/products/men/' + productType)
            .then(response => response.json())
            .then(products => {
                let manProductOutput = document.createElement("div");
                manProductOutput.className = "manOutput";
                products.forEach(product => {
                    manProductOutput.innerHTML += `
                        <p>${product.name}: ${product.price}</p>
                        <img src="../bilder/${imageNames[index]}.jpg" alt="${product.name}" width="200" height="200">
                        
                    `;
                });
                document.getElementById('productContentDiv').appendChild(manProductOutput);
            })
            .catch((error) => {
                console.error('Error:', error);
            });
    });
}

function showWomanProducts() {
 
    let productTypes = ["bottom", "top", "shoes"];
    let imageNames = ["dambyxor", "t-shirt_dam", "damskor"];

    productTypes.forEach(function(productType, index) {

        fetch('http://localhost:8080/api/products/woman/' + productType)
            .then(response => response.json())
            .then(products => {
                let womanProductOutput = document.createElement("div");
                womanProductOutput.className = "womanOutput";
                products.forEach(product => {
                    womanProductOutput.innerHTML += `
                        <p>${product.name}: ${product.price}</p>
                        <img src="../bilder/${imageNames[index]}.jpg" alt="${product.name}" width="200" height="200">
                    `;
                });
                document.getElementById('productContentDiv').appendChild(womanProductOutput);
            })
            .catch((error) => {
                console.error('Error:', error);
            });
    });
}
