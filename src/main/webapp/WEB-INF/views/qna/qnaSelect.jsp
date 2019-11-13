<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>S-O</title>
<c:import url="../layout/css.jsp" />
</head>
<body>
	<c:import url="../layout/nav.jsp" />
	<c:import url="../layout/bootStrap.jsp" />
	<div class="container">
		<form class="form-horizontal" action="/action_page.php">
			<div class="form-group">
				<label class="control-label col-sm-2" for="title">TITLE</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="title" name="title"
						readonly="readonly" value="${vo.title }">
				</div>
			</div>


			<!--***********************히든그룹 -->
			<input type="hidden" class="form-control" id="hit" name="hit" readonly="readonly" value="${vo.hit }">
			<input type="hidden" class="form-control" id="ref" name="ref" readonly="readonly" value="${vo.ref }">
			<input type="hidden"class="form-control" id="step" name="step" readonly="readonly" value="${vo.step }"> 
			<input type="hidden" class="form-control" id="depth" name="depth" readonly="readonly" value="${vo.depth }">
			
			<!--***********************히든그룹 -->


			<div class="form-group">
				<label class="control-label col-sm-2" for="writer">WRITER</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="writer" name="writer"
						readonly="readonly" value="${vo.writer }">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="contents">CONTENTS</label>
				<div class="col-sm-10">
					<textarea class="form-control" id="contents" name="contents"
						readonly="readonly">${vo.contents }</textarea>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="reg_date">DATE</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="reg_date"
						name="reg_date" readonly="readonly" value="${vo.reg_date }">
				</div>
			</div>
		</form>

		<!--**********************버튼그룹 -->

		<div id="bt_gp">
			<a href="qnaReply?num=${vo.num }" class="btn btn-success" id="btn_right">답변</a>
			<a href="qnaList" class="btn btn-primary btn_gp">목록</a> 
			<a href="qnaUpdate?num=${vo.num }" class="btn btn-warning">수정</a>
			<a href="qnaDelete?num=${vo.num }" class="btn btn-danger">삭제</a>

		</div>
	</div>
</body>
</html>