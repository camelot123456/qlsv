<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container mt-4">
		<c:if test="${not empty message}">
			<div class="alert alert-${alert}">
			  ${message}
			</div>
		</c:if>
		<form action="/dang-nhap" id="form-login" method="POST">
		  <div class="form-group">
		    <label for="username">Tên đăng nhập</label>
		    <input name="username" type="text" class="form-control" id="username" aria-describedby="emailHelp" placeholder="Enter email">
		  </div>
		  <div class="form-group">
		    <label for="password">Mật khẩu</label>
		    <input name="password" type="password" class="form-control" id="password" placeholder="Password">
		  </div>
		  <div class="form-check">
		    <input type="checkbox" class="form-check-input" id="exampleCheck1">
		    <label class="form-check-label" for="exampleCheck1">Lưu mật khẩu</label>
		  </div>
		  <input type="hidden" value="login" id="action" name="action">
		  <button type="submit" class="btn btn-primary mt-4">Đăng nhập</button>
		</form>
	
	</div>
</body>
</html>