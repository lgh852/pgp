<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div>

	<h1>아이디 ${member.member_id}</h1>



	<p class="text-left">
		<button type="button"
			onclick="location.href='<%=request.getContextPath()%>/mypage/mp_update?member_id=${member.member_id}'"
			class="btn btn-primary" data-toggle="button" aria-pressed="false">
			설정</button>
	</p>

	<p class="text-left">
		<button type="button"
			onclick="location.href='<%=request.getContextPath()%>/mypage/mp_myphoto?member_id=${member.member_id}'"
			class="btn btn-primary" data-toggle="button" aria-pressed="false">
			나의 사진</button>
	</p>
	
	<p class="text-left">
		<button type="button"
			onclick="location.href='<%=request.getContextPath()%>/mypage/mp_scrap?member_id=${member.member_id}'"
			class="btn btn-primary" data-toggle="button" aria-pressed="false">
			나의 스크랩</button>
	</p>
	
	<p class="text-left">
		<button type="button"
			onclick="location.href='<%=request.getContextPath()%>/mypage/mp_myComment?member_id=${member.member_id}'"
			class="btn btn-primary" data-toggle="button" aria-pressed="false">
			나의 댓글</button>
	</p>
	



	<%-- <ul>
		<li><a href="<%=request.getContextPath()%>/mypage/mp_update?member_id=${member.member_id}">설정</a></li> 
		<li><a
			href="<%=request.getContextPath()%>/mypage/mp_scrap?member_id=${member.member_id}">스크랩</a></li>
		<li><a
			href="<%=request.getContextPath()%>/mypage/mp_myphoto?member_id=${member.member_id}">나의사진</a></li>
	</ul>
 --%>

</div>


<%-- <script>
  window.kakaoAsyncInit = function () {
    Kakao.Story.createShareButton({
      container: '#kakaostory-share-button'
    });
  };

  (function (d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) return;
    js = d.createElement(s); js.id = id;
    js.src = "//developers.kakao.com/sdk/js/kakao.story.min.js";
    fjs.parentNode.insertBefore(js, fjs);
  }(document, 'script', 'kakao-js-sdk'));
</script>

<a href="<%=request.getContextPath()%>/sidebar/share">공유</a>

<div id="kakaostory-share-button" data-url="http://localhost:8080/p/"></div> --%>



<meta http-equiv="X-UA-Compatible" content=&qquot;IE=edge"/>
<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width"/>

<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
<script src="/js/kakaolink.js"></script>

<div id="kakaostory-share-button"></div>
<script type='text/javascript'>
  //<![CDATA[
    // 사용할 앱의 JavaScript 키를 설정해 주세요.
    Kakao.init('63e0d0643d065b515683b9455c2f97b9');
    // 스토리 공유 버튼을 생성합니다.
    Kakao.Story.createShareButton({
      container: '#kakaostory-share-button',
      url: '<%=request.getContextPath()%>/mypage/mp_main',
      text: '카카오 개발자 사이트로 놀러오세요! #개발자 #카카오 :)'
    });
  //]]>
</script>


