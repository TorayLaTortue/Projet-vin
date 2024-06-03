document.getElementById('clientForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Empêche la soumission du formulaire par défaut

    // Récupère les valeurs des champs du formulaire
    const nom = document.getElementById('nom').value;
    const prenom = document.getElementById('prenom').value;
    const mail = document.getElementById('mail').value;
    const telephone = document.getElementById('tel').value;
    const mot_de_passe = document.getElementById('mot_de_passe').value;

    // Crée l'objet client à envoyer
    const newClient = {
        nom: nom,
        prenom: prenom,
        mail: mail,
        telephone: telephone,
        mot_de_passe: mot_de_passe
    };

    // Envoie une requête POST à l'API
    fetch('http://localhost:8080/newClient', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(newClient)
    })
    .then(response => response.json())
    .then(data => {
        console.log('Client ajouté avec succès:', data);
        alert('Client ajouté avec succès!');
        // Réinitialise le formulaire
        document.getElementById('clientForm').reset();
    })
    .catch(error => {
        console.error('Erreur lors de l\'ajout du client:', error);
        alert('Erreur lors de l\'ajout du client.');
    });
});
