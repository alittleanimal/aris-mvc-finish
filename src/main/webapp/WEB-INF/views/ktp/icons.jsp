<%@ page language="java" pageEncoding="utf-8"%>
<!doctype html>
<html lang="en">

<head>
	<title>Words | Shanghai University Class Assistant</title>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<!-- VENDOR CSS -->
	<link rel="stylesheet" href="/aris/resources/assets/vendor/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="/aris/resources/assets/vendor/font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" href="/aris/resources/assets/vendor/linearicons/style.css">
	<!-- MAIN CSS -->
	<link rel="stylesheet" href="/aris/resources/assets/css/main.css">
	<!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
	<link rel="stylesheet" href="/aris/resources/assets/css/demo.css">
	<!-- GOOGLE FONTS -->
	<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700" rel="stylesheet">
	<!-- ICONS -->
	<link rel="apple-touch-icon" sizes="76x76" href="/aris/resources/assets/img/apple-icon.png">
	<link rel="icon" type="image/png" sizes="96x96" href="/aris/resources/assets/img/favicon.png">
</head>

<body>
	<!-- WRAPPER -->
	<div id="wrapper">
		<!-- NAVBAR -->
		<nav class="navbar navbar-default navbar-fixed-top">
			<div class="brand">
				<a href="index.html"><img src="/aris/resources/assets/img/logo-dark.png" alt="Klorofil Logo" class="img-responsive logo"></a>
			</div>
			<div class="container-fluid">
				<div class="navbar-btn">
					<button type="button" class="btn-toggle-fullwidth"><i class="lnr lnr-arrow-left-circle"></i></button>
				</div>
				<form class="navbar-form navbar-left">
					<div class="input-group">
						<input type="text" value="" class="form-control" placeholder="Search dashboard...">
						<span class="input-group-btn"><button type="button" class="btn btn-primary">Go</button></span>
					</div>
				</form>
				<div class="navbar-btn navbar-btn-right">
					<a class="btn btn-success update-pro" href="#downloads/klorofil-pro-bootstrap-admin-dashboard-template/?utm_source=klorofil&utm_medium=template&utm_campaign=KlorofilPro" title="Upgrade to Pro" target="_blank"><i class="fa fa-rocket"></i> <span>UPGRADE TO PRO</span></a>
				</div>
				<div id="navbar-menu">
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown">
							<a href="#" class="dropdown-toggle icon-menu" data-toggle="dropdown">
								<i class="lnr lnr-alarm"></i>
								<span class="badge bg-danger">5</span>
							</a>
							<ul class="dropdown-menu notifications">
								<li><a href="#" class="notification-item"><span class="dot bg-warning"></span>您有一个新的点名</a></li>
								<li><a href="#" class="notification-item"><span class="dot bg-danger"></span>您的课程有了新的作业</a></li>
								<li><a href="#" class="notification-item"><span class="dot bg-success"></span>您的平时成绩已经更新</a></li>
								<li><a href="#" class="notification-item"><span class="dot bg-warning"></span>您的点名信息已更新</a></li>
								<li><a href="#" class="notification-item"><span class="dot bg-success"></span>您的作业成绩已经更新</a></li>
								<li><a href="#" class="more">查看更多消息</a></li>
							</ul>
						</li>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="lnr lnr-question-circle"></i> <span>å¸®å©</span> <i class="icon-submenu lnr lnr-chevron-down"></i></a>
							<ul class="dropdown-menu">
								<li><a href="#">基本功能</a></li>
								<li><a href="#">我的课程</a></li>
								<li><a href="#">我的作业</a></li>
								<li><a href="#">我的成绩</a></li>
							</ul>
						</li>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown"><img src="/aris/resources/assets/img/user.png" class="img-circle" alt="Avatar"> <span>Animal</span> <i class="icon-submenu lnr lnr-chevron-down"></i></a>
							<ul class="dropdown-menu">
								<li><a href="#"><i class="lnr lnr-user"></i> <span>我的账户</span></a></li>
								<li><a href="#"><i class="lnr lnr-envelope"></i> <span>我的消息</span></a></li>
								<li><a href="#"><i class="lnr lnr-cog"></i> <span>基本设置</span></a></li>
								<li><a href="#"><i class="lnr lnr-exit"></i> <span>退出账号</span></a></li>
							</ul>
						</li>
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
						<li><a href="index.jsp" class=""><i class="lnr lnr-home"></i> <span>主页</span></a></li>
						<li><a href="elements.jsp" class=""><i class="lnr lnr-code"></i> <span>课程</span></a></li>
						<li><a href="charts.jsp" class=""><i class="lnr lnr-chart-bars"></i> <span>考勤</span></a></li>
						<li><a href="panels.jsp" class=""><i class="lnr lnr-cog"></i> <span>公告</span></a></li>
						<li><a href="notifications.jsp" class=""><i class="lnr lnr-alarm"></i> <span>成绩</span></a></li>
						<li>
							<a href="#subPages" data-toggle="collapse" class="collapsed"><i class="lnr lnr-file-empty"></i> <span>个人信息</span> <i class="icon-submenu lnr lnr-chevron-left"></i></a>
							<div id="subPages" class="collapse ">
								<ul class="nav">
									<li><a href="page-profile.jsp" class="">个人信息</a></li>
									<li><a href="page-login.jsp" class="">登录</a></li>
									<li><a href="page-lockscreen.jsp  " class="">锁屏</a></li>
								</ul>
							</div>
						</li>
						<li><a href="tables.jsp" class=""><i class="lnr lnr-dice"></i> <span>资料</span></a></li>
						<li><a href="typography.jsp" class=""><i class="lnr lnr-text-format"></i> <span>作业</span></a></li>
						<li><a href="icons.jsp" class="active"><i class="lnr lnr-linearicons"></i> <span>留言板</span></a></li>
					</ul>
				</nav>
			</div>
		</div>
		<!-- END LEFT SIDEBAR -->
		<!-- MAIN -->
		<div class="main">
			<!-- MAIN CONTENT -->
			<div class="main-content">
				<div class="container-fluid">
					<h3 class="page-title">Icons</h3>
					<div class="panel panel-headline demo-icons">
						<div class="panel-heading">
							<h3 class="panel-title">Linearicons</h3>
							<p class="subtitle">For complete list, please visit <a href="https://linearicons.com/free" target="_blank">https://linearicons.com/free</a></p>
						</div>
						<div class="panel-body">
							<ul class="list-unstyled row">
								<li class="col-md-2 col-sm-4 col-xs-6">
									<span class="lnr lnr-home"></span> <span class="cssclass">lnr lnr-home</span>
								</li>
								<li class="col-md-2 col-sm-4 col-xs-6">
									<span class="lnr lnr-thumbs-up"></span> <span class="cssclass">lnr lnr-thumbs-up</span>
								</li>
								<li class="col-md-2 col-sm-4 col-xs-6">
									<span class="lnr lnr-pencil"></span> <span class="cssclass">lnr lnr-pencil</span>
								</li>
								<li class="col-md-2 col-sm-4 col-xs-6">
									<span class="lnr lnr-magic-wand"></span> <span class="cssclass">lnr lnr-magic-wand</span>
								</li>
								<li class="col-md-2 col-sm-4 col-xs-6">
									<span class="lnr lnr-drop"></span> <span class="cssclass">lnr lnr-drop</span>
								</li>
								<li class="col-md-2 col-sm-4 col-xs-6">
									<span class="lnr lnr-lighter"></span> <span class="cssclass">lnr lnr-lighter</span>
								</li>
								<li class="col-md-2 col-sm-4 col-xs-6">
									<span class="lnr lnr-sun"></span> <span class="cssclass">lnr lnr-sun</span>
								</li>
								<li class="col-md-2 col-sm-4 col-xs-6">
									<span class="lnr lnr-heart"></span> <span class="cssclass">lnr lnr-heart</span>
								</li>
								<li class="col-md-2 col-sm-4 col-xs-6">
									<span class="lnr lnr-inbox"></span> <span class="cssclass">lnr lnr-inbox</span>
								</li>
								<li class="col-md-2 col-sm-4 col-xs-6">
									<span class="lnr lnr-trash"></span> <span class="cssclass">lnr lnr-trash</span>
								</li>
								<li class="col-md-2 col-sm-4 col-xs-6">
									<span class="lnr lnr-cart"></span> <span class="cssclass">lnr lnr-cart</span>
								</li>
								<li class="col-md-2 col-sm-4 col-xs-6">
									<span class="lnr lnr-user"></span> <span class="cssclass">lnr lnr-user</span>
								</li>
								<li class="col-md-2 col-sm-4 col-xs-6">
									<span class="lnr lnr-bookmark"></span> <span class="cssclass">lnr lnr-bookmark</span>
								</li>
								<li class="col-md-2 col-sm-4 col-xs-6">
									<span class="lnr lnr-map"></span> <span class="cssclass">lnr lnr-map</span>
								</li>
								<li class="col-md-2 col-sm-4 col-xs-6">
									<span class="lnr lnr-map-marker"></span> <span class="cssclass">lnr lnr-map-marker</span>
								</li>
								<li class="col-md-2 col-sm-4 col-xs-6">
									<span class="lnr lnr-location"></span> <span class="cssclass">lnr lnr-location</span>
								</li>
								<li class="col-md-2 col-sm-4 col-xs-6">
									<span class="lnr lnr-rocket"></span> <span class="cssclass">lnr lnr-rocket</span>
								</li>
								<li class="col-md-2 col-sm-4 col-xs-6">
									<span class="lnr lnr-download"></span> <span class="cssclass">lnr lnr-download</span>
								</li>
							</ul>
						</div>
					</div>
					<div class="panel panel-headline demo-icons">
						<div class="panel-heading">
							<h3 class="panel-title">Font Awesome</h3>
							<p class="subtitle">For complete list, please visit <a href="http://fontawesome.io/icons/" target="_blank">http://fontawesome.io/icons/</a></p>
						</div>
						<div class="panel-body">
							<ul class="list-unstyled row">
								<li class="col-md-2 col-sm-4 col-xs-6">
									<span class="fa fa-home"></span> <span class="cssclass">fa fa-home</span>
								</li>
								<li class="col-md-2 col-sm-4 col-xs-6">
									<span class="fa fa-download"></span> <span class="cssclass">fa fa-download</span>
								</li>
								<li class="col-md-2 col-sm-4 col-xs-6">
									<span class="fa fa-upload"></span> <span class="cssclass">fa fa-upload</span>
								</li>
								<li class="col-md-2 col-sm-4 col-xs-6">
									<span class="fa fa-shopping-cart"></span> <span class="cssclass">fa fa-shopping-cart</span>
								</li>
								<li class="col-md-2 col-sm-4 col-xs-6">
									<span class="fa fa-calendar"></span> <span class="cssclass">fa fa-calendar</span>
								</li>
								<li class="col-md-2 col-sm-4 col-xs-6">
									<span class="fa fa-map"></span> <span class="cssclass">fa fa-map</span>
								</li>
								<li class="col-md-2 col-sm-4 col-xs-6">
									<span class="fa fa-location"></span> <span class="cssclass">fa fa-location</span>
								</li>
								<li class="col-md-2 col-sm-4 col-xs-6">
									<span class="fa fa-credit-card"></span> <span class="cssclass">fa fa-credit-card</span>
								</li>
								<li class="col-md-2 col-sm-4 col-xs-6">
									<span class="fa fa-database"></span> <span class="cssclass">fa fa-database</span>
								</li>
								<li class="col-md-2 col-sm-4 col-xs-6">
									<span class="fa fa-bell"></span> <span class="cssclass">fa fa-bell</span>
								</li>
								<li class="col-md-2 col-sm-4 col-xs-6">
									<span class="fa fa-envelope"></span> <span class="cssclass">fa fa-envelope</span>
								</li>
								<li class="col-md-2 col-sm-4 col-xs-6">
									<span class="fa fa-thumbs-up"></span> <span class="cssclass">fa fa-thumbs-up</span>
								</li>
								<li class="col-md-2 col-sm-4 col-xs-6">
									<span class="fa fa-line-chart"></span> <span class="cssclass">fa fa-line-chart</span>
								</li>
								<li class="col-md-2 col-sm-4 col-xs-6">
									<span class="fa fa-map-marker"></span> <span class="cssclass">fa fa-map-marker</span>
								</li>
								<li class="col-md-2 col-sm-4 col-xs-6">
									<span class="fa fa-paper-plane-o"></span> <span class="cssclass">fa fa-paper-plane-o</span>
								</li>
								<li class="col-md-2 col-sm-4 col-xs-6">
									<span class="fa fa-search"></span> <span class="cssclass">fa fa-search</span>
								</li>
								<li class="col-md-2 col-sm-4 col-xs-6">
									<span class="fa fa-shopping-bag"></span> <span class="cssclass">fa fa-shopping-bag</span>
								</li>
								<li class="col-md-2 col-sm-4 col-xs-6">
									<span class="fa fa-random"></span> <span class="cssclass">fa fa-random</span>
								</li>
							</ul>
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
				<p class="copyright">&copy; 2017 <a href="#" target="_blank">Theme I Need</a>. All Rights Reserved. More Information <a href="http://www.shu.edu.cn/IndexPage.html" target="_blank" title="上海大学">上海大学</a> - Collect from <a href="http://www.jwc.shu.edu.cn/jwc.html" title="上海大学教务处" target="_blank">上海大学教务处</a></p>
			</div>
		</footer>
	</div>
	<!-- END WRAPPER -->
	<!-- Javascript -->
	<script src="/aris/resources/assets/vendor/jquery/jquery.min.js"></script>
	<script src="/aris/resources/assets/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="/aris/resources/assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
	<script src="/aris/resources/assets/scripts/klorofil-common.js"></script>
</body>

</html>

