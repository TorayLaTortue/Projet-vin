if (!localStorage.getItem('user')&& !window.location.pathname.endsWith('home.html')) {
    window.location.href = '../connexion/connexion.html';
}
const Connexion = document.getElementById('Connexion');
console.log(localStorage)
const wineContainer = document.getElementById('wineContainer');
const depositContainer = document.getElementById('depositContainer');
const supplierContainer = document.getElementById('supplierContainer');



 // Récupérer la chaîne de localStorage et la convertir en objet
 const user = localStorage.getItem('user') ? JSON.parse(localStorage.getItem('user')) : null;
    
 
     // Handle user roles and container visibility
     if (!user) { // If the user is not logged in
        if (logoutButton) logoutButton.style.display = 'none';
        if (wineContainer) wineContainer.innerHTML = "";
        if (depositContainer) depositContainer.innerHTML = "";
        if (supplierContainer) supplierContainer.innerHTML = "";
    } else {
        Connexion.innerHTML = "Connecté";
        Connexion.href = "";

        // Handle different user roles
        if (user.role === "user") { // If the user is a client
            if (wineContainer) wineContainer.innerHTML = "";
            if (depositContainer) depositContainer.innerHTML = "";
            if (supplierContainer) supplierContainer.innerHTML = "";
        } else if (user.role === "supplier") { // If the user is a supplier
            if (supplierContainer) supplierContainer.innerHTML = "";
        } else if (user.role === "Admin") { // If the user is an Admin
            // Admin has access to all containers, no need to clear them
        }
    }

 














 
 document.addEventListener('DOMContentLoaded', function() {
    const logoutButton = document.getElementById('logoutButton');

    logoutButton.addEventListener('click', function() {
        logout(); // Appel de la fonction de déconnexion
    });
});

function logout() {
    localStorage.removeItem('user'); // Suppression des informations de l'utilisateur
    window.location.href = '/connexion/connexion.html'; // Redirection vers la page de connexion
}
