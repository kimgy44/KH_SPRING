<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>우편번호 검색</title>
<%@ include file="../common/easyui_common.jsp" %>
</head>
<body>
	<div>
		<lavel for="dong">동이름 입력</lavel>
		<input id="dong" name="dong" class="easyui-textbox" style="width:300px"/>
		<a href="javascript:zipcodeSearch()" class="easyui-linkbutton">검색</a>
		<div id="d_zipcode"></div>
	</div>
</body>
</html>