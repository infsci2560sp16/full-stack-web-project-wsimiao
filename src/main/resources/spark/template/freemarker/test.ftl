<!doctype html>
<html>
<head>
  <title>Skin Store</title>
  <meta charset="utf-8" />
  <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <link href="css/styletest.css" rel="stylesheet">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">


</head>
<body>
  <#include "newheader.ftl">

  <div class="slide">
  <div class="slide-container">

  <div class="links-index">
      <br />
      <ul class="link-list">
        <li><a href="newarrived.php">New Arrived</a></li>
        <li><a href="bestseller.php">Best Seller</a></li>
        <li><a href="valuesets.php">Value Sets</a></li>
        <li><a href="weeklyspecial.php">Weekly Specials</a></li>
      </ul>
    </div>

  <div class="all-items-container">

    <div class ="path">
        makeup>facemakeup>foundation
        <br />
        <img src = "images/foundation.jpg" alt = "foundation" style="width:1000px;">
    </div>

  	<div class = "allItems">


    <#list allitems as onepiece>
    <div class = "oneItem">
      <div class ="oneItem-img">
        <img src = ${onepiece.img} alt = "item" style="width:200px; height:200px;">
      </div>
      <div class = "oneItem-description">
        <span>${onepiece.brandName}</span></br>
        <span>${onepiece.name}</span></br>
        <span style="font-weight: bold;">${onepiece.price}$</span>
      </div>
    </div>
    </#list>



  </div>
</div>
</div>
</div>

</body>
</html>
