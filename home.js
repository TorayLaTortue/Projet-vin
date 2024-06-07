window.addEventListener('scroll', function() {
    var header = document.getElementById('main-header');
    if (window.scrollY > 100) {
        header.classList.add('header-scrolled');
    } else {
        header.classList.remove('header-scrolled');
    }
});

                    //////////////
                    // POST VIN //
                    //////////////

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

    postWine(params);

});

function postWine(params) {

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
    
}




                    ////////////////
                    // POST DÉPOT //
                    ////////////////

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

    postDepot(params)

});

function postDepot(params) {
    
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

}



                    ///////////////////
                    // POST SUPPLIER //
                    ///////////////////

document.getElementById('submitSupplier').addEventListener('click', () => {

    const name = document.getElementById('name').value;
    const wine_reference = document.getElementById('wine_reference').value;
    const client_reference = document.getElementById('client_reference').value;
    const address_reference = document.getElementById('address_reference').value;

    const params = new URLSearchParams({
        name: name,
        wine_reference: wine_reference,
        client_reference: client_reference,
        address_reference: address_reference
    });

    postSupplier(params);

});

function postSupplier(params) {

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

}