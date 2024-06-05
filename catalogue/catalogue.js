// Ajoute un écouteur d'événement pour détecter le défilement de la page
window.addEventListener('scroll', function() {
    var header = document.getElementById('main-header');
    if (window.scrollY > 100) {
        header.classList.add('header-scrolled');
    } else {
        header.classList.remove('header-scrolled');
    }
});

// Ajoute un écouteur d'événement pour lorsque le DOM est complètement chargé
document.addEventListener("DOMContentLoaded", function() {
    // Fait une requête pour obtenir toutes les données de vins
    fetch('http://localhost:8080/Wine/All')
        .then(response => response.json())
        .then(data => {
            // Affiche les vins et configure les filtres
            displayVins(data);
            setupFilters(data);
        })
        .catch(error => console.error('Erreur:', error));
});

// Fonction pour afficher les vins dans le conteneur spécifié
function displayVins(wines) {
    const container = document.getElementById('vinContainer');
    container.innerHTML = ''; // Vide le conteneur avant d'ajouter de nouveaux vins
    wines.forEach(wine => {
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

// Fonction pour ajouter un vin au panier
function addToCart(wine) {
    let cart = JSON.parse(localStorage.getItem('cart')) || [];
    cart.push({ ...wine, quantity: 1 });
    localStorage.setItem('cart', JSON.stringify(cart));
    alert(`Le vin ${wine.name} a été ajouté au panier.\nLa quantité souhaitée peut être modifiée dans le panier.`);
    console.log(`Vin ${wine.name} ajouté au panier.`);
}

// Fonction pour configurer les filtres dynamiquement en fonction des vins disponibles
function setupFilters(wines) {
    const filterCheckbox = document.querySelector('.filtreVin');
    const filterDiv = document.querySelector('.divFiltre');
    const yearSelect = filterDiv.querySelector('select[name="année"]');
    const familySelect = filterDiv.querySelector('select[name="famille"]');

    // Extraction des années et familles uniques des vins disponibles
    const uniqueYears = [...new Set(wines.map(wine => new Date(wine.year).getFullYear()))].sort((a, b) => b - a);
    const uniqueFamilies = [...new Set(wines.map(wine => wine.family))].sort();

    // Remplissage du select avec les années uniques
    uniqueYears.forEach(year => {
        const option = document.createElement('option');
        option.value = year;
        option.textContent = year;
        yearSelect.appendChild(option);
    });

    // Remplissage du select avec les familles uniques
    uniqueFamilies.forEach(family => {
        const option = document.createElement('option');
        option.value = family;
        option.textContent = family;
        familySelect.appendChild(option);
    });

    // Affichage/masquage du filtre selon l'état de la checkbox
    filterCheckbox.addEventListener('change', function() {
        if (this.checked) {
            filterDiv.classList.remove('hidden');
        } else {
            filterDiv.classList.add('hidden');
        }
    });

    // Application des filtres lorsque l'utilisateur change l'année ou la famille sélectionnée
    yearSelect.addEventListener('change', function() {
        applyFilters(wines);
    });
    familySelect.addEventListener('change', function() {
        applyFilters(wines);
    });
}

// Fonction pour appliquer les filtres aux vins
function applyFilters(wines) {
    const yearSelect = document.querySelector('.divFiltre select[name="année"]');
    const familySelect = document.querySelector('.divFiltre select[name="famille"]');
    const selectedYear = yearSelect.value;
    const selectedFamily = familySelect.value;

    let filteredWines = wines;

    // Filtrer les vins selon l'année sélectionnée
    if (selectedYear) {
        filteredWines = filteredWines.filter(wine => new Date(wine.year).getFullYear().toString() === selectedYear);
    }

    // Filtrer les vins selon la famille sélectionnée
    if (selectedFamily) {
        filteredWines = filteredWines.filter(wine => wine.family === selectedFamily);
    }

    // Afficher les vins filtrés
    displayVins(filteredWines);
}
