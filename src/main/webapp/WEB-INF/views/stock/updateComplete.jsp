<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>


<html>
<div class="row">
  <div class="span12" style="background-color: white;">
    
    <!-- breadcrumb -->
    <div class="header">
      <ul class="breadcrumb">
        <li>TOP<span class="divider">&gt;</span></li>
        <li>STOCK<span class="divider">&gt;</span></li>
        <li>UPDATE<span class="divider">&gt;</span></li>
        <li>UPDATE COMPLETE</li>      </ul>
    </div>
    
    <!-- message -->
    <c:if test="${not empty message}">
			<div class="alert alert-error">
				<a class="close" data-dismiss="alert">x</a> <span
					class="inline-help"><c:out value="${message}"></c:out></span>
			</div>
		</c:if>
    <!-- contents -->
    <div class="row">

      <!-- left space -->
      <div class="span2">
      </div>
      
      <!-- center space -->
      <div class="span8">
        <div class="text-center">
          <h4>stock information was successfully updated.</h4>
        </div>
        <spring:url var="stockUpdateUrl" value="/stock/search" />
        <form:form id="stockUpdateForm" class="text-center" action="${stockUpdateUrl}" method="post" modelAttribute ="stockUpdateForm">
        <table class="table table-condensed detail">
          <thead>
          </thead>
          <tbody>
          	<c:set var = "stock" value = "${stock}"/>
            <tr>
              <td><label for="dvdEanCode" class="pull-right">DVD EAN CODE  :  </label></td>
              <td>${stockUpdateForm.dvdEanCode}</td>
            </tr>
            <tr>
              <td><label class="pull-right" for="dvdTitle">DVD TITLE  :  </label></td>
              <td>${stockUpdateForm.dvdTitle}</td>
            </tr>
            <tr>
              <td><label for="warehouseId" class="pull-right">WAREHOUSE ID  :  </label></td>
              <td>${stockUpdateForm.warehouseId}</td>
            </tr>
            <tr>
              <td><label class="pull-right" for="warehouseName">WAREHOUSE NAME  :  </label></td>
              <td>${stockUpdateForm.warehouseName}</td>
            </tr>
            <tr>
              <td><label for="warehouseAddress" class="pull-right">WAREHOUSE ADDRESS  :  </label></td>
              <td>${stockUpdateForm.warehouseAddress}</td>
            </tr>
            <tr>
              <td><label for="warehouseTel" class="pull-right">WAREHOUSE TEL  :  </label></td>
              <td>${stockUpdateForm.warehouseTel}</td>
            </tr>
            <tr>
              <td><label for="quantity" class="pull-right">QUANTITY  :  </label></td>
              <td>${stockUpdateForm.quantity}</td>
            </tr>
            <tr>
              <td colspan="2">
                <div class="text-center">
                <!-- <a href="aris/stock/search" class="btn"><i class="icon icon-eye-open"></i>&nbsp; Go Search</a> -->
                <button type="submit" class="btn" name="goSearch"><i class="icon icon-eye-open"></i>&nbsp; Go Search</button>
                </div>
              </td>
            </tr>
          </tbody>  
        </table>
        </form:form>
        <br>
      </div>

      <!-- right space -->
      <div class="span2">
      </div>

    </div>
  </div>
</div>
</html>