window.addEventListener("DOMContentLoaded", function() {
    //get the form elements defined in your form HTML above

    var form = document.getElementById("my-form");

    var status = document.getElementById("status");

    function success(){
        form.reset();
        status.innerHTML="Thanks!";
    }
    function error(){
        status.innerHTML="Put correct email...";
    }

    //handle the form submission event

    form.addEventListener("submit", function(ev){
        ev.preventDefault();
        var data=new FormData(form);
        ajax(form.method, form.action, data, success, error);
    });
});

//helper function for sending an AJAX request


function checkforblank(){
    if(document.getElementById('name').value == "") {
        alert('please complete all elements');
        document.getElementById('name').style.border="1px solid red";
        document.getElementById('name').style.display="block";
        document.getElementById('name').focus();
        return false;
    }
    if(document.getElementById('email').value == "") {
        alert('please complete all elements');
        document.getElementById('email').style.border="1px solid red";
        document.getElementById('email').style.display="block";
        document.getElementById('email').focus();
        return false;
    }
    if(document.getElementById('letter').value == "") {
        alert('please complete all elements');
        document.getElementById('letter').style.border="1px solid red";
        document.getElementById('letter').style.display="block";
        document.getElementById('letter').focus();
        return false;
    }
}

function ajax(method, url, data, success, error){


    var xhr=new XMLHttpRequest();
    xhr.open(method,url);
    xhr.setRequestHeader("Accept", "application/json");
    xhr.onreadystatechange=function(){
        if(xhr.readyState!==XMLHttpRequest.DONE) return;
        if(xhr.status===200){
            success(xhr.response,xhr.responseType);
        }else{
            error(xhr.status, xhr.response, xhr.responseType);
        }
    };
    xhr.send(data);
}
