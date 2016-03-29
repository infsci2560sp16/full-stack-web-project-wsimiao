<div>
dlfjs
</div>
<div>
<#list allitems as onepiece>
<div class = "oneItem">
  <div class ="oneItem-img">
    <img src = "images/a.jpg" alt = "item" style="width:200px; height:200px;">
  </div>
  <div class = "oneItem-description">
    <span>${onepiece.brandName}</span></br>
    <span>${onepiece.name}</span></br>
    <span style="font-weight: bold;">${onepiece.price}</span>
  </div>
</div>
</#list>
</div>
