/******************************************************
function for images changing of main page
*********************************************************/

var mainImageArray = ["./images/arcteryx-1.jpg","./images/patagonia-2.jpg", "./images/cg-2.jpg","./images/moncler-3.jpg", "./images/wm-1.jpg"];
var img = document.getElementById(mainImg);
var i = 0;
function nextImage(){
    mainImg.setAttribute("src", mainImageArray[i]);
    i++;
    if(i >= mainImageArray.length){
        i = 0;
    }
}
var intervalTime = setInterval(nextImage, 2000);

/*
var i = 0;
function nextImage(){
    var img = document.getElementById("mainImg");
    img.src = mainImageArray[i];
    i++;
    if(i >= mainImageArray.length){
        i = 0;
    }
}
var intervalTime = setInterval(nextImage, 2000);
*/

/*****************************************************
function for form validation
******************************************************/

function checkForm(form)
  {
    // regular expression to match only alphanumeric characters and spaces
    var re = /^[\w ]+$/;

    // validation fails if the input is blank
    if(form.reg_f_name.value === "") {
      document.getElementById('f_name_error').innerHTML="Please enter your first name";
      form.reg_f_name.focus();
      return false;
    }

    // validation fails if the input doesn't match our regular expression
    if(!re.test(form.reg_f_name.value)) {
      document.getElementById('f_name_error').innerHTML="Input contains invalid characters";
      form.reg_f_name.focus();
      return false;
    }

    if(form.reg_l_name.value === "") {
      document.getElementById('l_name_error').innerHTML="Please enter your last name";
      form.reg_l_name.focus();
      return false;
    }

    // validation fails if the input doesn't match our regular expression
    if(!re.test(form.reg_l_name.value)) {
      document.getElementById('l_name_error').innerHTML="Input contains invalid characters";
      form.reg_l_name.focus();
      return false;
    }

    if(form.reg_email_addr.value === "") {
      document.getElementById('email_addr_error').innerHTML="Please enter your email address";
      form.reg_email_addr.focus();
      return false;
    }

    if(form.reg_pwd.value === "") {
      document.getElementById('pwd_error').innerHTML="Please enter your password";
      form.reg_pwd.focus();
      return false;
    }

    // validation fails if the input doesn't match our regular expression
    if(!re.test(form.reg_pwd.value)) {
      document.getElementById('pwd_error').innerHTML="Input contains invalid characters";
      form.reg_pwd.focus();
      return false;
    }

    if(form.reg_cfm_pwd.value === "") {
      document.getElementById('cfm_pwd_error').innerHTML="Please confirm your password";
      form.reg_cfm_pwd.focus();
      return false;
    }

    // validation fails if the input doesn't match our regular expression
    if(!re.test(form.reg_cfm_pwd.value)) {
      document.getElementById('cfm_pwd_error').innerHTML="Input contains invalid characters";
      form.reg_cfm_pwd.focus();
      return false;
    }

    if(form.reg_pwd.value != form.reg_cfm_pwd.value){
        document.getElementById('pwd_error').innerHTML="Passwords do not match";
        document.getElementById('cfm_pwd_error').innerHTML="Passwords do not match";
        form.reg_pwd.focus();
        form.reg_cfm_pwd.focus();
        return false;
    }

    if(form.reg_u_name.value === "") {
      document.getElementById('user_name_error').innerHTML="Please enter your username";
      form.reg_u_name.focus();
      return false;
    }

    // validation fails if the input doesn't match our regular expression
    if(!re.test(form.reg_u_name.value)) {
      document.getElementById('user_name_error').innerHTML="Input contains invalid characters";
      form.reg_u_name.focus();
      return false;
    }

    if(form.reg_z_code.value === "") {
      document.getElementById('zip_code_error').innerHTML="Please enter your username";
      form.reg_z_code.focus();
      return false;
    }

    // validation fails if the input doesn't match our regular expression
    if(!re.test(form.reg_z_code.value)) {
      document.getElementById('zip_code_error').innerHTML="Input contains invalid characters";
      form.reg_z_code.focus();
      return false;
    }

    // validation was successful
    return true;
  }

  /*****************************************************
  function for node manipulation in shopping cart page
  ******************************************************/


function addDiv() {
    var objTo = document.getElementById('shopping-item-container');
    var divtest = document.createElement("div");
    divtest.innerHTML = "new div";
    objTo.appendChild(divtest);
}
