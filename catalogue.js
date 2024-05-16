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
        const vinCard = document.createElement('div');
        vinCard.className = 'vin-card';
        vinCard.innerHTML = `
            <img src="${vin.image}" alt="${vin.nom}" class="vin-image">
            <h3>${vin.nom}</h3>
            <p>Région: ${vin.region}</p>
            <p>Famille: ${vin.famille}</p>
            <p>Année: ${new Date(vin.annee).getFullYear()}</p>
            <p>Format: ${vin.format}</p>
            <p>Prix: ${vin.prix}€</p>
            <p>Promotion: ${vin.promotion * 100}%</p>
        `;
        container.appendChild(vinCard);
    });
}
