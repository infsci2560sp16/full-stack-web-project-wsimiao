$(function() {
	$.ajax({
		url : "/skinstore/getItemsXML",
    type : "get",
    dataType : "XML",
		success : handleDataXML
});
});

function handleDataXML(data){
  $(data).find('Item').each(function(){
    var itemid = $(this).find('itemid').text();
    var itemname = $(this).find('itemname').text();
    var itembrand = $(this).find('itembrand').text();
    var itemcategory = $(this).find('itemcategory').text();
    var itemcolor = $(this).find('itemcolor').text();
    //$(table).find(tbody).append('<td>' + itemid + '</td><td>' + itemname + '</td><td>' + itembrand + '</td><td>' + itemcategory + '</td><td>' + itemcolor + '</td>');
    $("div.itemsxml").append('<p> item name' + itemname + '</p>');
  });
}
