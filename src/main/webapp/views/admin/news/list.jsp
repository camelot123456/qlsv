<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách bài viết</title>
</head>
<body>
	<form action="/admin-new" id="formSubmit" method="GET">

		<div id="content-wrapper">

			<div class="container-fluid">

				<!-- Breadcrumbs-->
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="#">Dashboard</a></li>
					<li class="breadcrumb-item active">Tables</li>
				</ol>

				<!-- DataTables Example -->

				<table class="table">
					<thead>
						<tr>
							<th scope="col">Tên bài viết</th>
							<th scope="col">Mô tả ngắn</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${model.listResult}">
							<tr>
								<td>${item.title}</td>
								<td>${item.shortDescription}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<nav aria-label="Page navigation">
					<ul class="pagination" id="pagination"></ul>
					<input type="hidden" value="" id="page" name="page"/>
					<input type="hidden" value="" id="maxPageItem" name="maxPageItem"/>
					<input type="hidden" value="" id="sortName" name="sortName"/>
					<input type="hidden" value="" id="sortBy" name="sortBy"/>
				</nav>
			</div>
		</div>
	</form>
	<!-- /.container-fluid -->
	<script type="text/javascript">
		var totalPages = ${model.totalPage};
		var currentPage = ${model.page};
		var limit = 2;
	
		$(function() {
			window.pagObj = $('#pagination').twbsPagination({
				totalPages : totalPages,
				visiblePages : limit,
				startPage : currentPage,
				onPageClick : function(event, page) {
					if(currentPage != page){
						$('#maxPageItem').val(limit);
						$('#page').val(page);
						$('#sortName').val('TITLE');
						$('#sortBy').val('DESC');
						$('#formSubmit').submit();
					}
				}
			});
		});
	</script>
</body>
</html>