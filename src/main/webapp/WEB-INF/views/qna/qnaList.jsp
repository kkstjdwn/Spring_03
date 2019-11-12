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
			<form class="form-horizontal pagination" action="qnaList" method="get" id="form_search">
			<input type="hidden" value="1" name="curPage" id="curPage">
			<div class="form-group">
			<select name="kind">
				<option value="kT" id="kT">Title</option> 
				<option value="kC" id="kC">Contents</option>
				<option value="kW"id="kW">Writer</option>
			</select>
				<label class="control-label col-sm-2" for="title">검색</label>
				<div class="col-sm-10">
					<input type="text" class="form-control form_search" id="search" name="search" value="${pager.search }">
				</div>
			</div></form>
			<ul class="pagination">
				<c:if test="${pager.curBlock gt 1 }">
<%-- 					<li><a href="qnaList?curPage=${pager.startNum-1 }&kind=${pager.kind}&search=${pager.search}">이전</a></li> --%>
					<li><span id="${pager.startNum-1 }" class = "list">이전</span></li>
				</c:if>
				<c:forEach begin="${pager.startNum }" end="${pager.lastNum}" var="i">
					<c:if test="${pager.curPage eq i }">
<%-- 					<li><a class="curPage">${i }</a></li> --%>
					<li><span id="${i }"  class="list curPage">${i }</span></li>
					</c:if>
					<c:if test="${pager.curPage != i }">
<%-- 					<li><a href="qnaList?curPage=${i }&kind=${pager.kind}&search=${pager.search}">${i }</a></li> --%>
					<li><span id="${i }"  class="list">${i }</span></li>
					</c:if>
				</c:forEach>
					<c:if test="${pager.curBlock lt pager.totalBlock }">				
<%-- 					<li><a href="qnaList?curPage=${pager.lastNum+1 }&kind=${pager.kind}&search=${pager.search}">다음</a></li> --%>
					<li><span id="${pager.lastNum+1 }" class = "list">다음</span></li>
					</c:if>
			</ul>
		<c:if test="${empty sessionScope.member}">
			<a href="" class="btn btn-info pagination" id="btn_right">글쓰기</a>
		</c:if>

		</div>
			
</c:if>
	</div>
<script type="text/javascript">
	var check = '${pager.kind}';
	if (check=="") {
		check = 'kT';
	}
	
	$(check).prop("selected","selected");
	
	$(".list").click(function() {
		$("#curPage").prop("value",$(this).attr("id"));
		$("#form_search").submit();
	});

</script>


</body>
</html>