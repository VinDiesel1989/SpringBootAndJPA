<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div data-role="page" id="pageLogin">
	<div data-role="header" data-theme="b" id="loginHeader">
		<a  class="ui-btn ui-shadow ui-corner-all ui-btn-icon-left ui-icon-home" href="#pageHome" style="font-size: 8pt" data-transition="silde">首页</a>
		<h1></h1>
		<a  class="ui-btn ui-shadow ui-corner-all ui-btn-icon-left ui-icon-edit" style="font-size: 8pt">注册</a>
	</div>
	<div data-role="content">
		<form id="loginForm" action="users/doLogin" method="post">
			<input type="hidden" name="loginType" value="10001">
			<!--  <label for="name">账户：</label> -->
			<input type="text" name="userName" id="username" value="" placeholder="手机号/用户名/邮箱">
			<!-- <label for="name">密码：</label> -->
			<input type="password" name="passWord" id="password" value="" placeholder="登录密码">
			<div data-role="controlgroup" data-type="vertical">
				<button id="loginBtn" class="ui-btn ui-shadow ui-corner-all ui-btn-icon-right ui-icon-user" style="font-size: 9pt">登录</button>
			</div>
		</form>
		<a href="#" class="forget">忘记密码?</a> <br />  
		<div class="ui-body ui-body-a ui-corner-all">
			<p>第三方登录：</p>
			<p>
				<a class="third-party-a">微信登录</a><br />
			</p>
			<p>
				<a class="third-party-a">新浪微博</a><br />
			</p>
		</div>
		
	</div>
	<div data-role="footer" data-position="fixed" data-theme="b">
			<h1>职场联盟</h1>
		</div>
</div>