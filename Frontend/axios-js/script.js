axios.get('http://localhost:8080/login', {
    username: 'john',
    password: 'papi'
})
    .then((response) => {
        console.log(response);
    }, (error) => {
        console.log(error);
    });(error) => console.log(error.response)