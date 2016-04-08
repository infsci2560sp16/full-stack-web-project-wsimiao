// $(function() {
// 	$.ajax({
// 		url : "/skinstore/getItemsXML",
//     type : "get",
//     dataType : "XML",
// 		success : handleDataXML
// });
// });
/*
function getDataXML(){
  alert("hell1");
  $.ajax({
		url : "/skinstore/getItemsXML",
    type : "get",
    dataType : "XML",
		success : handleDataXML
  });
}

function handleDataXML(data){
  alert("hell2");
  $(data).find('Item').each(function(){
    var itemid = $(this).find('itemid').text();
    var itemprice = $(this).find('itemprice').text();
    var itemname = $(this).find('itemname').text();
    var itembrand = $(this).find('itembrand').text();
    var itemcategory = $(this).find('itemcategory').text();
    var itemdescription = $(this).find('itemdescription').text();
    var itemcolor = $(this).find('itemcolor').text();
    var itemlove = $(this).find('itemlove').text();
    var itemstock = $(this).find('itemstock').text();
    var itemgender = $(this).find('itemgender').text();
    var itemsize = $(this).find('itemsize').text();
    var itemimg = $(this).find('itemimg').text();
    //$(table).find(tbody).append('<td>' + itemid + '</td><td>' + itemname + '</td><td>' + itembrand + '</td><td>' + itemcategory + '</td><td>' + itemcolor + '</td>');
    //$("div.itemsxml").append('<p> item name' + itemname + '</p>');
     $('<tr></tr>').html('<td>'+itemid+'</td><td>'+ itemprice + '</td><td>' +itemname+'</td><td>'+itembrand+'</td><td>'+ itemcategory +'</td><td>'+ itemdescription + '</td><td>'+ itemcolor +'</td><td>'+ itemlove +'</td><td>'+ itemstock +'</td><td>'+ itemgender +'</td><td>'+ itemsize +'</td><td>'+itemimg +'</td>').appendTo('#itemtable');
  });
}
*/
$(function() {
	$.ajax({
		url : "/skinstore/getItemsXML",
    type : "get",
    dataType : "XML",
		success : function(data) {
      $(data).find('Item').each(function(){
        var itemid = $(this).find('itemid').text();
        var itemprice = $(this).find('itemprice').text();
        var itemname = $(this).find('itemname').text();
        var itembrand = $(this).find('itembrand').text();
        var itemcategory = $(this).find('itemcategory').text();
        var itemdescription = $(this).find('itemdescription').text();
        var itemcolor = $(this).find('itemcolor').text();
        var itemlove = $(this).find('itemlove').text();
        var itemstock = $(this).find('itemstock').text();
        var itemgender = $(this).find('itemgender').text();
        var itemsize = $(this).find('itemsize').text();
        var itemimg = $(this).find('itemimg').text();
        $('<tr></tr>').html('<td>'+itemid+'</td><td>'+ itemprice + '</td><td>' +itemname+'</td><td>'+itembrand+'</td><td>'+ itemcategory +'</td><td>'+ itemdescription + '</td><td>'+ itemcolor +'</td><td>'+ itemlove +'</td><td>'+ itemstock +'</td><td>'+ itemgender +'</td><td>'+ itemsize +'</td><td>'+itemimg +'</td>').appendTo('#itemtable');
      }); // end of inner function
		}
	});
});
