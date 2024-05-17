document.addEventListener("DOMContentLoaded", function() {
    displayCart();
    document.getElementById('emptyCartButton').addEventListener('click', emptyCart);
    document.getElementById('buyButton').addEventListener('click', buyProducts);
});

function displayCart() {
    const tableBody = document.getElementById('cartTable').getElementsByTagName('tbody')[0];
    let cart = JSON.parse(localStorage.getItem('cart')) || [];
    let totalAmount = 0;

    cart.forEach((vin, index) => {
        const row = document.createElement('tr');

        const vinNameCell = document.createElement('td');
        vinNameCell.textContent = vin.nom.trim();
        row.appendChild(vinNameCell);

        const quantityCell = document.createElement('td');
        const quantityWrapper = document.createElement('div');
        quantityWrapper.className = 'quantity-wrapper';

        const minusButton = document.createElement('button');
        minusButton.textContent = '-';
        minusButton.className = 'quantity-btn';
        minusButton.addEventListener('click', () => updateQuantity(index, vin.quantity - 1));

        const quantityDisplay = document.createElement('span');
        quantityDisplay.textContent = vin.quantity;
        quantityDisplay.className = 'quantity-display';

        const plusButton = document.createElement('button');
        plusButton.textContent = '+';
        plusButton.className = 'quantity-btn';
        plusButton.addEventListener('click', () => updateQuantity(index, vin.quantity + 1));

        quantityWrapper.appendChild(minusButton);
        quantityWrapper.appendChild(quantityDisplay);
        quantityWrapper.appendChild(plusButton);
        quantityCell.appendChild(quantityWrapper);
        row.appendChild(quantityCell);

        const priceCell = document.createElement('td');
        priceCell.textContent = `${(vin.prix * vin.quantity).toFixed(2)}€`;
        priceCell.className = 'price-cell';
        row.appendChild(priceCell);

        tableBody.appendChild(row);

        totalAmount += vin.prix * vin.quantity;
    });

    document.getElementById('totalAmount').textContent = `Montant total: ${totalAmount.toFixed(2)}€`;
}

function updateQuantity(index, newQuantity) {
    let cart = JSON.parse(localStorage.getItem('cart')) || [];
    if (newQuantity > 0) {
        cart[index].quantity = newQuantity;
    } else {
        cart.splice(index, 1);
    }
    localStorage.setItem('cart', JSON.stringify(cart));
    refreshCart();
}

function refreshCart() {
    const tableBody = document.getElementById('cartTable').getElementsByTagName('tbody')[0];
    tableBody.innerHTML = '';
    displayCart();
}

function emptyCart() {
    localStorage.removeItem('cart');
    refreshCart();
}

function buyProducts() {
    let cart = JSON.parse(localStorage.getItem('cart')) || [];
    const promises = cart.map(vin => {
        console.log(`Sending PUT request for vin ID: ${vin.referencevin} with quantity: ${vin.quantite - vin.quantity}`);
        return fetch(`http://localhost:8080/Vin/UpdateStock/${vin.referencevin}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                quantite: vin.quantite - vin.quantity
            })
        }).then(response => {
            if (!response.ok) {
                throw new Error(`Failed to update stock for vin ID: ${vin.referencevin}`);
            }
            return response.json();
        }).then(data => {
            console.log(`Success response for vin ID: ${vin.referencevin}:`, data);
            return data;
        }).catch(error => {
            console.error(`Error response for vin ID: ${vin.referencevin}:`, error);
            throw error;
        });
    });

    Promise.all(promises)
        .then(data => {
            alert('Achat effectué avec succès !');
            emptyCart();
        })
        .catch(error => {
            console.error('Error:', error);
            alert('Erreur lors de l\'achat. Veuillez réessayer.');
        });
}