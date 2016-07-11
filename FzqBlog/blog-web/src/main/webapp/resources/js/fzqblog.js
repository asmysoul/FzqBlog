$(document).ready(function() {
	var fzqblog = {};
	fzqblog.resultCode = {
		"SUCCESS":200,
		"LOGINTIMEOUT":401,
		"NOPERMISSION":403,
		"CODEERROR":425
	}

	$("ul.tag li").click(function(event) {
	$('ul.tag li').removeClass('act');
	$(this).addClass('act');
	
	});

	$('#reset').click(function(event) {
			$('#username').val();
			$('#email').val();
			$('#password').val();
			$('#confirmPassword').val();
	});
	function checkForm(content,doc){
		var d = dialog({
			    content: content,
			   	align: 'right',
			    quickClose: true// 点击空白处快速关闭
			});
			d.show(document.getElementById(doc));
	}

	$('#register').click(function(event) {
		var	username = $('#username').val();
		var	email = $('#email').val();
		var	password = 	$('#password').val();
		var	confirmPassword = $('#confirmPassword').val();
		var emailreg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
		var passwordreg = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$/;

		if(username == null || $.trim(username) == ''){
			checkForm('用户名不能是空串','username');
		}
		else if(username.indexOf(" ")> -1){
			checkForm('用户名不能含有空格','username');
		}
		else if(username.length < 6){
			checkForm('用户名长度不能小于6个字符','username');			   
		}
		else if(username.length > 20){
			checkForm('用户名长度不能大于20个字符','username');		
		}
		else if(!emailreg.test(email)){
			checkForm('请输入正确的常用邮箱',"email");
		}
		else if(password == null || $.trim(password) == ''){
			checkForm('密码不能是空串','password');
		}
		else if(password.indexOf(" ")> -1){
			checkForm('密码不能含有空格','password');
		}
		else if(password.length < 6){
			checkForm('密码长度不能小于6个字符','password');			   
		}
		else if(password.length > 16){
			checkForm('密码长度不能大于16个字符','password');			   
		}
		else if(!passwordreg.test(password)){
			checkForm('密码必须含有字母和数字','password');	
		}
		else if(confirmPassword != password){
			checkForm('两次输入密码必须一致','confirmPassword');	
		}
		else{
			$.ajax({
				url: 'register.do',
				type: 'post',
				dataType: 'json',
				data: $('#registerform').serialize(),
				success: function(data){
					if(data.errorMsg==null){
						var d = dialog({
							    content: "<div><img src='../resources/images/loading.gif' />&nbsp;&nbsp;&nbsp;加载中</div>",
							});
						d.showModal();
						setTimeout(function () {
							d.close().remove();
						}, 2000);
					}
					else{
					var d = dialog({
						width:200,
					    content: data.errorMsg,
					    quickClose: true// 点击空白处快速关闭
				});
			d.show();
					}
				}
			});
			
			
		} 
	});

							}
	);