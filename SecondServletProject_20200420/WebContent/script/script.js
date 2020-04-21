$(document).ready(function() {
	$('#checkEmail').click(function() {
		if($(this).siblings('input[name=email]').val().trim()==''){
			alert('메일주소를 입력해주세요');
			$(this).siblings('input[name=email]').val('').focus();
			return;
		}
		$.ajax({
			url:'/SecondServletProject_20200420/checkEmail', 
			type:'post',
			data:{ email:$(this).siblings('input[name=email]').val() },
			success : function(data) {
				let obj = eval('('+data+')');
				alert(obj.message);
				if (obj.error!=0) {
					$("input[name=email]").val("").focus();
				}
			}
		});
	});
	
	$('#checkNick').click(function() {
		if($(this).siblings('input[name=nick]').val().trim()==''){
			alert('닉네임을 입력해주세요');
			$(this).siblings('input[name=nick]').val('').focus();
			return;
		}
		$.ajax({
			url:'/SecondServletProject_20200420/checkNick', 
			type:'post',
			data:{ email:$(this).siblings('input[name=nick]').val() },
			success : function(data) {
				let obj = eval('('+data+')');
				alert(obj.message);
				if (obj.error!=0) {
					$("input[name=nick]").val("").focus();
				}
			}
		});
	});
});
