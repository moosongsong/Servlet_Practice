$(document).ready(function() {
	$('#btn1').click(function() {
		$.ajax({
			url: './writeBoard',
		    type: 'post',
		    data: {
		    	title: $('#title').val(),
		    	content:$('#content').val()
		    },
		    success: function(data) {
		    	var obj = eval('('+data+')');
		    	alert(obj.message);
		    	if (obj.errno==9) {
					location.href='login.html';
				}
		    	else if(obj.errno==0){
		    		location.href='index.html';
		    	}
		    }
		});
	});
	
	$('#btn2').click(function() {
		history.back();
	});
});
