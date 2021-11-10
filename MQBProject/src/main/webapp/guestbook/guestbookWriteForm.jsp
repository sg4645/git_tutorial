<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록</title>
<style type="text/css">
div {
	color: red;
	font-size: 8pt;
	font-weight: bold;
}
h2 {
	color: black;
}
table {
	border-collapse: collapse;
}
#guestbookWriteForm tr td {
	color: black;
}
</style>
</head>
<body>
<h2>방명록 작성</h2>
<form name="guestbookWriteForm" id="guestbookWriteForm" method="post" action="">
	<table border="1">
		<!-- <tr>
		<input type="hidden" id="name" value="${sessionScope.name }">
			<td width="100" align="center">작성자</td>
			<td>
				<input type="text" name="name" id="name" size="15">
			</td>
		</tr> -->
		
		<tr>
			<td width="100" align="center">이메일</td>
			<td>
				<input type="email" name="email" id="email">
			</td>
		</tr>
		
		<tr>
			<td width="100" align="center">홈페이지</td>
			<td>
				<input type="text" name="homepage" id="homepage" value="http://" size="35">
			</td>
		</tr>
		
		<tr>
			<td width="100" align="center">제목</td>
			<td>
				<input type="text" name="subject" id="subject" size="50">
				<div id= "subjectDiv"></div>
			</td>
		</tr>
		
		<tr>
			<td width="100" align="center">내용</td>
			<td>
				<textarea name="content" id="content" cols="50" rows="15"></textarea>
				<div id= "contentDiv"></div>
			</td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">
				<input type="button" id="guestbookWriteBtn" value="글작성">
				<input type="reset" value="다시작성">
			</td>
		</tr>
	</table>
</form>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(function(){
	$('#guestbookWriteBtn').click(function(){
		$.ajax({
			url: '/MQBProject/guestbook/guestbookWrite.do',
			type: 'post',
			data: $('#guestbookWriteForm').serialize(),
			success: function(){
				alert("방명록 쓰기 성공");
				//location.href="/MQBProject/board/boardList.do?pg=1";
			},
			error: function(err){
				console.log(err);
			}
		});
	});
});
</script>
</body>
</html>















