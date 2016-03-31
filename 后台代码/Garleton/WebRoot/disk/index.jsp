<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<head>
	<base href="<%=basePath%>">
	
	<meta charset="UTF-8">
	<title><a href="">Garleton Academy</a></title>
	<link rel="stylesheet" href="/Garleton/bootstrap3.3.6/dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="/Garleton/css/index.css">
	<link rel="stylesheet" href="/Garleton/css/curtain.css">
	<link rel="stylesheet" href="/Garleton/css/myBreadcrumb.css">
	<link rel="stylesheet" href="/Garleton/css/search_icon.css"/>
	<link rel="stylesheet" href="/Garleton/css/pubuliu.css"/>
</head>
<body>
	<div id="curtain">
		
		<div class="wrapper">
			<form method="post" action="userAction!log" id="sign_in_form">
				
				<input type="text" placeholder="用户名" name="name"><br/>
				<input type="text" placeholder="密码" name="pwd"><br/>
				<div><input type="submit" value="Sign In"></div>

			</form>

			<form method="post" id="sign_up_form" action="userAction!reg" enctype="multipart/form-data">
					
				<label>照片:</label>
				
				<input type="file" name="file"/><br/>
				
					
				<input type="text" placeholder="姓名" name="name"><br/>

				<input type="password" placeholder="密码" name="pwd" id="first_pwd"><br/>
				<input type="password" placeholder="重新输入密码" id="second_pwd"><br/>

				<label>男<input type="radio" name="sex" value="male" ></label>
				<label>女<input type="radio" name="sex" value="female" checked="checked"></label><br/>

				<input type="text" placeholder="单位" name="unit" ><br/>
				<input type="text" placeholder="电话" name="tel" ><br/>
				<input type="text" placeholder="手机" name="cel" ><br/>
				
				
				
				<input type="text" placeholder="邮箱" name="email"><br/>
				
				
				<div><input type="submit" value="Sign Up"></div>

			</form>
		</div>

	</div>
	<header id="header">
		<div id="top_info"></div>
		<div id="carousel">
			<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
			  <!-- Indicators -->
			  <ol class="carousel-indicators">
			    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
			    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
			    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
			  </ol>

			  <!-- Wrapper for slides -->
			  <div class="carousel-inner" role="listbox">
			    <div class="item active">
			      <img src="/Garleton/img/scope2.jpg" alt="...">
			      <div class="carousel-caption">
			        <h2>红利息</h2>
			      </div>
			    </div>
			    <div class="item">
			      <img src="/Garleton/img/scope4.jpg" alt="..." >
			      <div class="carousel-caption">
			        <h2>胡光延</h2>
			        <p>胡光延也不容易呀</p>
			      </div>
			    </div>
			    <div class="item">
			      <img src="/Garleton/img/scope5.jpg" alt="..." >
			      <div class="carousel-caption">
			        <h2>肥货</h2>
			        <p>我觉得还是说些有用的比较好</p>
			      </div>
			    </div>
			    ...
			  </div>

			  <!-- Controls -->
			  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
			    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
			    <span class="sr-only">Previous</span>
			  </a>
			  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
			    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			    <span class="sr-only">Next</span>
			  </a>
			</div>
		</div>
		<nav id="nav_bar">
			<div id="logo">
				Garleton Academy
			</div>
				<ul class="myBreadcrumb">
				<li><a href="#">Home</a></li>
				<li><a href="#">Vehicles</a></li>
				<li><a href="#">Vans</a></li>
				<li><a href="#">Camper Vans</a></li>
			</ul>
			
			<div class="search">
			
				<div class="category">
					
					<a href="" class="search_rule">类别</a>
					<ul>
						<li><a href="">文章名</a></li>
						<li><a href="">时间</a></li>
						<li><a href="">发布人</a></li>
					</ul>	
				</div>
			
				<div class="search_ajax">
					<input type="text" placeholder="支持模糊匹配" id="search_bar"/>
				
					<ul id="search_result">
						<li><a>1234</a></li>
						<li><a>1234</a></li>
						<li><a>1234</a></li>
						
					</ul>
				</div>
				
				<div class="icon"><a></a></div>
			</div>
			
			<ul class="sign">
				
				<li><a href="" id="sign_in">Sign In</a></li>
				<li><a href="" id="sign_up">Sign Up</a></li>

			</ul>
		</nav>
	</header>
	<div id="wrapper">
		<article id="container">
			
		</article>
		<aside>
			<header></header>
			<div id="advice"></div>
		</aside>
	</div>
	<footer>
		<div id="footer_info">
			
			<address>
				<ul>
					<li><span>联系电话：<a href="">15950570536</a></span></li>
					<li><span>地址：<a href="">南京大学南园4舍</a></span></li>
					<li><span>邮箱：<a href="">ybbdaidai@126.com</a></span></li>
				</ul>
			</address>	

		</div>
	</footer>
	<script src="/Garleton/jquery.1.12.1-min.js"></script>
	<script src="/Garleton/bootstrap3.3.6/dist/js/bootstrap.min.js"></script>
	<script src="/Garleton/js/util/util.js" ></script>
	<script src="/Garleton/js/index.js"></script>
	<script src="/Garleton/js/pubuliu.js"></script>
</body>
</html>