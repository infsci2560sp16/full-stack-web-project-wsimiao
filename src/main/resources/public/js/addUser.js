function register(e) {
    e.preventDefault();
    var firstName= document.getElementById('registration-firstname').value;
    var lastName = document.getElementById('registration-lastname').value;
    var email = document.getElementById('registration-email').value;
    var password = document.getElementById('registration-password').value;
    var data = {};
    data.firstName = firstName;
    data.lastName = lastName;
    data.email = email;
    data.password = password;

    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", "/skinstore/adduser", true);
    xhttp.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
    xhttp.onreadystatechange = function() {
       if (xhttp.readyState == 4 && xhttp.status == 200) {
           // console.log(xhttp.responseText);
           // alert(xhttp.responseText);
           var textnode = document.createTextNode(xhttp.responseText);
           // var node = document.getElementById("loginform");
           // node.appendChild(textnode);
           document.getElementById("registration-form").appendChild(textnode);
           alert("Register Successful!");
       }
    };
    //JSON.stringify turns a Javascript object into JSON text and stores that JSON text in a string.
    //JSON.parse turns a string of JSON text into a Javascript object.
    xhttp.send(JSON.stringify(data));


}