$(document).ready(function() {
	$('button').click(function() {	
//		alert('click');
		$.ajax({
			url: './login',
			type:'post',
			data:{
				email:$('input[name=email]').val(),
				pass:$('input[name=pass]').val()
			},
			success: function(data) {
				var obj = eval('('+data+')');
		    	alert(obj.message);
		    	if (obj.errno==0) {
					location.href='boardWrite.html';
				}
		    	else{
		    		$('input').val('');
		    		$('input:first-child').focus();
		    	}
			}
		});
	});
});