document.getElementById('submit').addEventListener('click', () => {

    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    const params = new URLSearchParams({
        email: email,
        password: password,
    });

    fetch('http://localhost:8080/Client/Login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
        },
        body: params.toString()
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok ' + response.statusText);
        }
        return response.json();
    })
    .then(data => {
        console.log('Success:', data.name);
        if (data && data.email) { // Change here to check if data is valid and contains email
            localStorage.setItem('user', JSON.stringify(data));
            alert('You are successfully logged in!');
            window.location.href = '../home.html'; // Redirect to dashboard or homepage
        } else {
            throw new Error('No user data returned');
        }
    })
    .catch((error) => {
        console.error('Error:', error);
        alert('Login failed: ' + error.message);
    });
});
