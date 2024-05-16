window.addEventListener('scroll', function() {
    var header = document.getElementById('main-header');
    if (window.scrollY > 100) {
        header.classList.add('header-scrolled');
    } else {
        header.classList.remove('header-scrolled');
    }
});



document.addEventListener("DOMContentLoaded", function() {
    fetch('http://localhost:8080/getAllVins')
        .then(response => response.json())
        .then(data => {
            displayVins(data);
        })
        .catch(error => console.error('Error:', error));
});

function displayVins(vins) {
    const container = document.getElementById('vinContainer');
    vins.forEach(vin => {
        const vinCardWrapper = document.createElement('div');
        vinCardWrapper.className = 'vin-card-wrapper';

        const vinCard = document.createElement('div');
        vinCard.className = 'vin-card';
        vinCard.innerHTML = `
            <div class="vin-card-inner">
                <div class="vin-card-front">
                    <img src="${vin.image}" alt="${vin.nom}">
                    <h3>${vin.nom}</h3>
                </div>
                <div class="vin-card-back">
                    <p>Région: ${vin.region}</p>
                    <p>Famille: ${vin.famille}</p>
                    <p>Année: ${new Date(vin.annee).getFullYear()}</p>
                    <p>Format: ${vin.format}</p>
                    <p class="promotion">Promotion: ${vin.promotion * 100}%</p>
                </div>
            </div>
        `;

        const priceContainer = document.createElement('div');
        priceContainer.className = 'price-container';
        priceContainer.textContent = `${vin.prix}€`;

        const addToCartButton = document.createElement('button');
        addToCartButton.className = 'add-to-cart-btn';
        addToCartButton.setAttribute('data-id', vin.referencevin);
        addToCartButton.textContent = 'Ajouter au panier';
        addToCartButton.addEventListener('click', function() {
            addToCart(vin.referencevin);
        });

        vinCardWrapper.appendChild(vinCard);
        vinCardWrapper.appendChild(priceContainer);
        vinCardWrapper.appendChild(addToCartButton);
        container.appendChild(vinCardWrapper);
    });
}

function addToCart(vinId) {
    console.log(`Vin ${vinId} ajouté au panier.`);
    // Logique pour ajouter le produit au panier
}