<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
th {
	font-size: 16px;
}

td {
	font-size: 13px;
}

.subjectA:link { color: black; text-decoration: none; }
.subjectA:visited { color: black; text-decoration: none; }
.subjectA:hover { color: darkgreen; text-decoration: underline; }
.subjectA:active { color: black; text-decoration: none; }

#currentPaging {
	color: red;
	text-decoration: underline;
	cursor: pointer;
}
#paging {
	color: black;
	text-decoration: none;
	cursor: pointer;
}

</style>

</head>
<body>
<form id="imageboardDeleteForm" method="get" action="/MQBProject/imageboard/imageboardDelete.do">

<input type="hidden" id="pg" value="${requestScope.pg }">
<table id="imageboardListTable" border="1" cellspacing="0" cellpadding="5" frame="hsides" rules="rows">
	<tr>
		<th width="100"><input type="checkbox" id="all">번호</th>
		<th width="300">이미지</th>
		<th width="100">상품명</th>
		<th width="100">단가</th>
		<th width="100">개수</th>
		<th width="100">합계</th>
	</tr>
	

</table>
<input type="button" id="choiceDeleteBtn" value="선택삭제" style="float: left; margin-top: 5px;">
<div style="width: 750px; text-align: center;" id="imageboardPagingDiv">

</div>
</form>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/MQBProject/js/imageboardList.js">

</script>
<script type="text/javascript">
function imageboardPaging(param_pg){
	location.href='/MQBProject/imageboard/imageboardList.do?pg='+param_pg;
}
</script>



</body>
</html>