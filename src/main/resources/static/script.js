let loginBtn = document.getElementById('loginBtn');
let productBtn = document.getElementById('productBtn');
let orderBtn = document.getElementById('orderBtn');
let inspirationBtn = document.getElementById('inspirationBtn');
let homeBtn = document.getElementById('homeBtn');
let chartBtn = document.getElementById('chartBtn');
let pageContentDiv = document.getElementById('pageContentDiv');
let startContent = document.getElementById('startContent');
let loginContentDiv = document.getElementById('loginContentDiv');
let startContentText = startContent;

let chartNumber = 3;

let buttonContent = chartBtn.innerHTML;

chartBtn.innerHTML = chartNumber + " " + buttonContent;

document.getElementById('loginContentDiv').style.display = 'none';

loginBtn.addEventListener("click", function() {
    console.log("loginBtn clicked");
    flush();
    document.getElementById('pageContentDiv').style.display = 'none';
    document.getElementById('loginContentDiv').style.display = 'block';
    loginContent();
});

productBtn.addEventListener("click", function() {
    console.log("productBtn clicked");
    flush();
    document.getElementById('pageContentDiv').style.display = 'none';
    document.getElementById('loginContentDiv').style.display = 'none';
});
orderBtn.addEventListener("click", function() {
    console.log("orderBtn clicked");
    flush();
    document.getElementById('pageContentDiv').style.display = 'none';
    document.getElementById('loginContentDiv').style.display = 'none';
});
inspirationBtn.addEventListener("click", function() {
    console.log("inspirationBtn clicked");
    flush();
    document.getElementById('pageContentDiv').style.display = 'none';
    document.getElementById('loginContentDiv').style.display = 'none';
});
homeBtn.addEventListener("click", function() {
    console.log("homeBtn clicked");
    flush();
    document.getElementById('pageContentDiv').style.display = 'block';
    document.getElementById('loginContentDiv').style.display = 'none';
    homeContent();
});
chartBtn.addEventListener("click", function() {
    console.log("chartBtn clicked");
    flush();
    document.getElementById('pageContentDiv').style.display = 'none';
    document.getElementById('loginContentDiv').style.display = 'none';
});

function flush() {
    pageContentDiv.innerHTML = "";
    loginContentDiv.innerHTML = "";
}

function loginContent() {
    let loginEmail = document.createElement('h1');
    loginEmail.innerHTML = "E-mail: <input type='text' id='text' name='email'><br><br>";

    let loginPassword = document.createElement('h1');
    loginPassword.innerHTML = "Lösenord: <input type='password' id='password' name='password'><br><br>";

    let loginBtn = document.createElement('button');
    loginBtn.innerHTML = "Logga in";
    loginBtn.className = "formBtns";

    let cancelBtn = document.createElement('button');
    cancelBtn.innerHTML = "Avbryt";
    cancelBtn.style.marginLeft = "65px";
    cancelBtn.className = "formBtns";

    let registerBtn = document.createElement('button');
    registerBtn.innerHTML = "Registrera";
    registerBtn.style.float = "right";
    registerBtn.className = "formBtns";

    loginContentDiv.appendChild(loginEmail);
    loginContentDiv.appendChild(loginPassword);
    loginContentDiv.appendChild(loginBtn);
    loginContentDiv.appendChild(cancelBtn);
    loginContentDiv.appendChild(registerBtn);

    cancelBtn.addEventListener("click", function() {
        console.log("cancelBtn clicked");
        flush();
        document.getElementById('pageContentDiv').style.display = 'block';
        document.getElementById('loginContentDiv').style.display = 'none';
        homeContent();
    });

    registerBtn.addEventListener("click", function() { 
        console.log("registerBtn clicked");
        flush();
        document.getElementById('pageContentDiv').style.display = 'none';
        document.getElementById('loginContentDiv').style.display = 'block';
        showRegisterForm();
    });
}

function homeContent() {
    let homeContent = document.createElement('h1');
    homeContent.innerHTML = startContentText.innerText;
    pageContentDiv.appendChild(homeContent);
}

function showRegisterForm() {
    let registerName = document.createElement('h3');
    registerName.innerHTML = "Namn: <input type='text' id='name' name='name'><br><br>";

    let registerEmail = document.createElement('h3');
    registerEmail.innerHTML = "E-mail: <input type='text' id='email' name='email'><br><br>";

    let registerPassword = document.createElement('h3');
    registerPassword.innerHTML = "Lösenord: <input type='password' id='password' name='password'><br><br>";

    let confirmPassword = document.createElement('h3');
    confirmPassword.innerHTML = "Bekräfta lösenord: <input type='password' id='confirmPassword' name='confirmPassword'><br><br>";

    let registerAdress = document.createElement('h3');
    registerAdress.innerHTML = "Adress: <input type='text' id='adress' name='adress'><br><br>";

    let registerPayment = document.createElement('h3');
    registerPayment.innerHTML = "Betalning: <input type='hidden' id='payment' name='payment' value='none'><br><br>";

    let cancelBtn = document.createElement('button');
    cancelBtn.innerHTML = "Avbryt";
    cancelBtn.style.marginLeft = "20px";
    cancelBtn.className = "formBtns";

    let registerNewBtn = document.createElement('button');
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

    cancelBtn.addEventListener("click", function() {
        console.log("cancelBtn clicked");
        flush();
        document.getElementById('pageContentDiv').style.display = 'block';
        document.getElementById('loginContentDiv').style.display = 'none';
        homeContent();
    });
    
    registerNewBtn.addEventListener("click", function() { 
    let name = document.getElementById('name').value;
    let email = document.getElementById('email').value;
    let password = document.getElementById('password').value;
    let confirmPassword = document.getElementById('confirmPassword').value;
    let adress = document.getElementById('adress').value;
    let payment = document.getElementById('payment').value;


    if (!name || !email || !password || !confirmPassword || !adress) {
        alert('Du måste fylla i alla fält!');
        return;
    }

    if (password !== confirmPassword) {
        alert('Lösenord och bekräfta lösenord stämmer inte överens!');
        return;
    }

    let emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(email)) {
        alert('Email är inte i korrekt format!');
        return;
    }
    
    if (password.length < 8) {
        alert('Lösenord måste minst vara 8 tecken långt!');
        return;
        }

    let customerDetails = {
        name: name,
        adress: adress,
        email: email,
        password: password,
        payment: payment
    };
    alert('Registrering lyckades!');
    console.log(customerDetails);
    flush();
    document.getElementById('pageContentDiv').style.display = 'block';
    document.getElementById('loginContentDiv').style.display = 'none';
    homeContent();

    fetch('http://localhost:8080/customer/register', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(customerDetails)
    })
    .then(response => response.json())
    .then(data => console.log(data))
    .catch((error) => {
        console.error('Error:', error);
    });
    });

}
