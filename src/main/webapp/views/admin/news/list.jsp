<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:url var="APIurl" value="/api-admin-new"/>
<c:url var="NewsURL" value="/admin-new"/>
<form class="container-fluid" action="/admin-new" id="formSubmit" method="GET">

		<div id="content-wrapper">

			<div class="container-fluid">

				<!-- Breadcrumbs-->
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="#">Dashboard</a></li>
					<li class="breadcrumb-item active">Tables</li>
				</ol>
				
				<a class="btn btn-link" data-toggle="tooltip" href="/admin-new?type=edit"
				flag="info" title="Thêm bài viết">Thêm</a>
				
				<button id="btnDelete" type="button" class="btn btn-link" 
				data-toggle="tooltip" title="Xóa bài viết">Xóa</button>
				
				<!-- DataTables Example -->

				<table class="table mt-4">
					<thead>
						<tr>
							<th><input type="checkbox" id="checkAll"></th>
							<th scope="col">Tên bài viết</th>
							<th scope="col">Mô tả ngắn</th>
							<th scope="col">Công cụ</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${model.listResult}">
							<tr>
								<td><input type="checkbox" id="checkAll_${item.id}" name="checkboxIds" value="${item.id}"></td>
								<td>${item.title}</td>
								<td>${item.shortDescription}</td>
								<td>
									<c:url var="editURL" value="/admin-new">
										<c:param name="type" value="edit"/>
										<c:param name="id" value="${item.id}"/>
									</c:url>
									<a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
									title="Cập nhập bài viết" href="${editURL}">Sửa</a>
								</td>
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
					<input type="hidden" value="" id="type" name="type"/>
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
						$('#type').val('list');
						$('#formSubmit').submit();
					}
				}
			});
		});
		
		$('#btnDelete').click(function() {
			var data = {};
			var ids = $('tbody input[type=checkbox]:checkbox').map(function(){
				return $(this).val();
			}).get();
			data['ids'] = ids;
			deleteNews(data);
		});
		
		function deleteNews(data) {
    		$.ajax({
    			url: '${APIurl}', 
    			type: 'DELETE',
    			contentType: 'application/json',
    			data: JSON.stringify(data),
    			success: function (result) {
					window.location.href='${NewsURL}?type=list&maxPageItem=2&page=1';
				},
				error: function (error) {
					console.log(error);
				}
    		});
		}
	</script>