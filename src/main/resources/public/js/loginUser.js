function login(e) {
    e.preventDefault();
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;
    var data = {};
    data.email = email;
    data.password = password;

    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", "https://radiant-waters-9673.herokuapp.com/skinstore/loginuser", true);
    xhttp.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
    xhttp.onreadystatechange = function() {
       if (xhttp.readyState == 4 && xhttp.status == 200) {
           // console.log(xhttp.responseText);
           // alert(xhttp.responseText);
           var textnode = document.createTextNode(xhttp.responseText);
           // var node = document.getElementById("loginform");
           // node.appendChild(textnode);
           document.getElementById("loginform").appendChild(textnode);
           alert(textnode);
       }
    };
    //JSON.stringify turns a Javascript object into JSON text and stores that JSON text in a string.
    //JSON.parse turns a string of JSON text into a Javascript object.
    xhttp.send(JSON.stringify(data));
}

