<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Notice Main</title>
<meta charset="utf-8">
<c:import url="../layout/css.jsp" />
</head>
</head>
<body>
	<c:import url="../layout/nav.jsp" />
	<c:import url="../layout/bootStrap.jsp" />
	<div class="container">
		<h2>NOTICE LIST</h2>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>NO</th>
					<th>TITLE</th>
					<th>WRITER</th>
					<th>DATE</th>
					<th>HIT</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="dto">
					<tr>
						<th>${dto.num}</th>
						<th><a href="noticeSelect?num=${dto.num}">${dto.title}</a></th>
						<th>${dto.writer}</th>
						<th>${dto.reg_date}</th>
						<th>${dto.hit}</th>

					</tr>
				</c:forEach>
			</tbody>

		</table>
		<!--**********************버튼그룹 -->
		<!-- session member, memberDTO -->

		<div class="page_div">
			<ul class="pagination">
				<c:if test="${pager.curBlock gt 1}">
					<li><a href="noticeList?curPage=${pager.startNum-1 }">이전</a></li>
				</c:if>
				<c:forEach begin="${pager.startNum }" end="${pager.lastNum}" var="i">

					<li><a href="noticeList?curPage=${i }">${i }</a></li>

				</c:forEach>
				<c:if test="${pager.curBlock lt pager.totalBlock }">
					<li><a href="noticeList?curPage=${pager.lastNum+1 }">다음</a></li>
				</c:if>
			</ul>

		</div>

		<c:if test="${empty sessionScope.member}">
			<a href="noticeWrite" class="btn btn-info" id="btn_right">글쓰기</a>
		</c:if>

	</div>

</body>
</html>