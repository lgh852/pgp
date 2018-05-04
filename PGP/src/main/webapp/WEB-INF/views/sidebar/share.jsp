	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<style>
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width"/>
<title>KakaoStory Share Button Demo - Kakao JavaScript SDK</title>
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
</head>
<body>

<div id="kakaostory-share-button"></div>
<script type='text/javascript'>
  //<![CDATA[
    // 사용할 앱의 JavaScript 키를 설정해 주세요.
    Kakao.init('63e0d0643d065b515683b9455c2f97b9');
    // 스토리 공유 버튼을 생성합니다.
    Kakao.Story.createShareButton({
      container: '#kakaostory-share-button',
      url: 'https://developers.kakao.com',
      text: '카카오 개발자 사이트로 놀러오세요! #개발자 #카카오 :)'
    });
  //]]>
</script>


</body>
</html>