$.ajaxSetup({
    contentType: "application/json; charset=utf-8",
    dataType: "json"
});

$(document).ready(function(){
    $('#registration-input').click(function() {
        //Pull new data from form
        var regisFirstName= document.getElementById('registration-firstname').value;
        var regisLastName = document.getElementById('registration-lastname').value;
        var regisEmail = document.getElementById('registration-email').value;
        var regisEmailCon= document.getElementById('registration-con-email').value;
        var regisPassword = document.getElementById('registration-password').value;
        var regisPasswordCon = document.getElementById('registration-con-passwor').value;


        //Convert form data to JSON
        var obj = $('#registration-form').serializeJSON();
        var send = JSON.stringify(obj);

        //output JSON for verification
        console.log(send);

        $.ajax({
            //url: "http://localhost:5000/api/invadd",
            url: 'https://radiant-waters-9673.herokuapp.com//skinstore/addUser',
            type: "POST",
            datatype: "json",
            data: send,
            error: function(xhr, error) {
                   alert('Error!  Status = ' + xhr.status + ' Message = ' + error);
            },
            success: function(data) {
                    alert("User added successfully.");
                    window.location.href='/inventory-list.html';

            }
        });//end AJAX
        return false;
    });//end click function
});//end ready function
