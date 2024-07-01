if (!localStorage.getItem('user') && 
    !(window.location.pathname.endsWith('home.html') || window.location.pathname.endsWith('catalogue.html'))) {
    window.location.href = '/connexion/connexion.html';
}

const Connexion = document.getElementById('Connexion');
const wineContainer = document.getElementById('wineContainer');
const depositContainer = document.getElementById('depositContainer');
const supplierContainer = document.getElementById('supplierContainer');
const logoutButton = document.getElementById('logoutButton');

 // Récupérer la chaîne de localStorage et la convertir en objet
 const user = localStorage.getItem('user') ? JSON.parse(localStorage.getItem('user')) : null;
    
 
     // Gestion des rôles
     if (!user) { // Si l'utilisateur n'est pas connecté
        if (logoutButton) logoutButton.style.display = 'none';
        if (wineContainer) wineContainer.innerHTML = "";
        if (depositContainer) depositContainer.innerHTML = "";
        if (supplierContainer) supplierContainer.innerHTML = "";
    } else {
        Connexion.innerHTML = "Connecté";
        Connexion.href = "";

        
        if (user.role === "user") { // Si l'utilisateur est connecté
            if (wineContainer) wineContainer.innerHTML = "";
            if (depositContainer) depositContainer.innerHTML = "";
            if (supplierContainer) supplierContainer.innerHTML = "";
        } else if (user.role === "Supplier") { // Si l'utilisateur est un Supplier
            if (supplierContainer) supplierContainer.innerHTML = "";
        } else if (user.role === "Admin") {
        }
    }






console.log(user);

 console.log("Session.js est chargé");
 // Testez les fonctions spécifiques
 function testFunction() {
     console.log("Fonction test exécutée");
 }
 testFunction();





 
 
    

    logoutButton.addEventListener('click', function() {
        logout(); // Appel de la fonction de déconnexion
    });

function logout() {
    localStorage.removeItem('user'); // Suppression des informations de l'utilisateur
    
    window.location.href = '/connexion/connexion.html'; // Redirection vers la page de connexion
}
