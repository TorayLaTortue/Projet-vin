window.addEventListener('scroll', function() {
    var header = document.getElementById('main-header');
    if (window.scrollY > 100) {
        header.classList.add('header-scrolled');
    } else {
        header.classList.remove('header-scrolled');
    }
});

document.addEventListener("DOMContentLoaded", function() {
    fetch('http://localhost:8080/Wine/Wine')
        .then(response => response.json())
        .then(data => {
            displayVins(data);
        })
        .catch(error => console.error('Error:', error));
});

function displayVins(wines) {
    const selectedYear = parseInt(document.getElementById('yearFilter').value);
    const filteredWines = wines.filter(wine => new Date(wine.year).getFullYear() === selectedYear);

    const container = document.getElementById('vinContainer');
    container.innerHTML = ''; // Clear previous entries
    filteredWines.forEach(wine => {
        const vinCardWrapper = document.createElement('div');
        vinCardWrapper.className = 'vin-card-wrapper';

        const vinCard = document.createElement('div');
        vinCard.className = 'vin-card';
        vinCard.innerHTML = `
            <div class="vin-card-inner">
                <div class="vin-card-front">
                    <img src="${wine.picture}" alt="${wine.name}">
                    <h3>${wine.name}</h3>
                </div>
                <div class="vin-card-back">
                    <p>Région: ${wine.region}</p>
                    <p>Famille: ${wine.family}</p>
                    <p>Année: ${new Date(wine.year).getFullYear()}</p>
                    <p>Format: ${wine.format}</p>
                    <p class="promotion">Promotion: ${wine.discount * 100}%</p>
                </div>
            </div>
        `;

        const priceContainer = document.createElement('div');
        priceContainer.className = 'price-container';
        priceContainer.textContent = `${wine.price}€`;

        const addToCartButton = document.createElement('button');
        addToCartButton.className = 'add-to-cart-btn';
        addToCartButton.setAttribute('data-id', wine.wineReference);
        addToCartButton.textContent = 'Ajouter au panier';
        addToCartButton.addEventListener('click', function() {
            addToCart(wine);
        });

        vinCardWrapper.appendChild(vinCard);
        vinCardWrapper.appendChild(priceContainer);
        vinCardWrapper.appendChild(addToCartButton);
        container.appendChild(vinCardWrapper);
    });
}

function addToCart(wine) {
    let cart = JSON.parse(localStorage.getItem('cart')) || [];
    cart.push({ ...wine, quantity: 1 });
    localStorage.setItem('cart', JSON.stringify(cart));
    alert(`Le vin ${wine.name} a été ajouté au panier.\nLa quantité souhaitée peut être modifiée dans le panier.`);
    console.log(`Vin ${wine.name} ajouté au panier.`);
}
document.addEventListener("DOMContentLoaded", function() {
    fetch('http://localhost:8080/Wine/Wine')
        .then(response => response.json())
        .then(data => {
            populateYearFilter(data);
            displayVins(data);
        })
        .catch(error => console.error('Error:', error));
});

function populateYearFilter(wines) {
    const years = [...new Set(wines.map(wine => new Date(wine.year).getFullYear()))];
    const yearSelect = document.getElementById('yearFilter');
    years.forEach(year => {
        const option = document.createElement('option');
        option.value = year;
        option.textContent = year;
        yearSelect.appendChild(option);
    });
}

document.getElementById('yearFilter').addEventListener('change', function() {
    fetch('http://localhost:8080/Wine/Wine')
        .then(response => response.json())
        .then(data => displayVins(data))
        .catch(error => console.error('Error:', error));
});
