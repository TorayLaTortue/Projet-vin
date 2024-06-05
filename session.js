if (!localStorage.getItem('user')) {
    window.location.href = '../connexion/connexion.html'; // Redirection vers la page de connexion si non connecté
}


document.addEventListener('DOMContentLoaded', function() {
    const logoutButton = document.getElementById('logoutButton');

    logoutButton.addEventListener('click', function() {
        logout(); // Appel de la fonction de déconnexion
    });
});

function logout() {
    localStorage.removeItem('user'); // Suppression des informations de l'utilisateur
    window.location.href = '../connexion/connexion.html'; // Redirection vers la page de connexion
}
