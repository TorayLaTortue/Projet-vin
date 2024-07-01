let supplierRefUser;


fetch('http://localhost:8080/Supplier/All')
    .then(response => response.json())
    .then(data => {
        const SuppliersAll = data;
        console.log(SuppliersAll);

        const supplier = SuppliersAll.find(supplier => 
            supplier.clientReference.client_reference === user.client_reference
        );

        if (supplier) {
            supplierRefUser = supplier.supplierReference;
            console.log(supplierRefUser);
        } else {
            console.log("Aucun fournisseur trouvé pour l'utilisateur actuel.");
        }
    })
    .catch(error => console.error('Error:', error));

// Event listener for form submission
document.getElementById('submitDepot').addEventListener('click', () => {
    
    const nameDepot = document.getElementById('nameDepot').value;
    const wineRef = document.getElementById('wineRef').value || null;
    const addressRef = document.getElementById('supplierAdressRef').value || null;
    const quantity = document.getElementById('quantity').value || null;

    const params = new URLSearchParams ({
        name: nameDepot,
        wine_reference: wineRef,
        address_reference: addressRef,
        supplier_reference: supplierRefUser,
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
        // You can perform any additional actions here after successful submission
    })
    .catch((error) => {
        console.error('Error:', error);
    });
});
// Event listener for form submission
document.getElementById('submitWine').addEventListener('click', (event) => {
    event.preventDefault(); // Prevent the form from submitting the traditional way
    
    const wineName = document.getElementById('wineName').value;
    const winePicture = document.getElementById('winePicture').value || null;
    const wineQuality = document.getElementById('wineQuality').value || null;
    const wineRegion = document.getElementById('wineRegion').value || null;
    let wineYear = document.getElementById('wineYear').value || null;
    const wineFamily = document.getElementById('wineFamily').value || null;
    const wineFormat = document.getElementById('wineFormat').value || null;
    const winePrice = document.getElementById('winePrice').value || null;

    // Transform the date format if wineYear is not null
    if (wineYear) {
        const [day, month, year] = wineYear.split('/');
        const date = new Date(`${year}-${month}-${day}`);
        wineYear = date.toISOString().split('T')[0];
    }

    const params = new URLSearchParams ({
        name: wineName,
        picture: winePicture,
        wineQuality: wineQuality,
        region: wineRegion,
        year: wineYear,
        family: wineFamily,
        format: wineFormat,
        price: winePrice
    });

    fetch('http://localhost:8080/Wine/New', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
        },
        body: params.toString()
    })
    .then(response => response.json())
    .then(data => {
        console.log('Success:', data);
        // You can perform any additional actions here after successful submission
    })
    .catch((error) => {
        console.error('Error:', error);
    });
});





// POST SUPPLIER //

// document.getElementById('submitSupplier').addEventListener('click', () => {

//     const addressRef = document.getElementById('supplierAdressRef').value || null;
//     const wineRef = document.getElementById('wineRef').value || null;

//     const params = new URLSearchParams ({
//         address_reference: addressRef, // Utiliser la référence de l'adresse du fournisseur
//         wine_reference: wineRef
//     });

//     fetch('http://localhost:8080/Supplier/New', {
//         method: 'POST',
//         headers: {
//             'Content-Type': 'application/x-www-form-urlencoded',
//         },
//         body: params.toString()
//     })
//     .then(response => response.json())
//     .then(data => {
//         console.log('Success:', data);
//     })
//     .catch((error) => {
//         console.error('Error:', error);
//     });
// });
