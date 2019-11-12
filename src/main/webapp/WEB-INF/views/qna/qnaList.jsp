<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QnA List</title>
<c:import url="../layout/css.jsp"/>
</head>
<body>
<c:import url="../layout/nav.jsp"/>
<c:import url="../layout/bootStrap.jsp"/>
<div class="container">
<c:if test="${pager.curPage le pager.totalPage }">
		<h2>QnA LIST</h2>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>NO</th>
					<th>TITLE</th>
					<th>WRITER</th>
					<th>DATE</th>
					<th>HIT</th>
					<th>REF</th>
					<th>STEP</th>
					<th>DEPTH</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="dto">
					<tr>
						<th>${dto.num}</th>
						<th><a href="">${dto.title}</a></th>
						<th>${dto.writer}</th>
						<th>${dto.reg_date}</th>
						<th>${dto.hit}</th>
						<th>${dto.ref}</th>
						<th>${dto.step}</th>
						<th>${dto.depth}</th>

					</tr>
				</c:forEach>
			</tbody>

		</table>
		<!--**********************버튼그룹 -->
		<!-- session member, memberDTO -->

		<div class="page_div">
			<ul class="pagination">
				<c:if test="${pager.curBlock gt 1 }">
					<li><a href="qnaList?curPage=${pager.startNum-1 }">이전</a></li>
				</c:if>
				<c:forEach begin="${pager.startNum }" end="${pager.lastNum}" var="i">
					<c:if test="${pager.curPage eq i }">
					<li><a id="curPage">${i }</a></li>
					</c:if>
					<c:if test="${pager.curPage != i }">
					<li><a href="qnaList?curPage=${i }">${i }</a></li>
					</c:if>
				</c:forEach>
					<c:if test="${pager.curBlock lt pager.totalBlock }">				
					<li><a href="qnaList?curPage=${pager.lastNum+1 }">다음</a></li>
					</c:if>
			</ul>

		</div>

		<c:if test="${empty sessionScope.member}">
			<a href="" class="btn btn-info" id="btn_right">글쓰기</a>
		</c:if>
</c:if>
	</div>



</body>
</html>