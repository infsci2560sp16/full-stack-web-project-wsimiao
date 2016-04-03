$.ajaxSetup({
    contentType: "application/json; charset=utf-8",
    dataType: "json"
});

$(document).ready(function(){
    $('#registration-btn').click(function() {
    	//alert("trt");
        //Pull new data from form
        var firstName = $("#registration-firstname").val();
        var lastName = $("#registration-lastname").val();
        var email = $("#registration-email").val();
        var password = $("#registration-password").val();
        
//        var lastName = document.getElementById("registration-lastname");
//        var email = document.getElementById("registration-email");
//        var password = document.getElementById("registration-password");
        var data = {};
        data.firstName = firstName;
        data.lastName = lastName;
        data.email = email;
        data.password = password;
        //Convert form data to JSON
        var send = JSON.stringify(data);

        //output JSON for verification
        console.log(send);

        $.ajax({
            //url: "http://localhost:4567/skinstore/adduser",
            url: "https://radiant-waters-9673.herokuapp.com/skinstore/adduser",

            type: "POST",
            datatype: "json",
            data: send,
            error: function(xhr, error) {
                   alert('Error!  Status = ' + xhr.status + ' Message = ' + error);
                   alert(send);
            },
            success: function(data) {
                    alert("User added successfully.");
                    alert(send);
                    window.location.href='/index.html';

            }
        });//end AJAX
        return false;
    });//end click function
});//end ready function
