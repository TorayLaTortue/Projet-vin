window.addEventListener('scroll', function() {
    var header = document.getElementById('main-header');
    if (window.scrollY > 100) {
        header.classList.add('header-scrolled');
    } else {
        header.classList.remove('header-scrolled');
    }
});


// ROUTE GET //


    fetch('http://localhost:8080/Deposit/All')
        .then(response => response.json())
        .then(data => {
            displayDepots(data);
        })
        .catch(error => console.error('Error:', error));


        function displayDepots(depots) {
            const tableBody = document.getElementById('depotTable').getElementsByTagName('tbody')[0];
            const user = JSON.parse(localStorage.getItem('user'));
            const clientReference = user.client_reference;
        
            // Vider le contenu actuel de la table
            tableBody.innerHTML = '';
        
            depots.forEach(depot => {
                // Vérifier si depot.supplierReference et depot.supplierReference.clientReference existent
                if (depot.supplierReference && depot.supplierReference.clientReference &&
                    depot.supplierReference.clientReference.client_reference === clientReference) {
                    
                    const row = document.createElement('tr');
        
                    const depotNameCell = document.createElement('td');
                    depotNameCell.textContent = depot.nameDeposit ? depot.nameDeposit.trim() : '';
                    row.appendChild(depotNameCell);
        
                    const wineNameCell = document.createElement('td');
                    wineNameCell.textContent = depot.wineReference && depot.wineReference.name ? depot.wineReference.name.trim() : '';
                    row.appendChild(wineNameCell);
        
                    const quantityCell = document.createElement('td');
                    quantityCell.textContent = depot.quantity != null ? depot.quantity : '';
                    row.appendChild(quantityCell);
        
                    tableBody.appendChild(row);
                }
            });
        }
        