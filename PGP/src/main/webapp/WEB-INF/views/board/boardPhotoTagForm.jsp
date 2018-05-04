<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script src="https://code.jquery.com/jquery-1.10.2.js">    </script>
<script>
    $(document).ready(function(){
    	$("#shopping").click(function(){
    		window.name = "boardform";
    		 window.open('<%=request.getContextPath()%>/board/shoppingList','shopping','width=800px , height=800','_blank', left ='500',top='500');    	


    	});
     	var imgtagbox = $('#imgtagbox');
    	imgtagbox.click(function (event) {
    		  var x = event.offsetX;
              var y = event.offsetY;
				//alert('x'+x+'y'+y)
    		   $('.serchbox').css({
				"top": y,
				"left": x
			}).show()
    			
    		});
    	
    	$('#tags').click(function() {
   
    		 var link = $("#link").val();
    		 alert(link);
    		 $.ajax({
                 type : "GET",
                 url : "/board/boardAjaxTag",
                 dataType : "text",
	             data : {
                	 link:link
                 }
       
           
        });
    	
	});
});
</script>

<style>
.serchbox {
	width: 370px;
	height: 60px;
	border: 2px solid black;
	padding-top: 10px;
	padding-left: 20px;
	border-radius: 10px 10px 10px 10px;
	position: absolute;
}

.imgcenter {
	position: relative;
}
</style>
<c:forEach var="photo" items="${photo}">

	<div class="imgcenter">
		<img
			src="<%=request.getContextPath()%>/resources/BoardPhoto/${photo.photo_name}"
			height="450px" width="450px"
			style="margin: 0 auto; border: 1px solid black;" id="imgtagbox">
		<div id="serchbutton" class="serchbox">
			<button type="button" class="btn btn-primary" id="shopping"
				style="width: 85px; height: 35px;">상품검색</button>
			<input type="text" id="link">
			<button type="button" class="btn btn-primary" id="tags"
				style="width: 55px; height: 35px;">등록</button>
		</div>
	</div>

</c:forEach>