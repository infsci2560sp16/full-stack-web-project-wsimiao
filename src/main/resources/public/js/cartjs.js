function calculateTotal(){
  var pdtPrice = document.getElementById("product-price").innerHTML;
  var amount = document.getElementById("select-quantity-no").value;
  var totalPrice = pdtPrice * amount;
  document.getElementById("item-total-price").innerHTML = totalPrice + "$";
}

function generateDiv(){
  var para = document.getElementById("parent-item-div");
  var child = document.createElement("div");
  child.innerHTML = "New Div";
  para.appendChild(child);
}
