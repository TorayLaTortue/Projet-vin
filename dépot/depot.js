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



//////////////////////////////////////////////
/// A METTRE DANS UNE AUTRE PAGE --> ADMIN ///
//////////////////////////////////////////////

document.addEventListener('DOMContentLoaded', function() {
    const addDepotButton = document.getElementById('addDepotButton');
    const depotForm = document.getElementById('depotForm');
    const closeFormButton = document.getElementById('closeFormButton');

    addDepotButton.addEventListener('click', function() {
        depotForm.style.display = 'block';
    });

    closeFormButton.addEventListener('click', function() {
        depotForm.style.display = 'none';
    });
})



//// POST ////

    document.getElementById('submit').addEventListener('click', () => {

        const nameDepot = document.getElementById('nameDepot').value;
        const wineRef = document.getElementById('wineRef').value;
        const adressRef = document.getElementById('adressRef').value;
        const supplierRef = document.getElementById('supplierRef').value;
        const quantity = document.getElementById('quantity').value;

        const params = new URLSearchParams({
            name: nameDepot,
            wine_reference: wineRef,
            address_reference: adressRef,
            supplier_reference : supplierRef,
            quantity: quantity
        });
    
        fetch('http://localhost:8080/Deposit/New', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
            },
            body: params.toString()
        })
        .then(response => response.json())
        .then(data => {
            console.log('Success:', data);
        })
        .catch((error) => {
            console.error('Error:', error);
        });
    });