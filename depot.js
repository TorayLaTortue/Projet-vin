window.addEventListener('scroll', function() {
    var header = document.getElementById('main-header');
    if (window.scrollY > 100) {
        header.classList.add('header-scrolled');
    } else {
        header.classList.remove('header-scrolled');
    }
});


document.addEventListener("DOMContentLoaded", function() {
    fetch('http://localhost:8080/dépôt')
        .then(response => response.json())
        .then(data => {
            displayDepots(data);
        })
        .catch(error => console.error('Error:', error));
});

function displayDepots(depots) {
    const tableBody = document.getElementById('depotTable').getElementsByTagName('tbody')[0];

    depots.forEach(depot => {
        const row = document.createElement('tr');

        const depotNameCell = document.createElement('td');
        depotNameCell.textContent = depot.nom_depot.trim();
        row.appendChild(depotNameCell);

        const vinNameCell = document.createElement('td');
        vinNameCell.textContent = depot.reference_vin.nom.trim();
        row.appendChild(vinNameCell);

        const quantityCell = document.createElement('td');
        quantityCell.textContent = depot.reference_vin.quantite;
        row.appendChild(quantityCell);

        const nomFournisseurCell = document.createElement('td');
        nomFournisseurCell.textContent = depot.reference_fournisseur.nom;
        row.appendChild(nomFournisseurCell);

        tableBody.appendChild(row);
    });
}