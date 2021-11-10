$(function(){
	$.ajax({
		url:'/MQBProject/imageboard/getImageboardList.do',
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
				}).prepend($('<input/>',{
						type: 'checkbox',
						class: 'choice',
						name: 'choice',
						value: items.seq
				})))
				.append($('<td/>',{align:'center'})
					.append($('<img/>',{
					src: '../storage/'+items.image1,
					alt: items.image1,
					width: '200',
					height: '200'
					}).css('cursor','pointer')))
				.append($('<td/>',{
					align: 'center',
					text: items.imageName
				}))
				.append($('<td/>',{
					align: 'center',
					text: items.imagePrice.toLocaleString()
				}))
				.append($('<td/>',{
					align: 'center',
					text: items.imageQty.toLocaleString()
				}))
				.append($('<td/>',{
					align: 'center',
					text:(items.imagePrice*items.imageQty).toLocaleString()
				}))
				.appendTo($('#imageboardListTable'))
				
				
			});//each
			
			//paging
			$('#imageboardPagingDiv').html(data.imageboardPaging);
		},
		error: function(err){
			console.log(err);
		}
	});
	
	$('#all').click(function(){
		if($('#all').is(':checked')){
			$('.choice').prop('checked',true);
		} else {
			$('.choice').prop('checked',false);
		}
	});
	
	$('#choiceDeleteBtn').click(function(){
		var count= $('.choice:checked').length;
		
		if(count==0){
			alert('삭제할 항목을 선택하세요');
		} else {
			if(confirm('정말로 삭제하시겠습니까?')){
				$('#imageboardDeleteForm').submit();
				
			}
		}
		
	});
	
});