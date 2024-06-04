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
    fetch('http://localhost:8080/Deposit/dépôt')
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


    // POST //

    depotForm.addEventListener('submit', function(event) {
        event.preventDefault();

        const wine_reference = 1;  
        const formData = {
            nameDeposit: document.getElementById('nameDepot').value,
            quantity: document.getElementById('quantity').value
        };

        fetch(`http://localhost:8080/Deposit/New/${wine_reference}`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(formData)
        })
        .then(response => {
            if (response.ok) {
                console.log('Success:', response);
                alert('Dépôt ajouté avec succès');
                depotForm.reset();
                depotForm.style.display = 'none';
            } else {
                console.error('Error:', response);
                alert('Erreur lors de l\'ajout du dépôt');
            }
        })
        .catch((error) => {
            console.error('Error:', error);
            alert('Erreur lors de l\'ajout du dépôt');
        });
    });
});