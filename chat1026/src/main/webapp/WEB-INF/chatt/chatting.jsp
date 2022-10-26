<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel='stylesheet' type='text/css' href='./css/chatt.css'>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body>
	<div id='chatt'>
		<h1>WebSocket Chatting</h1>
		<!-- [ 사용자 대화명 입력받기 ] -->
		<input type='text' id='mid' value='지연'>
		<!-- [ 로그인 버튼 ] -->
		<input type='button' value='로그인' id='btnLogin'>
		<br/>
		<!-- [ 대화 내용 출력 ] -->
		<div id='talk'></div> <!-- // css에 scroll 처리함 (내용이 많아질경우) -->
		<!-- [ 메시지 입력 ] -->
		<div id='sendZone'>
			<textarea id='msg' value='hi...' ></textarea>
		<!-- [ 메시지 전송 버튼 ] -->
			<input type='button' value='전송' id='btnSend'>
		</div>
	</div>
	<script src='./js/chatt.js'></script>
</body>
</html>
<!-- 
http://localhost:9999/mychatt
 -->