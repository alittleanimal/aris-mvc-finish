<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<spring:url var="ajax" value="/user/jsonDetail/" />
<script type="text/javascript">
  $(document).ready(function() {
    $(".autocomplete").autocomplete({
      source: '${pageContext.request.contextPath}/user/ajax'
    });
    
    $('#dialog').dialog({
      modal: true,
      autoOpen: false,
      width: 370,
      height: 200,
      title: 'File Upload Dialog',
      closeOnEscape: false,
    });
    
    $('#upload').click(function() {
      $('#dialog').dialog("open");
    })
    
   $("#ajaxButton").click(function(){
	 var id = $('#ajaxButton').attr("data");
        $.ajax({
        	type: 'GET',
            url: '${ajax}'+id,
            dataType: "json",
            success: function(result){
              alert(result.email);
              $("#email_val").html(result.email);
              $("#email_val").val(result.email);
              
              $("#dialog2").show();
            }
        });
 	});
    
  });

  jQuery(function($) {
    $('tr[data-href]').addClass('clickable').click(function(e) {
      if(!$(e.target).is('a')){
        window.location = $(e.target).closest('tr').data('href');
      }
    });
  });  
  
</script>

<div class="row">

  <div class="span12"">

    <!-- breadcrumb -->
    <div class="header">
      <ul class="breadcrumb">
        <li>Top<span class="divider">&gt;</span></li>
        <li>User Management<span class="divider">&gt;</span></li>
        <li>List</li>
      </ul>
    </div>

    <!-- message -->
    <c:if test="${not empty message}">
      <div class="alert alert-error">
        <a class="close" data-dismiss="alert">x</a>
        <span class="inline-help"><c:out value="${message}"></c:out></span>
      </div>
    </c:if>

    <!-- search row -->
    <div class="row">
      <div class="span3">
        <spring:url var="searchUrl" value="/user/search" />
        <form:form action="${searchUrl}" name="search" method="post" cssClass="text-center" modelAttribute="userSearchForm" >
          <table class="table table-condensed">
            <thead>
              <tr>
                <th colspan="2">
                  <div class="text-center">CONDITIONS</div>
                </th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td><label for="id" >id : </label></td>
                <td><form:input class="input-small autocomplete" path="id" /></td>
              </tr>
              <tr>
                <td><label for="name" >name : </label></td>
                <td><form:input class="input-small" path="name"  /></td>
              </tr>
              <tr>
                <td><label for="roleId" >roleId : </label></td>
                <td><form:input class="input-small" path="roleId"  /></td>
              </tr>
              <tr>
                <td><label for="email" >email : </label></td>
                <td><form:input  class="input-small" path="email"/></td>
              </tr>
              <tr>
                <td colspan="2">
                  <div class="text-center">
                    <button type="submit" class="btn"><i class="icon icon-eye-open"></i>&nbsp; SEARCH</button>
                  </div>
                </td>
              </tr>
            </tbody>
          </table>
        </form:form>
        <br>
      </div>

      <!-- search result -->
      <div class="span9">
        <div class="pull-right">
          <spring:url var="uploadUrl" value="/user/upload" />
          <a id="upload" class="btn"><i class="icon icon-upload"></i>&nbsp; UPLOAD</a> &nbsp;
          <c:if test="${not empty users}">
            <spring:url var="downloadUrl" value="/user/download" />
            <a href="${downloadUrl}" class="btn"><i class="icon icon-circle-arrow-down"></i>&nbsp; DOWNLOAD</a> &nbsp;
            <spring:url var="mailUrl" value="/user/mail" />
            <a href="${mailUrl}" class="btn"><i class="icon icon-share"></i>&nbsp; MAIL</a> &nbsp;
          </c:if>
          <spring:url var="registerInputUrl" value="/user/registerInput" />
          <a href="${registerInputUrl}" class="btn"><i class="icon icon-pencil"></i>&nbsp; ADD USER</a>
          <br>
          <br>
        </div>
        <c:if test="${not empty users}">
          <h4>Search Result</h4>
          <table class="table table-hover table-condensed table-striped table-bordered list">
            <thead>
              <tr class="parts-title">
                <th>id</th>
                <th>name</th>
                <th>role_id</th>
                <th>email</th>
                <th>actions</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach var="user" items="${users}">
                <spring:url var="userRefUrl" value="/user/detail/${user.id}" />
                <tr>
                  <td><c:out value="${user.id}"></c:out></td>
                  <td><c:out value="${user.name}"></c:out></td>
                  <td><c:out value="${user.roleId}"></c:out></td>
                  <td><c:out value="${user.email}"></c:out></td>
                  <spring:url var="viewUrl" value="/user/detail/${user.id}"/>
                  <spring:url var="editUrl" value="/user/updateInput/${user.id}"/>
                  <spring:url var="deleteUrl" value="/user/deleteConfirm/${user.id}"/>
                  
                  <td>
                    <a href="${viewUrl}" class="btn" title="view item"><i class="icon-search icon"></i></a>
                    <a href="${editUrl}" class="btn" title="edit item"><i class="icon-edit icon"></i></a>
                    <a href="${deleteUrl}" class="btn" title="delete item"><i class="icon-trash icon"></i></a>
                    <a href="javascript:void(0);" class="btn" title="Ajax" id = "ajaxButton" data="${user.id}"></a>
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
                <spring:url var="searchPageUrl" value="/user/search" />
                <c:forEach var="page" items="${pages}">
                  <li class="${page.cssClass}"><a href="${searchPageUrl}/${page.index}">${page.content}</a></li>
                </c:forEach>
              </ul>
            </div>
          </c:if>
        </div>
        </c:if>
      </div>
    </div>
  </div>
  
   <!-- add center space -->
      <div class="span8" id = "dialog2" style = "display:none">
        <div class="text-center">
          <h4>User Detail</h4>
        </div>
        <table class="table table-condensed detail">
          <thead>
          </thead>
          <tbody>
            <tr>
              <td><label for="id" class="pull-right">id　:　</label></td>
              <td><c:out value="${userDetailForm.id}" /></td>
            </tr>
            <tr>
              <td><label class="pull-right" for="name">name　:　</label></td>
              <td><c:out value="${userDetailForm.name}" /></td>
            </tr>
            <tr>
              <td><label for="roleId" class="pull-right">role　:　</label></td>
              <td><c:out value="${userDetailForm.roleId}" /></td>
            </tr>
            <tr>
              <td><label class="pull-right" for="email">email　:　</label></td>
              <td id="email_val"></td>
            </tr>
            <tr>
              <td><label for="sex" class="pull-right">sex　:　</label></td>
              <td><c:out value="${userDetailForm.sex}" /></td>
            </tr>
            <tr>
              <td><label for="nationality" class="pull-right">nationality　:　</label></td>
              <td><c:out value="${userDetailForm.nationality}" /></td>
            </tr>
            <tr>
              <td><label for="text" class="pull-right">text　:　</label></td>
              <td><c:out value="${userDetailForm.text}" /></td>
            </tr>
            <tr>
              <spring:url value="/user/updateInput/${userDetailForm.id}" var="updateUrl"/>
              <spring:url value="/user/deleteConfirm/${userDetailForm.id}" var="detailUrl"/>
              <td colspan="2">
                <div class="text-center">
                <a href="${updateUrl}" class="btn"><i class="icon-edit" style="margin-top: 1px;"></i>&nbsp; Update</a>
                <a href="${detailUrl}" class="btn"><i class="icon-trash" style="margin-top: 1px;"></i>&nbsp; Delete</a>
                </div>
              </td>
            </tr>
          </tbody>  
        </table>
        <br>
      </div>
  
</div>
<div id="dialog">
  <form:form name="userUploadForm" action="${uploadUrl}" method="post" cssClass="form-horizontal" enctype="multipart/form-data" modelAttribute="userUploadForm">
    <form:input path="name"  cssClass="input-large" placeholder="ファイル名を入力してください。"/>
    <form:input path="uploadFile" id="uploadFile" name="uploadFile" type="file" class="input-large"/>
    <button type="submit" class="btn pull-right"><i class="icon icon-upload"></i>&nbsp; UPLOAD</button>    
  </form:form>
</div>