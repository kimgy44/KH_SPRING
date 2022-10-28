<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/css/user/login.css"> 
<link href="/static/bootstrap.min.css" rel="stylesheet">
<title>로그인</title>
<style type="text/css">

/* 백그라운드 이미지 
.header-background-area {
    width: 1903px;
    margin: 0 auto;
}
    .header-background-area > img {
        position: absolute;
        z-index: -5;
        display: block;
        top: 0;
        width: 1903px;
        align: center;
        object-fit:cover; 
        
    }
*/    
#main-title {
    width: 100%;
    height: 278px;
    font-size: 60px;
    font-family: 'Jal_Onuel';
    color: #ffffff;
    text-align: center;
    position: absolute;
	top: 101px;
    line-height: 4.7;
    z-index: -2;
}
.frame {
	width:1258px;
	height:inherit;
	margin:0 auto;
	/* background-color:yellow; */
}
.height-fixed {
	width: 100%;
	height: 520px;
	margin-top: 100px;
	margin-bottom: 100px;
}
.left-login {
	width:700px;
	height: 100%;
	display:inline-block;
}
.color-frame {
	width: 600px;
	height: 100%;
	margin: auto;
/* 	border:1px solid #fdb504; */
	border:1px solid #50356e;
	display:inline-block;
	float:left;
}
.color-frame.right-frame {
	margin-top: 0px;
}
.color-frame:first-child {
	margin-right: 50px;
}
h2 {
	font-size:38px;
	margin-top:60px;
	text-align:center;
	
}
h4 {
	font-size:20px;
	text-align:center;
	margin-top:30px;
	font-weight:400;
	margin-bottom:50px;
}
.left-inner-box {
	width:300px;
	margin:0 auto;
}
.input-box{ 
	width: 300px;
	height:inherit;
	position:relative; 
	margin:20px auto; 
	display: block;
}
.input-box > input{ 
	background:transparent; 
	border:none; 
	border-bottom: solid 1px #ccc; 
	padding:20px 0px 5px 0px; 
	font-size:14pt; width:100%; 
}
.input-box p {
	text-align: center;
	margin-top: 30px;
	color: #888;
}
input::placeholder{ 
	color:transparent; 
}

input:placeholder-shown + label{ 
	color:#aaa; 
	font-size:14pt; 
	top:15px; 
}
input:focus + label, label{ 
/* 	color:#fdb504;  */
	color:black; 
	font-size:10pt; 
	pointer-events: none; 
	position: absolute; 
	left:0px; top:0px; 
	transition: all 0.2s ease ; 
}
input:focus, input:not(:placeholder-shown){ 
	border-bottom: solid 1px #8aa1a1; 
	outline:none; 
}
.login-bottom-area {
	width: 186px;
	margin: 20px auto 0;
}
/* 자동로그인 */
.auto-login {
	width: 100px;
	float: left;
}
.find-area {
	color: #888;
}
.find-area:last-child {
	margin-left: 10px;
}
.find-area:hover {
	color: #0160ff;
}
.kakao-btn img {
	width:300px;
	height: 45px;
	margin-top: 20px;
	margin-bottom: 200px;
}
#left-login-bt {
	width: 100%;
	height: 40px;
	margin-top: 20px;
	background-color:#fdb504;
	color: #fff;
	border:0;
	font-size: 16px;
	font-weight: 600;
	cursor:pointer;
}
/* 구글로그인 */
#GgCustomLogin {
	margin-top: 80px;
	
}
.google-login {
	display: inline-block;
	border-radius: 3px;
	border: 1px solid #e3e4e5;
	cursor: pointer;
	height: 40px;
	margin-top: 20px;
	margin-left: 80px;
	z-index: -1;
	opacity: 0%;
}
.fake-glogin {
	width: 300px;
	height: 45px;
	display: block;
	border: 1px solid #e3e4e5;
	border-radius: 5px;
	z-index: 1;
	margin-top: -40px;
	line-height: 45px;
}
.fake-glogin img {
	width: 26px;
	margin: 10px 0 0 8px;
	
}
.fake-glogin p {
	display: block;
	width: 100%;
	height: 20px;
	line-height: 48px;
	text-align: center;
	margin-top: -54px;
	margin-left: 5px;
	font-family: 'Noto Sans KR', sans-serif;
	--letter-spacing: -1.2px;
	font-size: 14px;
	font-weight: 600;
	color: #333;
}


</style>
</head>
<body>
로그인 페이지
</body>

<!-- ########## [[ 로그인폼 시작 ]] ########## -->
 	<div class="container ">
      
		<div class="frame">
			<div class="height-fixed">
			<div class="color-frame">
				<h2>일반회원 로그인</h2>
				<div class="left-inner-box">
				
					<form id="loginAction"  method="POST">
					<!-- <form action="login.dz" method="POST"> -->
						<div class="input-box"> 
							<input id="username" type="text" name="username" placeholder="아이디"> 
							<label for="username">아이디</label> 
						</div> 
						<div class="input-box"> 
							<input id="password" type="password" name="password" placeholder="비밀번호"> 
							<label for="password">비밀번호</label> 
						</div> 
						<!-- id="loginBtn"  -->
						<input type="submit" id="left-login-bt" value="로그인"> 
						<!-- csrf 보안을 위한 코드 -->
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
						<div class="login-bottom-area">
							<!-- <div class="auto-login">
								<input id = "remember_me" name ="remember-me" type = "checkbox"/>&nbsp;로그인유지<br>
							</div> -->
							<div class=" find">
							<a class="find-area" href="">아이디 찾기</a>
							<a class="find-area" href="">비밀번호 찾기</a>
							<a class="find-area" href="/memberForm">회원가입</a>
							</div>
							
						</div>
					</form>
				</div>
			</div>
	
			</div>

		</div>
</div>
<!-- ########## [[ 로그인폼 끝 ]] ########## -->

</html>