const student = "hii";
fetch("http://localhost:8080/login", {
    method: "GET",
    headers: {
        'Access-Control-Allow-Origin': '*',
        'Access-Control-Allow-Methods': 'GET, POST, PUT',
        'Access-Control-Allow-Headers': 'Content-Type'
    }

})