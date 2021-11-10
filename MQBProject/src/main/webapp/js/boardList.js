$(function(){
	$.ajax({
		url:'/MQBProject/board/getBoardList.do',
		type:'post',
		data:'pg='+$('#pg').val(),
		dataType: 'json',
		success: function(data){
			//alert(JSON.stringify(data));
			$.each(data.list, function(index, items){
				$('<tr/>')
				.append($('<td/>',{
					align: 'center',
					text: items.seq
				}))
				.append($('<td/>',{
					//text: items.subject
				}).append($('<a/>',{
					href: '#',
					text: items.subject,
					class: 'subjectA',
					id: 'subject_'+items.seq
					})))
				.append($('<td/>',{
					align: 'center',
					text: items.id
				}))
				.append($('<td/>',{
					align: 'center',
					text: items.hit
				}))
				.append($('<td/>',{
					align: 'center',
					text: items.logtime
				}))
				.appendTo($('#boardListTable'));
				
				//답글
				for(var i=0;i<items.lev;i++){
					$('#subject_'+items.seq).before('&emsp;');
				}
				
				if(items.pseq != 0){
					$('#subject_'+items.seq).before($('<img>',{
						src: '../image/reply.gif',
						alt: '답글이미지',
						width: '10px',
						height: '10px'
					}));
				}
				
				
				//로그인 여부
				$('#subject_'+items.seq).click(function(){
					if(data.memId == null){
						alert('먼저 로그인 하세요');
					} else{
						location.href='/MQBProject/board/boardView.do?seq='+items.seq+'&pg='+$('#pg').val();
					}
				});
				
			}); //each
			
			//페이징 처리
			$('#boardPagingDiv').html(data.boardPaging);
			
		},
		error: function(err){
			console.log(err);
		}
	});
	

	
});