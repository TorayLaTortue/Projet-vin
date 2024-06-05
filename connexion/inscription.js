document.getElementById('clientForm').addEventListener('submit', () => {

    const prenom = document.getElementById('prenom').value;
    const nom = document.getElementById('nom').value;
    const mail = document.getElementById('mail').value;
    const tel = document.getElementById('tel').value;
    const mot_de_passe = document.getElementById('mot_de_passe').value;

    const params = new URLSearchParams({
        name: prenom,
        firstname: nom,
        email: mail,
        phone : tel,
        password: mot_de_passe
    });

    fetch('http://localhost:8080/Client/New', {
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