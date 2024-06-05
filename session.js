if (!localStorage.getItem('user')&& !window.location.pathname.endsWith('home.html')) {
    window.location.href = '../connexion/connexion.html';
}

console.log(localStorage)


 // Récupérer la chaîne de localStorage et la convertir en objet
 const user = localStorage.getItem('user') ? JSON.parse(localStorage.getItem('user')) : null;
    
 // Vérifier si la session est active
 if (user) {
     logoutButton.style.display = 'none'; // Masquer le bouton si l'utilisateur est connecté
 }

 // Vérifier si la session est active et si l'utilisateur est un client
 if (user && user.role === "Client") {

     logoutButton.innerHTML = ""; // Vider le conteneur de vin si l'utilisateur est un client
     wineContainer.innerHTML = ""; // Vider le conteneur de vin si l'utilisateur est un client
     depositContainer.innerHTML = "";
     supplierContainer.innerHTML = "";
 }

 if (user && user.role === "Fournisseur"){
    supplierContainer.innerHTML = "";
 }


function logout() {
    localStorage.removeItem('user'); // Suppression des informations de l'utilisateur
    window.location.href = '../connexion/connexion.html'; // Redirection vers la page de connexion
}
