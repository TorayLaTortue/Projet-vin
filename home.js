window.addEventListener('scroll', function() {
    var header = document.getElementById('main-header');
    if (window.scrollY > 100) {
        header.classList.add('header-scrolled');
    } else {
        header.classList.remove('header-scrolled');
    }
});


// POST VIN //

document.getElementById('submitWine').addEventListener('click', () => {

    const wineName = document.getElementById('wineName').value;
    const winePicture = document.getElementById('winePicture').value;
    const wineQuality = document.getElementById('wineQuality').value;
    const wineRegion = document.getElementById('wineRegion').value;
    const wineYear = document.getElementById('wineYear').value;
    const wineFamily = document.getElementById('wineFamily').value;
    const wineFormat = document.getElementById('wineFormat').value;
    const winePrice = document.getElementById('winePrice').value;

    const params = new URLSearchParams ({
        name: wineName,
        picture: winePicture,
        wineQuality: wineQuality,
        region : wineRegion,
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
    })
    .catch((error) => {
        console.error('Error:', error);
    });
});





// POST DÉPOT //

document.getElementById('submitDepot').addEventListener('click', () => {

    const nameDepot = document.getElementById('nameDepot').value;
    const wineRef = document.getElementById('wineRef').value;
    const adressRef = document.getElementById('adressRef').value;
    const supplierRef = document.getElementById('supplierRef').value;
    const quantity = document.getElementById('quantity').value;

    const params = new URLSearchParams ({
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





// POST SUPPLIER //

document.getElementById('submitSupplier').addEventListener('click', () => {

    const supplierRef = document.getElementById('adressRef').value;
    const wineRef = document.getElementById('wineRef').value;

    const params = new URLSearchParams ({
        address_reference: supplierRef,
        wine_reference: wineRef
    });

    fetch('http://localhost:8080/Supplier/New', {
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