document.addEventListener("DOMContentLoaded", function() {
    displayCart();
    document.getElementById('emptyCartButton').addEventListener('click', emptyCart);
});

function displayCart() {
    const tableBody = document.getElementById('cartTable').getElementsByTagName('tbody')[0];
    let cart = JSON.parse(localStorage.getItem('cart')) || [];
    let totalAmount = 0;

    cart.forEach((wine, index) => {
        const row = document.createElement('tr');

        const vinPictureCell = document.createElement('td');
        const vinPictureImage = document.createElement('img');
        vinPictureImage.src = wine.picture.trim();
        vinPictureImage.alt = 'Wine Picture';
        vinPictureImage.style.width = '100px';
        vinPictureImage.style.height = 'auto'; 
        vinPictureCell.appendChild(vinPictureImage);
        row.appendChild(vinPictureCell);

        const vinNameCell = document.createElement('td');
        vinNameCell.textContent = wine.name.trim();
        row.appendChild(vinNameCell);

        const quantityCell = document.createElement('td');
        const quantityWrapper = document.createElement('div');
        quantityWrapper.className = 'quantity-wrapper';

        const minusButton = document.createElement('button');
        minusButton.textContent = '-';
        minusButton.className = 'quantity-btn';
        minusButton.addEventListener('click', () => updateQuantity(index, wine.quantity - 1));

        const quantityDisplay = document.createElement('span');
        quantityDisplay.textContent = wine.quantity;
        quantityDisplay.className = 'quantity-display';

        const plusButton = document.createElement('button');
        plusButton.textContent = '+';
        plusButton.className = 'quantity-btn';
        plusButton.addEventListener('click', () => updateQuantity(index, wine.quantity + 1));

        quantityWrapper.appendChild(minusButton);
        quantityWrapper.appendChild(quantityDisplay);
        quantityWrapper.appendChild(plusButton);
        quantityCell.appendChild(quantityWrapper);
        row.appendChild(quantityCell);

        const priceCell = document.createElement('td');
        priceCell.textContent = `${(wine.price * wine.quantity).toFixed(2)}€`;
        priceCell.className = 'price-cell';
        row.appendChild(priceCell);

        tableBody.appendChild(row);

        totalAmount += wine.price * wine.quantity;
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