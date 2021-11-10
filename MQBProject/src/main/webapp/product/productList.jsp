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


<input type="hidden" id="pg" value="${requestScope.pg }">
<table id="productListTable" border="1" cellspacing="0" cellpadding="5" frame="hsides" rules="rows">
	<tr>
		<th width="100">번호</th>
		<th width="200">이미지</th>
		<th width="100">상품명</th>
		<th width="100">단가</th>
		<th width="100">개수</th>
		<th width="100">합계</th>
		<th width="100">할인율</th>
		<th width="100">할인액</th>
		<th width="100">가격</th>
	</tr>
	

</table>


<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(function(){
	$.ajax({
		url:'/MQBProject/product/getProductList.do',
		type:'post',
		data:'pg='+$('#pg').val(),
		dataType: 'json',
		success: function(data){
			console.log(JSON.stringify(data));
			$.each(data.list, function(index, items){
				$('<tr/>')
				.append($('<td/>',{
					align: 'center',
					text: items.seq
				}))
				.append($('<td/>',{align:'center'})
						.append($('<img/>',{
							src: '../storage/'+items.img,
							alt: items.img,
							width: '150',
							height: '150'
							}).css('cursor','pointer')))
				.append($('<td/>',{
					align: 'center',
					text: items.name
				}))
				.append($('<td/>',{
					align: 'center',
					text: items.unit.toLocaleString()
				}))
				.append($('<td/>',{
					align: 'center',
					text: items.qty.toLocaleString()
				}))
				.append($('<td/>',{
					align: 'center',
					text: items.total.toLocaleString()
				}))
				.append($('<td/>',{
					align: 'center',
					text: items.rate.toLocaleString()+'%'
				}))
				.append($('<td/>',{
					align: 'center',
					text: items.discount.toLocaleString()
				}))
				.append($('<td/>',{
					align: 'center',
					text: items.price.toLocaleString()
				}))
				.appendTo($('#productListTable'))
				
				
			});//each
			
			
		},
		error: function(err){
			console.log(err);
		}
	});
	
		
});
</script>



</body>
</html>