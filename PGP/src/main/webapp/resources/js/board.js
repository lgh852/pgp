 $(document).ready(function(){
    	$("#shopping").click(function(){
    		window.name = "boardform";
    		 window.open('/p/board/shoppingList','shopping','width=800px , height=800','_blank', left ='500',top='500');    	


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
   
    		 var links = $("#link").val();
    		 alert(links);
    		 $.ajax({
                 type : 'GET',
                 url : '/p/board/boardAjaxTag',
                 dataType : 'text',
	            data :{
               	 link:links
                 },
    		
                 success : function(data){
       				alert('ss');
                 }
        });
    	
	});

		
				var upload = $('#inputGroupFile02')[0], imgbox = document
						.getElementById('imgbox'), state = $('#inputGroupFile02');

				if (typeof window.FileReader === 'undefined') {
					state.className = 'fail';
				} else {
					state.className = 'success';

				}

				upload.onchange = function(e) {
					e.preventDefault();

					var file = upload.files[0], reader = new FileReader();
					reader.onload = function(event) {
						var img = new Image();
						img.src = event.target.result;
						$('#imgPre').attr("src",event.target.result);
						// note: no onload required since we've got the dataurl...I think! :)
						if (img.width > 450 || img.height > 450) {
							img.width = 430;

							if (img.height > 450) {
								img.height = 430;
							}

						}
						//imgbox.appendChild(img);
					};
					reader.readAsDataURL(file);

					return false;
				};
				$('#summernote').summernote({
					height : 300,
					width : 800,
					MinHeight : null,
					maxHeight : null,
					focus : true

				});

				

				
			});

