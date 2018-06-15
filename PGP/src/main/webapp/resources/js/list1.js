var size1;
var size2;
var size3;
var ck1;
var ck2;
var ck3;
 
$(document)
		.ready(
				function() {

					var sizeString = $('#listsize').val()
					var size = parseFloat(sizeString)

					var latelyck = new Array();
					var x = 1;

					for (var i = 0; i < size; i++) {
						latelyck[i] = $('#latelyck' + x).val();
						x++;
					}
					var number = latelyck.length;
					size1 = size - 1;
					size2 = size - 2;
					size3 = size - 3;
					if (latelyck.length == 0) {

						$('#latelybox').css('display', 'none');

					} else if (latelyck.length >= 1) {
						
						if ((latelyck.length % 3) == 1 && latelyck.length < 3) {

							$('#latelybox').css('display', 'block');


							$('#buttonblock').css('display', 'none');

							$('#oneimg img').attr(
									'src',
									'/p/resources/BoardPhoto/'
											+ latelyck[size1]);
							$('#photoname1').val(size1);

							if (latelyck.length > 3) {
								$('#latelybox')
								.append('<div class="row"><div class="col" id ="ssssadas"><a class="page-link border-0" href="#" aria-label="Previous" style="padding-left: 0px; margin-left: 15px;"><span aria-hidden="true" style="color: #000000ad; text-decoration: none;padding-left: 30px;" onclick="back()">◀</span></a></div> <div class="col" id ="asdasddsasda"><a class="page-link border-0" href="#" aria-label="Next" style="margin-right: 10px;"><span aria-hidden="true" style="color: #000000ad;  text-decoration: none" onclick="front()">▶</span></a></div><div>')
										$('#latelybox').css('height', '250px');
										// 마지막 부터 보여주게 변경
							}

						} else if ((latelyck.length % 3) == 2
								&& latelyck.length < 3) {

							$('#latelybox')
									.append(
											'<div id="twoimg" class="card-body"	style="padding-top: 0px; padding-bottom: 8px;"><img id="imgtwo" width="128" height="128"></div>')
											 
											
											$('#imgone').attr(
									'src',
									'/p/resources/BoardPhoto/'
											+ latelyck[size2]);

							$('#imgtwo').attr(
									'src',
									'/p/resources/BoardPhoto/'
											+ latelyck[size1]);

							$('#latelybox').css('height', '360px');
							$('#photoname1').val(size1);
							$('#photoname2').val(size2);	

							if (latelyck.length > 3) {
								$('#latelybox')
									.append('<div class="row"><div class="col" id ="ssssadas"><a class="page-link border-0" href="#" aria-label="Previous" style="padding-left: 0px; margin-left: 15px;"><span aria-hidden="true" style="color: #000000ad; text-decoration: none;padding-left: 30px;" onclick="back()">◀</span></a></div> <div class="col" id ="asdasddsasda"><a class="page-link border-0" href="#" aria-label="Next" style="margin-right: 10px;"><span aria-hidden="true" style="color: #000000ad;  text-decoration: none" onclick="front()">▶</span></a></div><div>')
										$('#latelybox').css('height', '390px');
							}

						} else if ((latelyck.length % 3) == 0
								&& latelyck.length < 3) {
							
							$('#latelybox')
									.append(
									'<div id="twoimg" class="card-body"	style="margin: auto; padding-top: 0px; padding-bottom: 8px; margin-left: 20px"><img id="imgtwo" width="128" height="128" style="margin-left: 10px;"></div>')
									
							$('#latelybox')
									.append(
											'<div id="threeimg" class="card-body" style="margin: auto; padding-top: 0px; padding-bottom: 8px; margin-left: 20px"><img id="imgthree" width="128" height="128" style="margin-left: 10px;"></div>')
							$('#imgone').attr(
									'src',
									'/p/resources/BoardPhoto/'
											+ latelyck[size3]);
							$('#imgtwo').attr(
									'src',
									'/p/resources/BoardPhoto/'
											+ latelyck[size2]);
							$('#imgthree').attr(
									'src',
									'/p/resources/BoardPhoto/'
											+ latelyck[size1]);

							$('#latelybox').css('height', '490px');
							$('#photoname1').val(size1);
							$('#photoname2').val(size2);
							$('#photoname3').val(size3);
							if (latelyck.length > 3) {
								$('#latelybox')
								.append('<div class="row"><div class="col" id ="ssssadas"><a class="page-link border-0" href="#" aria-label="Previous" style="padding-left: 0px; margin-left: 15px;"><span aria-hidden="true" style="color: #000000ad; text-decoration: none;padding-left: 30px;" onclick="back()">◀</span></a></div> <div class="col" id ="asdasddsasda"><a class="page-link border-0" href="#" aria-label="Next" style="margin-right: 10px;"><span aria-hidden="true" style="color: #000000ad;  text-decoration: none" onclick="front()">▶</span></a></div><div>')
										$('#latelybox').css('height', '520px');
							}

						} else if (latelyck.length > 3) {
						
				
							$('#latelybox')
									.append(
											'<div id ="twoimg" style="width: 130px;height: 130px; margin: 0 auto; margin-top: 10px; margin-left: 20px"><img id="imgtwo" width="128"height="128"></div>')
							$('#latelybox')
									.append(
											'<div id ="threeimg" style="width: 130px;height: 130px; margin: 0 auto; margin-top: 10px;margin-left: 20px"><img id="imgthree" width="128"height="128"></div>')
							$('#imgone').attr(
									'src',
									'/p/resources/BoardPhoto/'
											+ latelyck[size3]);
							$('#imgtwo').attr(
									'src',
									'/p/resources/BoardPhoto/'
											+ latelyck[size2]);
							$('#imgthree').attr(
									'src',
									'/p/resources/BoardPhoto/'
											+ latelyck[size1]);

							$('#latelybox').css('height', '490px');
							$('#photoname1').val(size1);
							$('#photoname2').val(size2);
							$('#photoname3').val(size3);
							if (latelyck.length > 3) {
								$('#latelybox')
								.append('<div class="row"><div class="col" id ="ssssadas"><a class="page-link border-0" href="#" aria-label="Previous" style="padding-left: 0px; margin-left: 15px;"><span aria-hidden="true" style="color: #000000ad; text-decoration: none;padding-left: 30px;" onclick="back()">◀</span></a></div> <div class="col" id ="asdasddsasda"><a class="page-link border-0" href="#" aria-label="Next" style="margin-right: 10px;"><span aria-hidden="true" style="color: #000000ad;  text-decoration: none" onclick="front()">▶</span></a></div><div>')
									$('#latelybox').css('height', '520px');
								// 마지막 부터 보여주게 변경
							}
						}

					}

				});

function back() {
	
	var size1 = $('#photoname1').val();
	var size2 = $('#photoname2').val();
	var size3 = $('#photoname3').val();


	var sizeString = $('#listsize').val()
	var size = parseFloat(sizeString)

	var latelyck = new Array();
	var x = 1;

	for (var i = 0; i < size; i++) {
		latelyck[i] = $('#latelyck' + x).val();
		x++;
	}

	if (size1 != null && (size1 - 3) >= 0) {
		size1 = size1 - 3;

	} else {
	
	}
	if (size2 != null && (size2 - 3) >= 0) {

		size2 = size2 - 3;

	} else {

	
	}
	if (size3 != null && (size3 - 3) >= 0) {

		size3 = size3 - 3;

	} else {

	
	}
	
	if (size3 == ck3) {


		$('#oneimg').hide();
		$('#latelybox').css('height', '360px')
	} else {
		$('#imgone').attr('src', '/p/resources/BoardPhoto/' + latelyck[size3]);
		// 변화가 잇으면

	}
	
	if (size2 == ck2) {
		// 값이 변화가 없으면 없앰
	
		alert('2번 변화없음 ');
		
	$('#twoimg').hide();
	
		size2 = -1;
		$('#twoimg').hide();
		$('#latelybox').css('height','230px')

	} else {
	
		$('#imgtwo').attr('src', '/p/resources/BoardPhoto/' + latelyck[size2]);
	
		// 변화가 잇으면
	}

	if (size1 == ck1) {
		// 값이 변화가 없으면 없앰
		alert('1번 변화없음 ');

	
	} else {
		
		$('#imgthree').attr('src',
				'/p/resources/BoardPhoto/' + latelyck[size1]);
		// 변화가 잇으면

	}

	
	$('#photoname1').val(size1);
	$('#photoname2').val(size2);
	$('#photoname3').val(size3);
	

	ck1 = size1;
	ck2 = size2;
	ck3 = size3;

}


function front() {
	var size1 = parseFloat($('#photoname1').val());
	var size2 = parseFloat($('#photoname2').val());
	var size3 = parseFloat($('#photoname3').val());
	$('#latelybox').css('height','490px')

	var sizeString = $('#listsize').val()

	var size = parseFloat(sizeString)

	var latelyck = new Array();
	var x = 1;
	if(size1<0||size2<0){
		$('#oneimg').show();
		$('#twoimg').show();
		$('#latelybox').attr('height', '490px')
	}
	for (var i = 0; i < size; i++) {
		latelyck[i] = $('#latelyck' + x).val();
		x++;
	}



	if (size3 != null && (size3 + 3) < latelyck.length) {
		
		size3 = size3 + 3;
		
	} else {
	
		
	}
	if (size2 != null && (size2 + 3) < latelyck.length) {

		size2 = size2 + 3;

	} else {
		

	}
	if (size1 != null && (size3 + 1) < latelyck.length) {

		size1 = size3 + 1;

	} else {

	}
	
	
	
	$('#photoname1').val(size1);

	
	
	$('#photoname2').val(size2);

	
	
	$('#photoname3').val(size3);

	
	
	$('#imgone').attr('src', '/p/resources/memberphoto/' + latelyck[size1]);
	
	
	$('#imgtwo').attr('src', '/p/resources/memberphoto/' + latelyck[size2]);
	
	
	$('#imgthree').attr('src' , '/p/resources/memberphoto/' + latelyck[size3]);


}