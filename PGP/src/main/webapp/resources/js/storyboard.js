function searchmenu() {
	$('#serachs').hide();
	$('#mainsearchmenu').hide();
	$('#searchlist').show();

}
function choicesearch(e) {
	var title = $('#srtitle' + e).text();

	$('#searchlist').hide();
	$('#serachs').show();
	$('#inputserach').attr("placeholder", title);
	$('#sear').val(e);
}

$(document).ready(

		function() {

			
			//로그인 안햇을시 submit 되지 않게 
	
			var upload = $('#inputStoryFile')[0], imgbox = document
					.getElementById('imgbox'), state = $('#inputStoryFile');

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
					$('#imgPre').attr("src", event.target.result);

					if (img.width > 450 || img.height > 450) {
						img.width = 430;

						if (img.height > 450) {
							img.height = 430;
						}

					}

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
			// 정보 표시

		});
