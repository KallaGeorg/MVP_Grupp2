"use strict";

class Cart {

    
    // Kundvagnen är egentligen bara är en array/lista.
    #cart;

    constructor() {
        this.#cart = [];
        // Har vi några produkter i localStorage när scriptet läses in? Då lägger vi till produkterna i listan.
        if (localStorage.getItem("cart") != null) {
            this.loadCart();
        }
    }

    // Sparar kundvagnen till localstorage.
    saveCart() {
        localStorage.setItem("cart", JSON.stringify(this.#cart));
    }

    // Hämtar kundvagnen från localstorage.
    loadCart() {
        this.#cart = JSON.parse(localStorage.getItem("cart"));
    }

    // Lägger till en vara till varukorgen.
    addItemToCart(name, image, price, count) {
        for (let item in this.#cart) {
            if (this.#cart[item].name === name) {
                this.#cart[item].count++;
                this.saveCart();
                return;
            }
        }
        this.#cart.push(new Item(name, image, price, count));
        this.saveCart();
    }

    // Ändrar antalet av en viss produkt.
    setCountForItem(name, count) {
        for (let i in this.#cart) {
            if (this.#cart[i].name === name) {
                this.#cart[i].count = count;
                break;
            }
        }
        this.saveCart();
    }

    // Ta bort ett exemplar av ett föremål från kundvagnen.
    removeItemFromCart(name) {
        for (let item in this.#cart) {
            if (this.#cart[item].name === name) {
                this.#cart[item].count--;
                if (this.#cart[item].count === 0) {
                    this.#cart.splice(item, 1);
                }
                break;
            }
        }
        this.saveCart();
    }

    // Ta bort alla exemplar av en produkt.
    removeItemFromCartAll(name) {
        for (let item in this.#cart) {
            console.log(this.#cart[item].name);
            if (this.#cart[item].name === name) {
                this.#cart.splice(item, 1);
                break;
            }
        }
        this.saveCart();
    }

    // Tömmer hela varukorgen.
    clearCart() {
        this.#cart = [];
        this.saveCart();
    }

    // Antalet produkter i varukorgen.
    totalCount() {
        let totalCount = 0;
        for (let item in this.#cart) {
            totalCount += this.#cart[item].count;
        }
        return totalCount;
    }

    // Räknar ut det totala priset för alla produkter i varukorgen.
    totalCart() {
        let totalCart = 0;
        for (let item in this.#cart) {
            totalCart += this.#cart[item].price * this.#cart[item].count;
        }
        return Number(totalCart.toFixed(2));
    }

    // Returnerar en kopia (ett objekt) av varukorgen med alla produkter.
    listCart() {
        let cartCopy = [];
        for (let i in this.#cart) {
            let item = this.#cart[i];
            let itemCopy = {};
            for (let p in item) {
                itemCopy[p] = item[p];
            }
            itemCopy.total = Number(item.price * item.count).toFixed(2);
            cartCopy.push(itemCopy);
        }
        return cartCopy;
    }
}

/*  // Skapar ny kundvagn och testar lite.
const cart = new Cart();
// Funkar
cart.addItemToCart("Tröja", "bild här", 500, 1);
cart.addItemToCart("Strumpa", "bild här", 500, 1);
cart.addItemToCart("Skor", "bild här", 7800, 1);
// Funkar
cart.clearCart();
cart.addItemToCart("Skor", "bild här", 7800, 3);
// Funkar
cart.removeItemFromCart("Skor");
// Funkar
cart.setCountForItem("Skor", 50);
// Funkar
console.log(cart.totalCount());
// Funkar
console.log(cart.listCart());   */
