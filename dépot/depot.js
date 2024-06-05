window.addEventListener('scroll', function() {
    var header = document.getElementById('main-header');
    if (window.scrollY > 100) {
        header.classList.add('header-scrolled');
    } else {
        header.classList.remove('header-scrolled');
    }
});



// ROUTE GET //

document.addEventListener("DOMContentLoaded", function() {
    fetch('http://localhost:8080/Deposit/All')
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
        depotNameCell.textContent = depot.nameDeposit.trim();
        row.appendChild(depotNameCell);

        const vinNameCell = document.createElement('td');
        vinNameCell.textContent = depot.wineReference.name.trim();
        row.appendChild(vinNameCell);

        const quantityCell = document.createElement('td');
        quantityCell.textContent = depot.quantity;
        row.appendChild(quantityCell);
        
        tableBody.appendChild(row);
    });
}