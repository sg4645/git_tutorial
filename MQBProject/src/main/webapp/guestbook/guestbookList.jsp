<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
a { color:#000; text-decoration: none; outline: none}
#pagingA:hover {
	text-decoration: underline;
}


</style>
</head>
<body>
<input id="pg" type="hidden" value="${requestScope.pg }">
<%-- 	
<table id="guestbookListTable" border="1">

	<tr>
		<td width="100" align="center">작성자</td>
		<td width="100" align="center"><%=guestbookDTO.getName() %></td>
        <td width="100" align="center">작성일</td>
        <td width="100" align="center"><%=guestbookDTO.getLogtime() %></td>
	</tr>
	
	<tr>
		<td>이메일</td>
		<td colspan="3" align="center"><%=guestbookDTO.getEmail() %></td>
	</tr>
	
	<tr>
		<td>홈페이지</td>
		<td colspan="3" align="center"><%=guestbookDTO.getHomepage() %></td>
	</tr>
	
	<tr>
		<td>제목</td>
		<td colspan="3" align="center"><%=guestbookDTO.getSubject() %></td>
	</tr>
	
	<tr>
		<td colspan="4"><pre><%=guestbookDTO.getContent() %></pre></td>
	</tr> 
</table>
	<hr width="450" align="left" color="red">
	--%>


<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(function(){
	$.ajax({
		url:'/MQBProject/guestbook/getGuestbookList.do',
		type:'post',
		data:'pg='+$('#pg').val(),
		dataType: 'json',
		success: function(data){
			//alert(JSON.stringify(data));
			$.each(data.list, function(index, items){
				$('<table/>',{id:'guestbookListTable', border: '1'})
				.appendTo('section');
				
				
				$('<tr/>')
				.append($('<td/>',{
					width: '50',
					align: 'center',
					text: '작성자'
				}))
				.append($('<td/>',{
					width: '100',
					align: 'center',
					text: items.name
				}))
				.append($('<td/>',{
					width: '100',
					align: 'center',
					text: '작성일'
				}))
				.append($('<td/>',{
					width: '100',
					align: 'center',
					text: items.logtime
				}))
				.appendTo($('#guestbookListTable'));
				
				$('<tr/>')
				.append($('<td/>',{
					text: '이메일'
				}))
				.append($('<td/>',{
					colspan: '3',
					align: 'center',
					text: items.email
				}))
				.appendTo($('#guestbookListTable'));
				
				$('<tr/>')
				.append($('<td/>',{
					text: '홈페이지'
				}))
				.append($('<td/>',{
					colspan: '3',
					align: 'center',
					text: items.homepage
				}))
				.appendTo($('#guestbookListTable'));
				
				$('<tr/>')
				.append($('<td/>',{
					text: '제목'
				}))
				.append($('<td/>',{
					colspan: '4',
					text: items.content
				}))
				.appendTo($('#guestbookListTable'));
				
				$('<tr/>')
				.append($('<td/>',{
					colspan: '3',
					align: 'center',
					text: items.subject
				}))
				.appendTo($('#guestbookListTable'));
				
				
				$('<hr/>',{
					width: '450',
					align: 'left',
					color: 'red'
				})
				.appendTo($('#guestbookListTable').after());
			}); //each
		},
		error: function(err){
			console.log(err);
		}
	});
});
</script>
</body>
</html>

























