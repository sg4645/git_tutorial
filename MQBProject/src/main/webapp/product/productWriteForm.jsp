<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<h3>이미지 등록</h3>
 <form id="productWriteForm" enctype="multipart/form-data" method="post"
 action="/MQBProject/product/productWrite.do">
 	<table border="1" cellpadding="5" cellspacing="0">
 		<tr>
 			<td align="center" width="100">상품</td>
 			<td>
 				<input type="file" name="img" id="img">
 			</td>
 		</tr>
 		<tr>
 			<td align="center" width="100">상품명</td>
 			<td>
 				<input type="text" name="name" id="name" size="50">
 			</td>
 		</tr>
 		<tr>
 			<td align="center" width="100">단가</td>
 			<td>
 				<input type="text" name="unit" id="unit" size="50">
 			</td>
 		</tr>
 		<tr>
 			<td align="center" width="100">개수</td>
 			<td>
 				<input type="text" name="qty" id="qty" size="50">
 			</td>
 		</tr>
 		<tr>
 			<td align="center" width="100">할인율</td>
 			<td>
 				<input type="text" name="rate" id="rate" size="50">%
 			</td>
 		</tr>
 		<tr>
 			<td colspan="2" align="center">
 				<input type="button" id="productWriteBtn" value="계산">
				<input type="reset" value="취소">
 			</td>
 		</tr>
 	</table>
 </form>
 
<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$('#productWriteBtn').click(function(){
	$('#productWriteForm').submit();
});
</script>