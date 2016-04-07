
$(function() {
	$.ajax({
		url : "/Jsons",
		success : function(result) {
			var items = JSON.parse(result);
			for ( var i = 0; i < items.length; i++) {
				$("div.newItems").append(
						'<p id="' + items[i].id + '">' + items[i].name + '</p>' +
						'<p id="' + items[i].id + '">' + items[i].detail + '</p>' +
						'<p id="' + items[i].id + '">' + '<span>' + '<a href="">' + 'MORE' + '</a>' + '</p>' +
						'<br/>'
				);
			}
		}
	});
});
/*
<script>
  function getJson(){
    $.ajax({
      url : "/Jsons"
      success : function(result) {
        var items = JSON.parse(result);
        if (items.length > 0){
          for (var i = 0; i < items.length; i++){
            $("div.newItems").append(
              '<p class = "foundations" >' + items[i].id + item[i].name +'</p>' + '<br/>'

              //'<p class="question" id="' + flowers[i].id + '">' + flowers[i].name + '</p>' + '<br/>'
            );
          }
        }
      }
    });
  }
</script>
*/
