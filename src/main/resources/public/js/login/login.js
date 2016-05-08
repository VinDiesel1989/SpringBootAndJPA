/**
 * 登录控制
 */
$(function(){
	var loginForm =$("#loginForm");
	$("#loginBtn").on("click" , function(){
		alert(loginForm.serialize());
		$.ajax({
			type:'POST',
			url:loginForm.attr("action"),
			data:loginForm.serialize(),
			success:function(data){
				console.log(data);
			},
			error:function(){
				alert("error");
			}
		});
	})
});