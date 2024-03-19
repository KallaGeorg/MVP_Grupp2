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
let cart = new Cart();

if (customerNumber) {
    chartBtn.style.display = "inline-block";
    productBtn.style.display = "inline-block";
    orderBtn.style.display = "inline-block";
    logoutBtn.style.display = "inline-block";
    loginBtn.style.display = "none";
} else {
    chartBtn.style.display = "none";
    productBtn.style.display = "none";
    orderBtn.style.display = "none";
    logoutBtn.style.display = "none";
    loginBtn.style.display = "inline-block";
}
chartBtn.innerHTML = cart.totalCount() + " " + chartBtn.innerHTML;
flush();
pageContentDiv.style.display = "block";
homeContent();

function flush() {
    pageContentDiv.innerHTML = "";
    loginContentDiv.innerHTML = "";
    chartContentDiv.innerHTML = "";
    productContentDiv.innerHTML = "";
    productBtnDiv.innerHTML = "";
    pageContentDiv.style.display = "none";
    loginContentDiv.style.display = "none";
    productContentDiv.style.display = "none";
    productBtnDiv.style.display = "none";
    chartContentDiv.style.display = "none";
}

loginBtn.addEventListener("click", function () {
    console.log("loginBtn clicked");
    flush();
    loginContentDiv.style.display = "block";
    loginContent();
});

productBtn.addEventListener("click", function () {
    console.log("productBtn clicked");
    flush();
    productBtnDiv.style.display = "flow";
    productContent();
});

orderBtn.addEventListener("click", function () {
    console.log("orderBtn clicked");
    flush();
    let construction = document.createElement("h1");
    construction.innerHTML = "Under konstruktion...";
    loginContentDiv.style.display = "block";
    loginContentDiv.appendChild(construction);
    loginContentDiv.style.width = "900px";
    loginContentDiv.style.height = "150px";
    
});

inspirationBtn.addEventListener("click", function () {
    console.log("inspirationBtn clicked");
    flush();
    displayInspirationContent();
});

homeBtn.addEventListener("click", function () {
    console.log("homeBtn clicked");
    flush();
    pageContentDiv.style.display = "block";
    homeContent();
});

chartBtn.addEventListener("click", function () {
    console.log("chartBtn clicked");
    if (chartContentDiv.style.display === "none") {
        flush();
        chartContentDiv.style.display = "flow";
        chartContent();
    } else {
        flush();
        pageContentDiv.style.display = "block";
        homeContent();
    }
});

logoutBtn.addEventListener("click", function () {
    localStorage.removeItem("customerNumber");
    localStorage.removeItem("cart");
    cart.clearCart();
    chartBtn.style.display = "none";
    orderBtn.style.display = "none";
    logoutBtn.style.display = "none";
    loginBtn.style.display = "inline-block";
    productBtn.style.display = "none";
    flush();
    homeContent();
    pageContentDiv.style.display = "block";
    location.reload();
});

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
        pageContentDiv.style.display = "block";
        loginContentDiv.style.display = "none";
        homeContent();
    });

    registerBtn.addEventListener("click", function () {
        console.log("registerBtn clicked");
        flush();
        pageContentDiv.style.display = "none";
        loginContentDiv.style.display = "block";
        showRegisterForm();
    });

    loginUserBtn.addEventListener("click", function () {
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
            chartBtn.style.display = "inline-block";
            orderBtn.style.display = "inline-block";
            logoutBtn.style.display = "inline-block";
            productBtn.style.display = "inline-block";
            loginContentDiv.style.display = "block";
            loginBtn.style.display = "none";
            loginContentDiv.appendChild(loginSucces);
        })
        .catch((error) => {
                console.error("Error:", error);
        });

    });
}

function productContent() {
    let manBtn = document.createElement("button");
    manBtn.innerHTML = "Herr";
    manBtn.style.marginLeft = "40px";
    manBtn.className = "manProductBtns";

    let womanBtn = document.createElement("button");
    womanBtn.innerHTML = "Dam";
    womanBtn.style.marginLeft = "40px";
    womanBtn.className = "womanProductBtns";

    productBtnDiv.appendChild(manBtn);
    productBtnDiv.appendChild(womanBtn);

    manBtn.addEventListener("click", function () {
        console.log("manBtn clicked");
        flush();

        document.getElementById("productContentDiv").style.display = "block";
        showManProducts();
    });

    womanBtn.addEventListener("click", function () {
        console.log("womanBtn clicked");
        flush();

        document.getElementById("productContentDiv").style.display = "block";
        showWomanProducts();
    });
}

function homeContent() {
    let homeContent = document.createElement("h1");
    homeContent.innerHTML = startContentText.innerText;
    pageContentDiv.appendChild(homeContent);
    pageContentDiv.style.width = "900px";
    pageContentDiv.style.height = "150px";
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
    message.innerHTML = "Här är kundvagnen";

    let list = document.createElement("ul");
    list.setAttribute("id", "cart"); // Lägg till ett id för att kunna hitta elementet senare

    let checkoutBtn = document.createElement("button");
    checkoutBtn.innerHTML = "Kassa";
    checkoutBtn.className = "formBtns";
    checkoutBtn.style.display = "none"; // Gör knappen osynlig till en början

    let emptyBtn = document.createElement("button");
    emptyBtn.innerHTML = "Rensa";
    emptyBtn.style.float = "right";
    emptyBtn.className = "emptyBtn";
    emptyBtn.style.display = "none"; // Gör knappen osynlig till en början

    let cancelBtn = document.createElement("button");
    cancelBtn.innerHTML = "Avbryt";
    cancelBtn.style.float = "right";
    cancelBtn.className = "cancelBtn";

    chartContentDiv.appendChild(message);
    chartContentDiv.appendChild(list);
    chartContentDiv.appendChild(emptyBtn);
    chartContentDiv.appendChild(checkoutBtn);
    chartContentDiv.appendChild(cancelBtn);

    cancelBtn.addEventListener("click", () => {
        console.log("cancelBtn clicked");
        flush();
        document.getElementById("pageContentDiv").style.display = "block";
        document.getElementById("loginContentDiv").style.display = "none";
        document.getElementById("chartContentDiv").style.display = "none";
        homeContent();
    });

    displayCart();
}

function displayCart() {
    let cartDiv = document.getElementById("cart");
    cartDiv.className = "cart";
    cartDiv.innerHTML = "";

    let items = cart.listCart();
    let checkoutBtn = document.querySelector("#chartContentDiv button:nth-child(4)");
    let emptyBtn = document.querySelector("#chartContentDiv button:nth-child(3)");
    checkoutBtn.className = "checkoutBtn";
    emptyBtn.className = "emptyBtn";

    if (items.length === 0) {
        cartDiv.innerHTML = "Kundvagnen är tom!";
        checkoutBtn.style.display = "none";
        emptyBtn.style.display = "none";
    } else {
        emptyBtn.style.display = "flow";
        checkoutBtn.style.display = "flow";

        items.forEach((item) => {
            let itemDiv = document.createElement("div");
            itemDiv.className = "itemDiv";
            itemDiv.innerHTML = `
                <img src="../bilder/${item.image}" alt="${item.name}" width="70" height="70">
                <p> ${item.count}st ${item.name}: ${item.price} kr</p>
                <button class="removeBtn">Ta bort</button>
            `;
            cartDiv.append(itemDiv);

            let removeButton = itemDiv.querySelector(".removeBtn");
            removeButton.style.marginLeft = "70px";
            removeButton.className = "removeBtn";
            removeButton.addEventListener("click", () => {
                cart.removeItemFromCart(item.name);
                chartBtn.innerHTML = cart.totalCount() + chartBtn.innerHTML.substring(chartBtn.innerHTML.indexOf("<"))              
                displayCart();
            });
        });

        let totalDiv = document.createElement("div");
        totalDiv.innerHTML = `<p>Totalt: ${cart.totalCart()} kr</p>`;
        cartDiv.appendChild(totalDiv);
    }

    emptyBtn.addEventListener("click", () => {
        cart.clearCart();
        chartBtn.innerHTML = cart.totalCount() + chartBtn.innerHTML.substring(chartBtn.innerHTML.indexOf("<")); 
        displayCart();
    });

    checkoutBtn.addEventListener("click", () => {
        console.log("checkoutBtn clicked");
        flush();
        let checkoutDiv = document.createElement("div");
        checkoutDiv.setAttribute("id", "checkout");
        pageContentDiv.appendChild(checkoutDiv);
        document.getElementById("pageContentDiv").style.display = "block";
        if (checkout != null && checkout.embeddedCheckout.isDestroyed === false) {
            checkout.destroy("#checkout");
        }
        initializeCheckoutSession();
    });
}

function showManProducts() {
    let productTypes = ["bottom", "top", "shoes"];
    let imageNames = ["herrbyxor", "t-shirt_herr", "herrskor"];

    productTypes.forEach(function (productType, index) {
        fetch("http://localhost:8080/api/products/men/" + productType)
            .then((response) => response.json())
            .then((products) => {
                let manProductOutput = document.createElement("div");
                manProductOutput.className = "manOutput";
                products.forEach((product) => {
                    manProductOutput.innerHTML += `
                        <p>${product.name}: ${product.price} kr</p>
                        <img src="../bilder/${imageNames[index]}.jpg" alt="${product.name}" width="200" height="200">
                        
                    `;
                    let addToCartBtn = document.createElement("button");
                    addToCartBtn.innerText = "Lägg till i kundvagnen";
                    addToCartBtn.style.float = "right";
                    addToCartBtn.style.width = "250px";
                    addToCartBtn.style.height = "50px";
                    addToCartBtn.className = "formBtns";
                    addToCartBtn.addEventListener("click", function () {
                        cart.addItemToCart(product.name, "../bilder/" + imageNames[index] + ".jpg", product.price, 1, product.stripeProductId);
                        chartBtn.innerHTML = cart.totalCount() + chartBtn.innerHTML.substring(chartBtn.innerHTML.indexOf("<")); 
                    });
                    manProductOutput.appendChild(addToCartBtn);
                });
                document.getElementById("productContentDiv").appendChild(manProductOutput);
            })
            .catch((error) => {
                console.error("Error:", error);
            });
    });
}

function showWomanProducts() {
    let productTypes = ["bottom", "top", "shoes"];
    let imageNames = ["dambyxor", "t-shirt_dam", "damskor"];

    productTypes.forEach(function (productType, index) {
        fetch("http://localhost:8080/api/products/woman/" + productType)
            .then((response) => response.json())
            .then((products) => {
                let womanProductOutput = document.createElement("div");
                womanProductOutput.className = "womanOutput";
                products.forEach((product) => {
                    womanProductOutput.innerHTML += `
                        <p>${product.name}: ${product.price} kr</p>
                        <img src="../bilder/${imageNames[index]}.jpg" alt="${product.name}" width="200" height="200">
                    `;
                    let addToCartBtn = document.createElement("button");
                    addToCartBtn.innerText = "Lägg till i kundvagnen";
                    addToCartBtn.style.float = "right";
                    addToCartBtn.style.width = "250px";
                    addToCartBtn.style.height = "50px";
                    addToCartBtn.className = "formBtns";
                    addToCartBtn.addEventListener("click", function () {
                        cart.addItemToCart(product.name, "../bilder/" + imageNames[index] + ".jpg", product.price, 1, product.stripeProductId);
                        chartBtn.innerHTML = cart.totalCount() + chartBtn.innerHTML.substring(chartBtn.innerHTML.indexOf("<")); 
                    });
                    womanProductOutput.appendChild(addToCartBtn);
                });
                document.getElementById("productContentDiv").appendChild(womanProductOutput);
            })
            .catch((error) => {
                console.error("Error:", error);
            });
    });
}

function displayInspirationContent() {
    let formattedContent2 = `
    Modeindustrin har den största miljöpåverkan på världen. Därför är det viktigt att<br> vara medvetet
    om ursprunget av produkterna man köpa.<br>
    Med fokus på återanvändning är kvalitet av textila produkter självklart en stor <br>faktor
    för ett hållbart sätt att konsumera!<br><br>

    Vi vill inte bara sälja kläder, vi garantera även för kvalitet och vill uppmuntra till <br>att skänka bort kläderna
    till second hand butiker eller till vänner och familj så att våra textila <br>produkter har en lång livscirkel.
    <br><br>
    “Slow fashion” är i dagsläget en internationell initiativ och ett temat som innebär att
    ta<br> sitt ansvar för kommande generarationer på världen.<br><br> 
    Det finns mycket stöd för den internationella, gröna rörelsen.<br> Följer gärna länkarna för de top 10 av hållbara modeorganisationer och initiativer! Tack !
    `;

    let content1 = "Kan vi inspirera dig för mer hållbarhet?";
    let content2 = formattedContent2;

    let pageContentDiv = document.getElementById("pageContentDiv");

    pageContentDiv.style.display = "block";
    document.getElementById("loginContentDiv").style.display = "none";
    pageContentDiv.style.width = "1500px";
    pageContentDiv.style.height = "740px";

    let imageElement = document.createElement("img");
    imageElement.src = "../bilder/globe.jpg";
    imageElement.style.width = "200px";
    imageElement.style.height = "200px";
    imageElement.style.position = "absolute";
    imageElement.style.top = "150px";
    imageElement.style.left = "250px";

    let linksContainer1 = document.createElement("div");
    linksContainer1.style.position = "absolute";
    linksContainer1.style.bottom = "100px";
    linksContainer1.style.left = "520px";
    linksContainer1.style.width = "50%";
    // linksContainer1.style.textAlign = 'right';

    let linksContainer2 = linksContainer1.cloneNode();
    linksContainer2.style.left = "";
    linksContainer2.style.right = "-100px";
    // linksContainer2.style.textAlign = 'left';

    let links = [
        { text: "CSF (Center For Sustainable Fashion)", href: "https://www.sustainable-fashion.com" },
        { text: "Ellen Mac Arthur Foundation", href: "https://www.ellenmacarthurfoundation.org" },
        { text: "Fashion For Good", href: "https://fashionforgood.com" },
        { text: "Fashion Revolution", href: "https://www.fashionrevolution.org" },
        { text: "Good On You", href: "https://goodonyou.eco" },
        { text: "Global Fashion Agenda", href: "https://globalfashionagenda.org" },
        { text: "Slow Factory Foundation", href: "https://slowfactory.earth" },
        { text: "Cascale", href: "https://cascale.org" },
        { text: "Textile Exchange", href: "https://textileexchange.org" },
        { text: "United Nations Alliance for Sustainable Fashion", href: "https://unfashionalliance.org" },
    ];

    let linksSlice1 = links.slice(0, 5);
    let linksSlice2 = links.slice(5);

    createLinks(linksSlice1, linksContainer1);
    createLinks(linksSlice2, linksContainer2);

    function createLinks(linksSlice, container) {
        linksSlice.forEach((link) => {
            let linkElement = document.createElement("a");
            linkElement.href = link.href;
            linkElement.textContent = link.text;
            linkElement.style.display = "block";
            linkElement.classList.add("link");
            container.appendChild(linkElement);
        });
    }

    let textInspiration1 = document.createElement("span");
    let textInspiration2 = document.createElement("span");
    textInspiration1.textContent = content1;
    textInspiration2.innerHTML = content2;
    textInspiration1.classList.add("styleInspirationHeader");
    textInspiration2.classList.add("styleInspirationText");

    pageContentDiv.appendChild(imageElement);
    pageContentDiv.appendChild(textInspiration1);
    pageContentDiv.appendChild(textInspiration2);
    pageContentDiv.appendChild(linksContainer1);
    pageContentDiv.appendChild(linksContainer2);
}
