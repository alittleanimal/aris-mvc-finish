
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!doctype html>
<html lang="en">

<head>
<title>Course | Shanghai University Class Assistant</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<!-- VENDOR CSS -->
<link rel="stylesheet"
	href="/aris/resources/assets/vendor/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="/aris/resources/assets/vendor/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet"
	href="/aris/resources/assets/vendor/linearicons/style.css">
<!-- MAIN CSS -->
<link rel="stylesheet" href="/aris/resources/assets/css/main.css">
<!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
<link rel="stylesheet" href="/aris/resources/assets/css/demo.css">
<!-- GOOGLE FONTS -->
<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700"
	rel="stylesheet">
<!-- ICONS -->
<link rel="apple-touch-icon" sizes="76x76"
	href="/aris/resources/assets/img/apple-icon.png">
<link rel="icon" type="image/png" sizes="96x96"
	href="/aris/resources/assets/img/favicon.png">
</head>

<body>
	<!-- WRAPPER -->
	<div id="wrapper">
		<!-- NAVBAR -->
		<nav class="navbar navbar-default navbar-fixed-top">
			<div class="brand">
				<a href="index.html"><img
					src="/aris/resources/assets/img/logo-dark.png" alt="Klorofil Logo"
					class="img-responsive logo"></a>
			</div>
			<div class="container-fluid">
				<div class="navbar-btn">
					<button type="button" class="btn-toggle-fullwidth">
						<i class="lnr lnr-arrow-left-circle"></i>
					</button>
				</div>
				<form class="navbar-form navbar-left">
					<div class="input-group">
						<input type="text" value="" class="form-control"
							placeholder="Search dashboard..."> <span
							class="input-group-btn"><button type="button"
								class="btn btn-primary">Go</button></span>
					</div>
				</form>
				<div class="navbar-btn navbar-btn-right">
					<a class="btn btn-success update-pro"
						href="#downloads/klorofil-pro-bootstrap-admin-dashboard-template/?utm_source=klorofil&utm_medium=template&utm_campaign=KlorofilPro"
						title="Upgrade to Pro" target="_blank"><i class="fa fa-rocket"></i>
						<span>UPGRADE TO PRO</span></a>
				</div>
				<div id="navbar-menu">
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown"><a href="#"
							class="dropdown-toggle icon-menu" data-toggle="dropdown"> <i
								class="lnr lnr-alarm"></i> <span class="badge bg-danger">5</span>
						</a>
							<ul class="dropdown-menu notifications">
								<li><a href="#" class="notification-item"><span
										class="dot bg-warning"></span>您有一个新的点名</a></li>
								<li><a href="#" class="notification-item"><span
										class="dot bg-danger"></span>您的课程有了新的作业</a></li>
								<li><a href="#" class="notification-item"><span
										class="dot bg-success"></span>您的平时成绩已经更新</a></li>
								<li><a href="#" class="notification-item"><span
										class="dot bg-warning"></span>您的点名信息已更新</a></li>
								<li><a href="#" class="notification-item"><span
										class="dot bg-success"></span>您的作业成绩已经更新</a></li>
								<li><a href="#" class="more">查看更多消息</a></li>
							</ul></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"><i class="lnr lnr-question-circle"></i>
								<span>帮助</span> <i class="icon-submenu lnr lnr-chevron-down"></i></a>
							<ul class="dropdown-menu">
								<li><a href="#">基本功能</a></li>
								<li><a href="#">我的课程</a></li>
								<li><a href="#">我的作业</a></li>
								<li><a href="#">我的成绩</a></li>
							</ul></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"><img
								src="/aris/resources/assets/img/user.png" class="img-circle"
								alt="Avatar"> <span>Animal</span> <i
								class="icon-submenu lnr lnr-chevron-down"></i></a>
							<ul class="dropdown-menu">
								<li><a href="#"><i class="lnr lnr-user"></i> <span>我的账户</span></a></li>
								<li><a href="#"><i class="lnr lnr-envelope"></i> <span>我的消息</span></a></li>
								<li><a href="#"><i class="lnr lnr-cog"></i> <span>基本设置</span></a></li>
								<li><a href="#"><i class="lnr lnr-exit"></i> <span>退出账号</span></a></li>
							</ul></li>
						<!-- <li>
							<a class="update-pro" href="#downloads/klorofil-pro-bootstrap-admin-dashboard-template/?utm_source=klorofil&utm_medium=template&utm_campaign=KlorofilPro" title="Upgrade to Pro" target="_blank"><i class="fa fa-rocket"></i> <span>UPGRADE TO PRO</span></a>
						</li> -->
					</ul>
				</div>
			</div>
		</nav>
		<!-- END NAVBAR -->
		<!-- LEFT SIDEBAR -->
		<div id="sidebar-nav" class="sidebar">
			<div class="sidebar-scroll">
				<nav>
					<ul class="nav">
						<spring:url var="subjectUrl" value="/stock/view/subjectIndex" />
						<spring:url var="attendUrl" value="/stock/view/attendIndex" />
						<spring:url var="userUrl" value="/user/updateInput" />
						<spring:url var="messageUrl" value="/stock/view/messageIndex" />
						<spring:url var="loginUrl" value="/" />
						<li><a href="index.jsp" class=""><i class="lnr lnr-home"></i>
								<span>主页</span></a></li>
						<li><a href="${subjectUrl}" class=""><i
								class="lnr lnr-code"></i> <span>课程</span></a></li>
						<li><a href="${attendUrl}" class=""><i
								class="lnr lnr-chart-bars"></i> <span>考勤</span></a></li>
						<li><a href="panels.jsp" class="active"><i
								class="lnr lnr-cog"></i> <span>公告</span></a></li>
						<li><a href="notifications.jsp" class=""><i
								class="lnr lnr-alarm"></i> <span>成绩</span></a></li>
						<li><a href="#subPages" data-toggle="collapse"
							class="collapsed"><i class="lnr lnr-file-empty"></i> <span>个人信息</span>
								<i class="icon-submenu lnr lnr-chevron-left"></i></a>
							<div id="subPages" class="collapse ">
								<ul class="nav">
									<li><a href="${userUrl}" class="">个人信息</a></li>
									<li><a href="${loginUrl}" class="">登出</a></li>
									<li><a href="page-lockscreen.jsp  " class="">锁屏</a></li>
								</ul>
							</div></li>
						<li><a href="tables.jsp" class=""><i class="lnr lnr-dice"></i>
								<span>资料</span></a></li>
						<li><a href="typography.jsp" class=""><i
								class="lnr lnr-text-format"></i> <span>作业</span></a></li>
						<li><a href="${messageUrl}" class=""><i
								class="lnr lnr-linearicons"></i> <span>留言板</span></a></li>
					</ul>
				</nav>
			</div>
		</div>
		<!-- END LEFT SIDEBAR -->
		<!-- MAIN -->
		<div class="main" align="left">
			<!-- MAIN CONTENT -->
			<div class="main-content" align="left">
				<div class="container-fluid" align="left">
					<h3 class="page-title">公告</h3>
					<div class="row">
						<div class="col-md-6">
							<!-- CLASS2 -->
							<c:forEach var="noticeList" items="${noticeList}">
								<div class="panel">
									<div class="panel-heading">
										<div class="right">
											<button type="button" class="btn-toggle-collapse">
												<i class="lnr lnr-chevron-up"></i>
											</button>
											<button type="button" class="btn-remove">
												<i class="lnr lnr-cross"></i>
											</button>
										</div>
										<h3 class="panel-title" style="font-weight:bold;">
											<c:out value="${noticeList.title}"></c:out>
										</h3>
										
										<h5 class="subtitle">${noticeList.teachername}</h5>
										
										
									</div>
									<div class="panel-body">
										<p>
											<c:out value="${noticeList.context}"></c:out>
										</p>
									</div>


								</div>
							</c:forEach>
						</div>

						<!-- END CLASS2 -->
			

					<div class="col-md-6">

						<div class="panel" align="left">
							<div class="panel-body">
								<div style="font-size:20px ;float:left">教师公告</div>

							</div>

						</div>
						<!-- PANEL NO PADDING -->
						<div class="panel">
							<div class="panel-heading">
								<h3 class="panel-title">公告状态</h3>
								<div class="right">
									<button type="button" class="btn-toggle-collapse">
										<i class="lnr lnr-chevron-up"></i>
									</button>
									<button type="button" class="btn-remove">
										<i class="lnr lnr-cross"></i>
									</button>
								</div>
							</div>
							<div class="panel-body no-padding bg-primary text-center">
								<div class="padding-top-30 padding-bottom-30">
									<i class="fa fa-thumbs-o-up fa-5x"></i>
									<h3>请查看教师公告</h3>
								</div>
							</div>
						</div>
						<!-- END PANEL NO PADDING -->

					</div>
				</div>
			</div>
		</div>
		<!-- END MAIN CONTENT -->
	</div>
	<!-- END MAIN -->
	<div class="clearfix"></div>
	<footer>
		<div class="container-fluid">
			<p class="copyright">
				&copy; 2017 <a href="#" target="_blank">Theme I Need</a>. All Rights
				Reserved. More Information <a
					href="http://www.shu.edu.cn/IndexPage.html" target="_blank"
					title="上海大学">上海大学</a> - Collect from <a
					href="http://www.jwc.shu.edu.cn/jwc.html" title="上海大学教务处"
					target="_blank">上海大学教务处</a>
			</p>
		</div>
	</footer>
	</div>
	<!-- END WRAPPER -->
	<!-- Javascript -->
	<script src="/aris/resources/assets/vendor/jquery/jquery.min.js"></script>
	<script
		src="/aris/resources/assets/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script
		src="/aris/resources/assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
	<script src="/aris/resources/assets/scripts/klorofil-common.js"></script>
</body>

</html>

