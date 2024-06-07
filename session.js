if (!localStorage.getItem('user')&& !window.location.pathname.endsWith('home.html')) {
    window.location.href = '../connexion/connexion.html';
}
const Connexion = document.getElementById('Connexion');
console.log(localStorage)



 // Récupérer la chaîne de localStorage et la convertir en objet
 const user = localStorage.getItem('user') ? JSON.parse(localStorage.getItem('user')) : null;
    
 
 if (!user) { //Si je ne suis pas un utilisateur
     logoutButton.style.display = 'none';
     wineContainer.innerHTML = "";
     depositContainer.innerHTML = "";
     supplierContainer.innerHTML = "";
 }


 if (user && user.role === "User") {// si je suis un utilisateur et un client
     Connexion.innerHTML = "Connecté";
     Connexion.href = "";
     wineContainer.innerHTML = "";
     depositContainer.innerHTML = "";
     supplierContainer.innerHTML = "";
 }

 if (user && user.role === "Supplier"){// si je suis un utilisateur et un fournissueur
    Connexion.innerHTML = "Connecté";
    Connexion.href = "";
    

 }


 if (user && user.role === "Admin"){// si je suis un utilisateur et un Administrateur
    Connexion.innerHTML = "Connecté";
    Connexion.href = "";
 }










 console.log("Session.js est chargé");
 // Testez les fonctions spécifiques
 function testFunction() {
     console.log("Fonction test exécutée");
 }
 testFunction();





 
 
    const logoutButton = document.getElementById('logoutButton');

    logoutButton.addEventListener('click', function() {
        logout(); // Appel de la fonction de déconnexion
    });

function logout() {
    localStorage.removeItem('user'); // Suppression des informations de l'utilisateur
    
    window.location.href = '/connexion/connexion.html'; // Redirection vers la page de connexion
}
