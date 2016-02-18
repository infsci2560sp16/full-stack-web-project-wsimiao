$("#registration-form").submit(function(event){

  event.preventDefault();


  function isValidEmailAddress(emailAddress) {
  var pattern = /^([a-z\d!#$%&'*+\-\/=?^_`{|}~\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]+(\.[a-z\d!#$%&'*+\-\/=?^_`{|}~\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]+)*|"((([ \t]*\r\n)?[ \t]+)?([\x01-\x08\x0b\x0c\x0e-\x1f\x7f\x21\x23-\x5b\x5d-\x7e\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]|\\[\x01-\x09\x0b\x0c\x0d-\x7f\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))*(([ \t]*\r\n)?[ \t]+)?")@(([a-z\d\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]|[a-z\d\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF][a-z\d\-._~\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]*[a-z\d\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])\.)+([a-z\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]|[a-z\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF][a-z\d\-._~\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]*[a-z\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])\.?$/i;
  return pattern.test(emailAddress);
  };
  var validfirstname=false;
  var validlastname=false;
  if($("#registration-firstname").val()==""){
    $("#error-firstname").html("Please enter valid first name");
  }else{
    validfirstname=true;
  }

  if($("#registration-lastname").val()==""){
    $("#error-lastname").html("Please enter valid last name");
  }else{
    validlastname=true;
  }
  var validemail=false;
  if(!isValidEmailAddress($("#registration-email").val())){
    $("#error-email").html("Please enter valid email");
  }else{
    validemail=true;
  }

  var validconemail=false;
  if(validemail && $("#registration-con-email").val()==$("#registration-email").val()){
    validconemail=true;
  }else{
    $("#error-con-email").html("The two email adress entered are not same!");
  }

  var passwordcon=false;
  if($("#registration-password").val()==$("#registration-con-password").val()&&$("#registration-password").val()!=""){
    passwordcon=true;
  }else{
    $("#error-con-pass").html("Please enter password or the two passwords entered are not the same!");
  }

  if(validfirstname && validlastname && validemail && validconemail && passwordcon){
    alert("success register!");
  }



});
