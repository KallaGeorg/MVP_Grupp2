"use strict";

// Klass för en produkt i JavaScript.
class Item {
    name;
    image;
    price;
    count; // Antal, hur många exemplar

    constructor(name, image, price, count) {
        this.name = name;
        this.image = image;
        this.price = price;
        this.count = count;
    }
}
