<%@include file="/common/taglib.jsp"%>
<!-- Sidebar -->
<ul class="sidebar navbar-nav">
	<li class="nav-item active">
		<a class="nav-link" href="/admin-home">
			<i class="fas fa-fw fa-tachometer-alt"></i> 
			<span>Dashboard</span>
		</a>
	</li>
	<li class="nav-item dropdown">
		<a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" 
		role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> 
			<i class="fas fa-fw fa-folder"></i> 
			<span>Pages</span>
		</a>
		<div class="dropdown-menu" aria-labelledby="pagesDropdown">
			<h6 class="dropdown-header">Login Screens:</h6>
			<a class="dropdown-item" href="login.html">Login</a> 
			<a class="dropdown-item" href="register.html">Register</a> 
			<a class="dropdown-item" href="forgot-password.html">Forgot Password</a>
			<div class="dropdown-divider"></div>
			<h6 class="dropdown-header">Web Page:</h6>
			<a class="dropdown-item" href="/qlsv/web">Home Page</a>
			<div class="dropdown-divider"></div>
			<h6 class="dropdown-header">Other Pages:</h6>
			<a class="dropdown-item" href="404.html">404 Page</a> 
			<a class="dropdown-item" href="blank.html">Blank Page</a>
		</div>
	</li>
	<li class="nav-item">
		<a class="nav-link" href="charts.html"> 
			<i class="fas fa-fw fa-chart-area"></i> 
			<span>Charts</span>
		</a>
	</li>
	
	<c:url var="displayURL" value="/admin-new">
		<c:param name="page" value="1"/>
		<c:param name="maxPageItem" value="2"/>
		<c:param name="sortName" value="TITLE"/>
		<c:param name="sortBy" value="DESC"/>
		<c:param name="type" value="list"/>
	</c:url>
			
	<li class="nav-item">
		<!-- <a class="nav-link" href="/admin-new?page=1&maxPageItem=2&sortName=TITLE&sortBy=DESC&type=list">
			<i class="fas fa-fw fa-table"></i> 
			<span>Tables</span>
		</a> -->
		<a class="nav-link" href="${displayURL}">
			<i class="fas fa-fw fa-table"></i> 
			<span>Tables</span>
		</a>
	</li>
</ul>