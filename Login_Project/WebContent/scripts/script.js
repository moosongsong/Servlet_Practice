$(document).ready(function() {
	$('#btnlogin').click(function() {
//		var formData = new FormData($('#loginForm')[0]);
		
		$.ajax({
			url: $('#loginForm').attr('action'),
			type:$('#loginForm').attr('method'),
			data:{
				email:$('input[name=email]').val(),
				pass:$('input[name=pass]').val()
			},
			success: function(data) {
				console.log(data);
				//정상적으로 로그인 처리가 되었다면 
				//로그인에 성공하였습니다.라는 문구를 띄운다.
				//계정이 존재하지 않으면 서버측에서 보내는 메시지를 츌력한다.
				//비밀번호가 일치하지 읺는 경우 비밀번호가 일치하지 않는다라는 문구를 띄운다
			}
		});
	});
	
	$('#loginCheck').click(function() {
		
		$.ajax({
			
			url:'./loginCheck',
			type:'get',
			success: function(data) {
				console.log(data);
				//정상적으로 로그인 처리가 되었다면 
				//로그인에 성공하였습니다.라는 문구를 띄운다.
				//계정이 존재하지 않으면 서버측에서 보내는 메시지를 츌력한다.
				//비밀번호가 일치하지 읺는 경우 비밀번호가 일치하지 않는다라는 문구를 띄운다
			}
		});
	});
});