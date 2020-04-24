//$.refresh = function(temp) {
//	$.ajax({
//		url:'/Board_Servlet_Project/showContent', 
//		type:'get',
//		data:temp,
//		success : function(data) {
//			let obj = eval('('+data+')');
//			let content = $('<tr/>').addClass(".conBox").appendTo($('#showCon>table'));
//			$('<td/>', {text : '제목'}).appendTo(content);
//			$('<td/>', {text : obj[i].title}).appendTo(content);
//			
//			let content2 = $('<tr/>').addClass(".conBox").appendTo($('#showCon>table'));
//			$('<td/>', {text : '작성자'}).appendTo(content2);
//			$('<td/>', {text : obj[i].writer}).appendTo(content2);
//		    
//			let content3 = $('<tr/>').addClass(".conBox").appendTo($('#showCon>table'));
//		    $('<td/>', {text : obj[i].good}).appendTo(content3);
//		    $('<td/>', {text : obj[i].bad}).appendTo(content3);
//		}
//	});
//	
//}

$(document).ready(function() {
	
	$.ajax({
	    url: '/Board_Servlet_Project/boardList',
	    type: 'get',
	    success: function(data) {
	    	var data = eval('('+data+')');
	    	for (var i = 0; i < data.length; i++) {
	    		let contentBox = $('<ul/>').addClass(".contentBox").appendTo($('#content'));
				$('<li/>', {text : data[i].id}).appendTo(contentBox);
			    $('<li/>', {text : data[i].regdate}).appendTo(contentBox);
			    $('<li/>', {text : data[i].writer}).appendTo(contentBox);
			    $('<li/>', {text : data[i].title}).appendTo(contentBox);
			    $('<li/>', {text : data[i].good}).appendTo(contentBox);
			    $('<li/>', {text : data[i].bad}).appendTo(contentBox);
			}
	    	$('#content > ul').click(function() {
	    		var num = $(this).children();
	    		console.log(num[0]);
	    		location.href='content.html';
	    		
	    	});
	    }
	});
//	$('#content > ul').click(function() {
//		var num = $(this).children();
//		console.log(num[0]);
//		$.ajax({
//		url:'/Board_Servlet_Project/showContent', 
//		type:'get',
//		data:temp,
//		success : function(data) {
//			let obj = eval('('+data+')');
//			let content = $('<tr/>').addClass(".conBox").appendTo($('#showCon>table'));
//			$('<td/>', {text : '제목'}).appendTo(content);
//			$('<td/>', {text : obj[i].title}).appendTo(content);
//			
//			let content2 = $('<tr/>').addClass(".conBox").appendTo($('#showCon>table'));
//			$('<td/>', {text : '작성자'}).appendTo(content2);
//			$('<td/>', {text : obj[i].writer}).appendTo(content2);
//		    
//			let content3 = $('<tr/>').addClass(".conBox").appendTo($('#showCon>table'));
//		    $('<td/>', {text : obj[i].good}).appendTo(content3);
//		    $('<td/>', {text : obj[i].bad}).appendTo(content3);
//		}
//	});
		
	});
	
	$('#newBtn').click(function() {
		location.href='newPage.html';
	});
	
	$('#btn2').click(function() {
		history.back();
	});
	
	$('#btn3').click(function() {
		history.back();
	});
	
	$('#btn4').click(function() {
		history.back();
	});
	
	$('#btn5').click(function() {
		history.back();
	});
	
	$('#btn1').click(function() {
		if($('#b_title').val().trim()==''){
			alert('제목을 입력해주세요.');
			$('#b_title').val('').focus();
			return;
		}
		if($('#b_writer').val().trim()==''){
			alert('이름을 입력해주세요.');
			$('#b_writer').val('').focus();
			return;
		}
		if($('#password').val().trim()==''){
			alert('비밀번호를 입력해주세요.');
			$('#password').val('').focus();
			return;
		}
		if($('textarea').val().trim()==''){
			alert('내용을 입력해주세요.');
			$('textarea').val('').focus();
			return;
		}
		$.ajax({
			url:'/Board_Servlet_Project/newContent', 
			type:'post',
			data:{ title:$('#b_title').val(), 
					writer:$('#b_writer').val(),
					password:$('#password').val(),
					content:$('textarea').val()
			},
			success : function(data) {
				let obj = eval('('+data+')');
				alert(obj.message);
			}
		});
	});
	

