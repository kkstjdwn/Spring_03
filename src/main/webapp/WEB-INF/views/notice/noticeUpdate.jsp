<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../layout/css.jsp"  />
</head>
<body>
<c:import url="../layout/nav.jsp"  />
<c:import url="../layout/bootStrap.jsp"/>
	<div class="container">
		<h2>UPDATE</h2>
		<form class="form-horizontal" action="noticeUpdate" method="post">
			<div class="form-group">
				<label class="control-label col-sm-2" for="title">TITLE</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="title" name="title"
						value="${vo.title }">
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="hit" id="hit_lb">HIT</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="hit" name="hit"
						readonly="readonly" value="${vo.hit }">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="writer">WRITER</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="writer" name="writer"
						readonly="readonly" value="${vo.writer}">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="contents">CONTENTS</label>
				<div class="col-sm-10">
					<textarea class="form-control" id="contents" name="contents">${vo.contents }</textarea>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="num">NUM</label>
				<div class="col-sm-10">
				<input type="text" class="form-control" id="num" name="num"
						readonly="readonly" value="${vo.num }">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="reg_date">DATE</label>
				<div class="col-sm-10">
				<input type="text" class="form-control" id="reg_date" name="reg_date"
						readonly="readonly" value="${vo.reg_date }">
				</div>
			</div>
		<!--**********************버튼그룹 -->
		<button type="submit" class="btn btn-warning" id="btn_right">수정</button>
		</form>


		
		

	</div>

</body>
</html>