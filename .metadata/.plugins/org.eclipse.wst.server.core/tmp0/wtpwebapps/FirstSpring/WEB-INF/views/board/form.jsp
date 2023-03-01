<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>일반게시판 등록/수정</title>

<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/plugins/fontawesome-free/css/all.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/dist/css/adminlte.min.css">
</head>
<body class="hold-transition sidebar-mini">
	<c:set value="등록" var="name"/>
	<c:if test="${status eq 'u' }">
		<c:set var="name" value="수정"/>
	</c:if>
	<div class="wrapper">
		<nav
			class="main-header navbar navbar-expand navbar-white navbar-light">
			<ul class="navbar-nav">
				<li class="nav-item">
					<a class="nav-link" data-widget="pushmenu" href="#" role="button"> 
						<i class="fas fa-bars"></i>
					</a>
				</li>
			</ul>

			<ul class="navbar-nav ml-auto">
				<li class="nav-item">
					<a class="nav-link" data-widget="navbar-search" href="#" role="button"> 
						<i class="fas fa-search"></i>
					</a>
					<div class="navbar-search-block">
						<form class="form-inline">
							<div class="input-group input-group-sm">
								<input class="form-control form-control-navbar" type="search" placeholder="Search" aria-label="Search">
								<div class="input-group-append">
									<button class="btn btn-navbar" type="submit">
										<i class="fas fa-search"></i>
									</button>
									<button class="btn btn-navbar" type="button" data-widget="navbar-search">
										<i class="fas fa-times"></i>
									</button>
								</div>
							</div>
						</form>
					</div></li>
				<li class="nav-item">
					<a class="nav-link" data-widget="fullscreen" href="#" role="button"> 
						<i class="fas fa-expand-arrows-alt"></i>
					</a>
				</li>
			</ul>
		</nav>

		<aside class="main-sidebar sidebar-dark-primary elevation-4">
			<a href="#" class="brand-link"> 
				<img src="${pageContext.request.contextPath}/resources/dist/img/AdminLTELogo.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3" style="opacity: .8">
				<span class="brand-text font-weight-light">DDIT BOARD</span>
			</a>

			<div class="sidebar">
				<div class="user-panel mt-3 pb-3 mb-3 d-flex">
					<div class="image">
						<img src="${pageContext.request.contextPath}/resources/dist/img/user2-160x160.jpg" class="img-circle elevation-2" alt="User Image">
					</div>
					<div class="info">
						<a href="#" class="d-block">홍길동</a>
					</div>
				</div>

				<nav class="mt-2">
					<ul class="nav nav-pills nav-sidebar flex-column"
						data-widget="treeview" role="menu" data-accordion="false">
						<li class="nav-header">MAIN MENU</li>
						<li class="nav-item"><a href="#" class="nav-link"> <i
								class="nav-icon fas fa-tachometer-alt"></i>
								<p>
									일반게시판 <i class="right fas fa-angle-left"></i>
								</p>
						</a></li>
					</ul>
				</nav>
			</div>
		</aside>

		<div class="content-wrapper">
			<section class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h1>일반게시판 ${name }</h1>
						</div>
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="#">DDIT HOME</a></li>
								<li class="breadcrumb-item active">일반게시판 ${name }</li>
							</ol>
						</div>
					</div>
				</div>
			</section>

			<section class="content">
				<div class="row">
					<div class="col-md-12">
						<form class="card card-primary" method="post" action="/board/insert.do" id="boardForm">
							<c:if test="${status eq 'u' }">
								<input type="hidden" name="boNo" value="${board.boNo }">
							</c:if>
							<div class="card-header">
								<h3 class="card-title">일반게시판 ${name }</h3>
								<div class="card-tools"></div>
							</div>
							<div class="card-body">
								<div class="form-group">
									<label for="inputName">제목을 입력해주세요</label> 
									<input type="text" id="boTitle" class="form-control" name="boTitle" value="${board.boTitle }" placeholder="제목을 입력해주세요">
								</div>
								<div class="form-group">
									<label for="inputDescription">내용을 입력해주세요</label>
									<textarea id="boContent" class="form-control" rows="14" name="boContent">${board.boContent }</textarea>
								</div>
								<div class="row">
									<div class="col-12">
										<input type="button" value="${name }" id="formBtn" class="btn btn-primary float-right">
										<c:if test="${status eq 'u' }">
											<a href="/board/detail.do?bono=${board.boNo }">
												<input type="button" value="취소" class="btn btn-danger float-right">
											</a>
										</c:if>
										<c:if test="${status ne 'u' }">
											<a href="/board/list.do">
												<input type="button" value="목록" class="btn btn-success float-right">
											</a>
										</c:if>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
			</section>
		</div>

		<footer class="main-footer">
			<div class="float-right d-none d-sm-block">
				<b>DDIT Spring1</b> 1.0.0
			</div>
			<strong>Copyright &copy; 2023 DDIT SPRING.</strong> All rights reserved.
		</footer>

		<aside class="control-sidebar control-sidebar-dark">
		</aside>
	</div>

	<script src="${pageContext.request.contextPath}/resources/plugins/jquery/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/dist/js/adminlte.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/ckeditor/ckeditor.js"></script>
</body>
<script type="text/javascript">
$(function(){
	CKEDITOR.replace("boContent");
	CKEDITOR.config.allowedContent = true;	// html태그가 사라지는걸 방지
	
	var formBtn = $("#formBtn");
	
	formBtn.on("click", function(){
		var title = $("#boTitle").val();
		// 일반적으로 textarea에서 내용을 가져올 때 사용
// 		var content = $("#boContent").val();
		
		// ckeditor를 이용하여 내용을 가져올 때 사용
		var content = CKEDITOR.instances.boContent.getData();
		
		if(title == ""){
			alert("제목을 입력해주세요.");
			$("#boTitle").focus();
			return false;
		}
		if(content == ""){
			alert("내용을 입력해주세요.");
			$("#boContent").focus();
			return false;
		}
		
		if($(this).val() == "수정"){
			$("#boardForm").attr("action", "/board/update.do")
		}
		
		$("#boardForm").submit();	
	});
});
</script>

</html>
