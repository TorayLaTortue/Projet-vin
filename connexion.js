document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Empêche la soumission du formulaire par défaut

    // Récupère les valeurs des champs du formulaire
    const email = document.getElementById('loginEmail').value.trim().toLowerCase();
    const motdepasse = document.getElementById('loginPassword').value.trim();

    // Envoie une requête GET pour récupérer tous les clients
    fetch('http://localhost:8080/clients')
        .then(response => response.json())
        .then(data => {
            console.log("Données reçues: ", data); // Affiche les données récupérées pour vérification
            // Vérifie les identifiants côté client
            const client = data.find(client => 
                client.mail.trim().toLowerCase() === email && 
                client.motdepasse.trim() === motdepasse
            );
            if (client) {
                console.log('Utilisateur connecté avec succès:', client);
                alert('Connexion réussie!');
                // Redirige vers une autre page ou fait quelque chose d'autre
            } else {
                console.error('Identifiants de connexion incorrects');
                const loginError = document.getElementById('loginError');
                loginError.style.display = 'block';
                loginError.textContent = 'Identifiants de connexion incorrects';
            }
        })
        .catch(error => {
            console.error('Erreur lors de la récupération des clients:', error);
            alert('Erreur lors de la récupération des clients.');
        });
});
