<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title><a href="">Garleton Academy</a></title>
	<link rel="stylesheet" href="/Garleton/bootstrap3.3.6/dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="/Garleton/css/index.css">
	<link rel="stylesheet" href="/Garleton/css/admin.css">
	<link rel="stylesheet" href="/Garleton/css/myBreadcrumb.css"/>
	<link rel="stylesheet" href="/Garleton/css/search_icon.css"/>
	<link rel="stylesheet" href="/Garleton/css/pubuliu.css"/>
	

</head>
<body>
		
		
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
			      <img src="../img/scope2.jpg" alt="...">
			      <div class="carousel-caption">
			        <h2>红利息</h2>
			      </div>
			    </div>
			    <div class="item">
			      <img src="../img/scope4.jpg" alt="..." >
			      <div class="carousel-caption">
			        <h2>胡光延</h2>
			        <p>胡光延也不容易呀</p>
			      </div>
			    </div>
			    <div class="item">
			      <img src="../img/scope5.jpg" alt="..." >
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
				
				
				<li>
					<a class="manage" href="">栏目管理</a>
					<ul id="columnAction"> 
						<li><a href="" class="add">增加栏目</a></li>
						<li><a href="" class="query">查看栏目</a></li>
						
					</ul>
				</li>
				<li>
					<a class="manage" href="" >文章管理</a>
					<ul id="articleAction">
						<li><a href="" class="add">增加文章</a></li>
						<li><a href="" class="delete">删除文章</a></li>
						<li><a href="" class="query">查看文章</a></li>
						<li><a href="" class="update">修改文章</a></li>
						
					</ul>
				</li>
				

				
				<li>
					<a class="manage" href="">案例管理</a>
					<ul id="casesAction">
						<li><a href="" class="add">增加案例</a></li>
						<li><a href="" class="query">查看案例</a></li>
						<li><a href="" class="delete">删除案例</a></li>
					</ul>
				</li>
				
				<li>
					<a class="manage" href="" >资源管理</a>
					<ul id="ResourseAction">
						<li><a href="" class="add">添加资源</a></li>
						<li><a href="" class="query">查看资源</a></li>
						<li><a href="" class="delete">删除资源</a></li>
						
					</ul>
				</li>
				
				<li>
					<a class="manage" href="" >安全知识</a>
					<ul id="institutionAction">
						<li><a href="" class="query">增加安全知识</a></li>
						<li><a href="" class="add">删除安全知识</a></li>
						<li><a href="" class="delete">修改安全知识</a></li>
						<li><a href="" class="delete">查看安全知识</a></li>
					</ul>
				</li>
				
				<li>
					<a class="manage" href="" >安全法规</a>
					<ul id="institutionAction">
						<li><a href="" class="query">增加安全法规</a></li>
						<li><a href="" class="add">删除安全法规</a></li>
						<li><a href="" class="delete">修改安全法规</a></li>
						<li><a href="" class="delete">查看安全法规</a></li>
					</ul>
				</li>
				
				<li>
					<a class="manage" href="" >课程管理</a>
					<ul id="institutionAction">
						<li><a href="" class="query">增加课程</a></li>
						<li><a href="" class="add">删除课程</a></li>
						<li><a href="" class="delete">修改课程</a></li>
						<li><a href="" class="delete">查看课程</a></li>
					</ul>
				</li>
				
				<li>
					<a class="manage" href="" >试卷管理</a>
					<ul id="institutionAction">
						<li><a href="" class="query">增加试卷</a></li>
						<li><a href="" class="add">删除试卷</a></li>
						<li><a href="" class="delete">修改试卷</a></li>
						<li><a href="" class="delete">查看试卷</a></li>
					</ul>
				</li>
				
				<li>
					<a class="manage" href="" >试题管理</a>
					<ul id="institutionAction">
						<li><a href="" class="query">增加试题</a></li>
						<li><a href="" class="add">删除试题</a></li>
						<li><a href="" class="delete">修改试题</a></li>
						<li><a href="" class="delete">查看试题</a></li>
					</ul>
				</li>
				
				
				
				<li><a href="" id="log_out">Log Out</a></li>
	
			</ul>
		</nav>
	</header>
	<div id="wrapper">
		<article id="main_block">
			<header></header>
			<div id="content">
				
			</div>
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
	<script src="/Garleton/js/util/util.js"></script>
	<script src="/Garleton/js/member.js"></script>
	
	<script src="/Garleton/js/pubuliu.js"></script>
	
</body>
</html>