$(document).ready(function() {
	$.ajax({
		url : './boardList',
		type : 'get',
		success : function(data) {
			console.log(data);
			var data = eval('(' + data + ')');

			for (var i = 0; i < data.length; i++) {
				let contentBox = $('<ul/>').addClass(".contentBox")
						.appendTo($('#content'));
				$('<li/>', {
					text : data[i].id
				}).appendTo(contentBox);
				$('<li/>', {
					text : data[i].title
				}).appendTo(contentBox);
				$('<li/>', {
					text : data[i].regdate
				}).appendTo(contentBox);
				$('<li/>', {
					text : data[i].good
				}).appendTo(contentBox);
				$('<li/>', {
					text : data[i].bad
				}).appendTo(contentBox);
			}
			$('#content > ul').click(function() {
				var num = $(this).children();
				console.log(num[0]);

				$.ajax({
					url : './showContent',
					type : 'get',
					data: {id : 10},
					success : function(temp) {
						console.log(temp);
						var str = eval('(' + temp + ')');

						 $('<div/>', {text:str.title}).appendTo($('#header'));
						 let tr = $('<tr/>').appendTo($('#tableCount'));
						 $('<td/>', {text : '아이디'}).appendTo(tr);
						 $('<td/>', {text : str.id}).appendTo(tr);
						
					}

				});

			});
		}
	});

	$('#newBtn').click(function() {
		location.href = 'boardWrite.html';
	});
});		
