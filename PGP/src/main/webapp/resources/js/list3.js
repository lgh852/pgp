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
						alert("박보검" + latelyck.length);
						if ((latelyck.length % 3) == 1 && latelyck.length < 3) {

							$('#latelybox').css('display', 'block');

							alert('첫번째 이미지명' + size);

							$('#buttonblock').css('display', 'none');

							$('#oneimg img').attr(
									'src',
									'/p/resources/BoardPhoto/'
											+ latelyck[size1]);
							$('#photoname1').val(size1);

							if (latelyck.length > 3) {
								$('#latelybox')
										.append('<div class="col" id ="asdasddsasda"><a class="page-link" href="#" aria-label="Next"><span aria-hidden="true" style="color: #000000ad;  text-decoration: none" onclick="front()">▶</span></a></div>	<div class="col" id ="ssssadas"><a class="page-link" href="#" aria-label="Previous"> <span aria-hidden="true" style="color: #000000ad; text-decoration: none;" onclick="back()">◀</span></a></div>')
								// 마지막 부터 보여주게 변경
							}

						} else if ((latelyck.length % 3) == 2
								&& latelyck.length < 3) {

							$('#latelybox')
									.append(
											'<div id="twoimg"><img id="imgtwo" width="128" height="128"></div>')
											 
											
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
								.append('<div class="col" id ="asdasddsasda"><a class="page-link" href="#" aria-label="Next"><span aria-hidden="true" style="color: #000000ad;  text-decoration: none" onclick="front()">▶</span></a></div>	<div class="col" id ="ssssadas"><a class="page-link" href="#" aria-label="Previous"> <span aria-hidden="true" style="color: #000000ad; text-decoration: none;" onclick="back()">◀</span></a></div>')
						}

						} else if ((latelyck.length % 3) == 0
								&& latelyck.length < 3) {
							alert('three');
							$('#latelybox')
									.append(
											'<div id="twoimg"><img id="imgtwo" width="128" height="128"></div>')
							$('#latelybox')
									.append(
											'<div id="threeimg"><img id="imgthree" width="128" height="128"></div>')
						
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
								.append('<div class="col" id ="asdasddsasda"><a class="page-link" href="#" aria-label="Next"><span aria-hidden="true" style="color: #000000ad;  text-decoration: none" onclick="front()">▶</span></a></div>	<div class="col" id ="ssssadas"><a class="page-link" href="#" aria-label="Previous"> <span aria-hidden="true" style="color: #000000ad; text-decoration: none;" onclick="back()">◀</span></a></div>')
					
							}

						} else if (latelyck.length >= 3) {
							$('#latelybox')
									.append(
											'<div id ="twoimg"style="width: 130px;height: 130px;border: 1px solid black; margin: 0 auto; margin-top: 10px"><img width="128"height="128"></div>')
							$('#latelybox')
									.append(
											'<div id ="threeimg"style="width: 130px;height: 130px;border: 1px solid black; margin: 0 auto; margin-top: 10px"><img width="128"height="128"></div>')
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
								.append('<div class="col" id ="asdasddsasda"><a class="page-link" href="#" aria-label="Next"><span aria-hidden="true" style="color: #000000ad;  text-decoration: none" onclick="front()">▶</span></a></div>	<div class="col" id ="ssssadas"><a class="page-link" href="#" aria-label="Previous"> <span aria-hidden="true" style="color: #000000ad; text-decoration: none;" onclick="back()">◀</span></a></div>')
							// 마지막 부터 보여주게 변경
							}
						}

					}

				});

function back() {
	alert('back');
	var size1 = $('#photoname1').val();
	var size2 = $('#photoname2').val();
	var size3 = $('#photoname3').val();
	alert('초기값' + size1);
	alert('초기값' + size2);
	alert('초기값' + size3)

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
		alert('쳌1')
	}
	if (size2 != null && (size2 - 3) >= 0) {

		size2 = size2 - 3;

	} else {

		alert('쳌2')


	}
	if (size3 != null && (size3 - 3) >= 0) {

		size3 = size3 - 3;

	} else {

		alert('쳌3')

	
	}
	
	if (size3 == ck3) {

		// 값이 변화가 없으면 없앰
		alert('3번 변화없음 ');
		size3 = -2;
		$('#oneimg').hide();
		$('#latelybox').css('height', '360px')
	} else {
		alert(size3);
		alert(latelyck[size3]);
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

	} else {3
		alert(size3);
	
		$('#imgtwo').attr('src', '/p/resources/BoardPhoto/' + latelyck[size2]);
	
		// 변화가 잇으면
	}

	if (size1 == ck1) {
		// 값이 변화가 없으면 없앰
		alert('1번 변화없음 ');

	
	} else {
		alert(size1);
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
	alert('size1'+size1);
	alert('비교값' + ck1);
	alert('비교값' + ck2);
	alert('비교값' + ck3);

}


function front() {
	var size1 = parseFloat($('#photoname1').val());
	var size2 = parseFloat($('#photoname2').val());
	var size3 = parseFloat($('#photoname3').val());
	$('#latelybox').css('height','490px')
	alert('초기값' + size1);
	alert('초기값' + size2);
	alert('초기값' + size3)

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

	alert('쳌크드')

	if (size3 != null && (size3 + 3) < latelyck.length) {
		
		size3 = size3 + 3;
		
	} else {
		alert('쳌1')
		
	}
	if (size2 != null && (size2 + 3) < latelyck.length) {

		size2 = size2 + 3;

	} else {
		
		alert('쳌2')
	}
	if (size1 != null && (size3 + 1) < latelyck.length) {

		size1 = size3 + 1;

	} else {

		alert('쳌3')
	}
	
	
	
	$('#photoname1').val(size1);

	
	
	$('#photoname2').val(size2);
	size3
	
	
	$('#photoname3').val(size3);

	
	
	$('#imgone').attr('src', '/p/resources/memberphoto/' + latelyck[size1]);
	
	
	$('#imgtwo').attr('src', '/p/resources/memberphoto/' + latelyck[size2]);
	
	
	$('#imgthree').attr('src' , '/p/resources/memberphoto/' + latelyck[size3]);


}