<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="snippets/header.jsp"></jsp:include>
	<jsp:include page="snippets/styles.jsp"></jsp:include>
</head>
<body>
	<!-- HOME BEING -->
	<div data-role="page" id="pageHome">
		<div data-role="header" data-theme="b">
			<h1>学习圈</h1>
		</div>

		<nav data-role="navbar">
			<ul>
				<li><a href="#home" data-rel="dialog" data-icon="home">首页</a></li>
				<li><a href="#email" data-rel="dialog" data-icon="grid">邮件</a></li>
				<li><a href="#phonebook" data-rel="dialog" data-icon="search">通讯录</a></li>
				<li><a href="#calendar" data-rel="dialog" data-icon="star">日历</a></li>
				<li><a href="#pageLogin" data-rel="dialog" data-icon="star" data-transition="silde">登录</a></li>
			</ul>
		</nav>

		<div data-role="content">
			<p style="text-align: center; color: grey;">请点击上面的按钮来测试
				jQueryMobile。</p>

			<div id="content">

				<div id="thumbs">
					<c:forEach items="${topics }" var="t">
						<div class="imgbox">
							<img src="/images/masonry.png">
						</div>
					</c:forEach>
				</div>
				<div id="page_nav">
					<a href="next_link">下一页</a>
				</div>
			</div>

			<!-- USER CENTER  -->
			<div data-role="panel" id="leftpanel3" data-position="left"
				data-display="overlay" data-theme="a">
				<h3>个人中心：</h3>
				<p>

					This panel is positioned on the left with the overlay display mode.
					The panel markup is <em>after</em>
				</p>
				<a href="#demo-links" data-rel="close"
					class="ui-btn ui-shadow ui-corner-all ui-btn-a ui-icon-delete ui-btn-icon-left ui-btn-inline">注销</a>
			</div>
			<!-- USER CENTER  END-->
			
			
			<!--  -->
			<div data-role="panel" id="right-panel" data-display="overlay"
				data-position="right">

				<ul data-role="listview" data-icon="false">
					<li data-icon="delete"><a href="#" data-rel="close"></a></li>
					<li data-role="list-divider">软件/互联网开发/系统集成</li>
					<li><a href="#">软件工程师</a></li>
					<li><a href="#">软件研发工程师</a></li>
					<li><a href="#">高级软件工程师</a></li>
					<li><a href="#">系统架构设计师</a></li>
					<li><a href="#">需求工程师</a></li>
					<li><a href="#">系统分析员</a></li>
					<li><a href="#">数据库开发工程师</a></li>
					<li><a href="#">手机软件开发工程师</a></li>
					<li><a href="#">WEB前端开发</a></li>
				</ul>

			</div>
			<!-- /panel -->
		</div>

		<!-- BOTTOM NAV  -->
		<div data-role="footer" data-position="fixed" data-fullscreen="true" data-theme="b">
			<div data-role="navbar" data-grid="c">
				<ul>
					<li><a href="#leftpanel3">个人中心</a></li>
					<li><a href="#">发帖/提问</a></li>
					<li><a href="#">查看笔记</a></li>
					<li><a href="#right-panel" class="ui-btn-active">分类</a></li>
				</ul>
			</div>
		</div>
		<!-- BOTTOM NAV END -->
	</div>
	<!-- HOME END -->
	
	
	
	
	

	<div data-role="page" id="email">
		<div data-role="header">
			<h1>邮件数量</h1>
		</div>

		<div data-role="content">
			<ul data-role="listview" data-inset="true">
				<li><a href="#">收件箱<span class="ui-li-count">25</span></a></li>
				<li><a href="#">发件箱<span class="ui-li-count">432</span></a></li>
				<li><a href="#">垃圾箱<span class="ui-li-count">7</span></a></li>
			</ul>
			<a href="#pageHome" data-role="button" data-inline="true"
				data-icon="back">返回</a>
		</div>

		<div data-role="footer" data-position="fixed">
			<h1>页脚文本</h1>
		</div>
	</div>

	<div data-role="page" id="home">
		<div data-role="header">
			<h1>首页</h1>
		</div>

		<div data-role="content">
			<p>这里是首页。</p>
			<a href="#pageHome" data-role="button" data-inline="true"
				data-icon="back">返回</a>
		</div>

		<div data-role="footer">
			<h1>页脚文本</h1>
		</div>
	</div>

	<div data-role="page" id="home2">
		<div data-role="header">
			<h1>首页</h1>
		</div>

		<div data-role="content">
			<p>Home Is Where The Heart Is!</p>
			<a href="#pageHome" data-role="button" data-inline="true"
				data-icon="back">返回</a>
		</div>

		<div data-role="footer">
			<h1>页脚文本</h1>
		</div>
	</div>


	<div data-role="page" id="calendar">
		<div data-role="header">
			<h1>日历</h1>
		</div>

		<div data-role="content">
			<ul data-role="listview" data-inset="true">
				<li data-role="list-divider">周三, 10 月 7 日, 2013 年 <span
					class="ui-li-count">2</span></li>
				<li><a href="#">
						<h2>会议</h2>
						<p>在 10:00 提醒</p>
						<p class="ui-li-aside">三楼会议室</p>
				</a></li>
				<li><a href="#">
						<h2>约会</h2>
						<p>在 18:00 提醒</p>
						<p class="ui-li-aside">小南国餐厅</p>
				</a></li>
			</ul>
			<a href="#pageHome" data-role="button" data-inline="true"
				data-icon="back">返回</a>
		</div>
	</div>

	<div data-role="page" id="phonebook">
		<div data-role="header">
			<h1>通讯录</h1>
			<a href="#pageHome" data-role="button" class="ui-btn-right"
				data-icon="back">返回</a>
		</div>

		<div data-role="content">
			<ul data-role="listview" data-autodividers="true" data-inset="true"
				data-filter="true">
				<li><a href="#">Bill Gates</a></li>
				<li><a href="#">George Bush</a></li>
				<li><a href="#">Thomas Carter</a></li>
			</ul>
		</div>
	</div>
	
	
	<!-- 登录页-->
	<jsp:include page="login/login.jsp"></jsp:include>

	 
</body>
</html>
