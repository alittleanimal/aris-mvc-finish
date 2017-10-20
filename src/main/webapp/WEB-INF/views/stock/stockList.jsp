<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<html>
<script type="text/javascript">
	jQuery(function($) {
		$('tr[data-href]').addClass('clickable').click(function(e) {
			if (!$(e.target).is('a')) {
				window.location = $(e.target).closest('tr').data('href');
			}
		});

		$('#jumpToPage').click(function() {
			var url = $(this).attr("href") + '/' + $('#targetPage').val();
			$(this).attr("href", url);
		});
	});
</script>

<div class="row">

	<div class="span12" style="background-color: white;">

		<!-- breadcrumb -->
		<div class="header">
			<ul class="breadcrumb">
				<li>TOP<span class="divider">&gt;</span></li>
				<li>STOCK<span class="divider">&gt;</span></li>
				<li>SEARCH</li>
			</ul>
		</div>

		<!-- message -->
		<!-- message -->
		<c:if test="${not empty message}">
			<div class="alert alert-error">
				<a class="close" data-dismiss="alert">x</a> <span
					class="inline-help"><c:out value="${message}"></c:out></span>
			</div>
		</c:if>

		<!-- search condition box -->
		<div class="row">
			<div class="span12">
				<spring:url var="searchUrl" value="/stock/search" />
				<form:form action="${searchUrl}" name="search" method="post"
					cssClass="text-center" modelAttribute="stockSearchForm">
					<table class="table table-condensed">
						<thead>
							<tr>
								<th colspan="2">
									<div class="text-left">CONDITIONS</div>
								</th>
							</tr>
						</thead>
						<tbody>
							<tr>

								<!-- error message handle -->
								<c:set var="dvdEanCodeErrors">
									<form:errors path="dvdEanCode" cssClass="text-error" />
								</c:set>
								<c:if test="${not empty dvdEanCodeErrors}">
									<c:set var="dvdEanCodeErrorCheck" value="error" />
								</c:if>
								<td class="${dvdEanCodeErrorCheck}"><label for="dvdEanCode">DVD
										EAN CODE : </label> ${dvdEanCodeErrors}</td>
								<td><form:input class="input-small span3" path="dvdEanCode" /></td>
								<td><label for="dvdTitle">DVD TITLE : </label></td>
								<td><form:input class="input-small span3" path="dvdTitle" /></td>
							</tr>

							<tr>
								<!-- error message handle -->
								<c:set var="warehouseIdErrors">
									<form:errors path="warehouseId" cssClass="text-error" />
								</c:set>
								<c:if test="${not empty warehouseIdErrors}">
									<c:set var="warehouseIdErrorCheck" value="error" />
								</c:if>
								<td class="${warehouseIdErrorCheck}"><label
									for="warehouseId">WAREHOUSE ID : </label> ${warehouseIdErrors}
								</td>
								<td><form:input class="input-small span3"
										path="warehouseId" /></td>
								<td><label for="warehouseName">WAREHOUSE NAME : </label></td>
								<td><form:input class="input-small span3"
										path="warehouseName" /></td>
							</tr>

							<tr>
								<td colspan="12">
									<div class="text-center">
										<button type="submit" class="btn">
											<i class="icon icon-eye-open"></i>&nbsp; SEARCH
										</button>
									</div>
								</td>
							</tr>

						</tbody>
					</table>
				</form:form>
				<hr>
			</div>
		</div>

		<!-- search row -->
		<div class="row">
			<!-- search result -->
			<div class="span12">
				<c:if test="${not empty stocks}">
					<h5>SEARCH RESULT</h5>
					<table
						class="table table-hover table-condensed table-striped table-bordered list">
						<thead>
							<tr class="parts-title">
								<th>DVD EAN CODE</th>
								<th>DVD TITLE</th>
								<th>WAREHOUSE ID</th>
								<th>WAREHOUSE NAME</th>
								<th>QUANTITY</th>
								<th><i class="icon-search icon"></i>:VIEW &nbsp; <i
									class="icon-edit icon"></i>:EDIT</th>
							</tr>
						</thead>

						<tbody>
							<c:forEach var="stock" items="${stocks}">
								<spring:url var="stockRefUrl" value="/stock/detail/${stock.id}" />
								<tr data-href="${stockRefUrl}">
									<td><c:out value="${stock.dvdEanCode}"></c:out></td>
									<td><c:out value="${stock.dvdTitle}"></c:out></td>
									<td><c:out value="${stock.warehouseId}"></c:out></td>
									<td><c:out value="${stock.warehouseName}"></c:out></td>
									<td><c:out value="${stock.quantity}"></c:out></td>
									<spring:url var="viewUrl" value="/stock/detail/${stock.id}" />
									<spring:url var="editUrl"
										value="/stock/updateInput/${stock.id}" />
									<td><a href="${viewUrl}" class="btn"> <i
											class="icon-search icon"></i>
									</a> <a href="${editUrl}" class="btn"><i class="icon-edit icon"></i></a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

					<!--  pagination -->
					<div class="control-group ">
					<c:if test="${not empty pages}">
            <div class="pagination pagination-centered">
              <ul>
                <spring:url var="searchPageUrl" value="/stock/search" />

 				<c:forEach var="page" items="${pages}">
            	<li class="${page.cssClass}">
					<a href="${searchPageUrl}/${page.index}">${page.content}</a>
				</li>
          		</c:forEach>

                <li>
 　  					<form:form action="${searchPageUrl}" cssClass="form-inline" method="post">
    				Page:
      				<input id="targetPage" name="targetPage" class="input-mini" type="text" value="${curPage}"/> / <c:out value="${pageCnt}"/>
      				<a id="jumpToPage" href="${searchPageUrl}" class="btn">
					<i class="icon icon-eye-open"></i>&nbsp; JUMP
      				</a>
    				</form:form>
 				 </li>
              </ul>
            </div>
            </c:if>
          </div>
				</c:if>
			</div>
		</div>
	</div>
</div>

	<script type="text/javascript" charset="utf-8"
		src="../../../resources/js/bootstrap.min.js" /></script>
</html>