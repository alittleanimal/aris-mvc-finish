<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<html>
<div class="row">

  <div class="header">
    <ul class="breadcrumb">
      <li>TOP<span class="divider">&gt;</span></li>
      <li>STOCK<span class="divider">&gt;</span></li>
      <li>UPDATE<span class="divider">&gt;</span></li>
      <li>UPDATE CONFIRM</li>
    </ul>
  </div>

  <div class="row">

    <div class="span2"></div>
    
    <div class="span8">
      <div class="text-center">
        <h4>please, check update information...</h4>
      </div>
      
      <spring:url var="stockUpdateUrl" value="/stock/update" />
      <form:form id="stockUpdateForm" class="text-center" action="${stockUpdateUrl}" method="post" modelAttribute ="stockUpdateForm">
        <table class="table table-condensed update-confirm">
          <tr>
            <td><label for="dvdEanCode" class="text-right">DVD EAN CODE　:　</label></td>
            <td>${stockUpdateForm.dvdEanCode}</td>
          </tr>
          <tr>
            <td><label class="text-right" for="dvdTitle">DVD TITLE　:　</label></td>
            <td>${stockUpdateForm.dvdTitle}</td>
          </tr>
          <tr>
            <td><label class="text-right" for="warehouseId">WAREHOUSE ID　:　</label></td>
            <td>${stockUpdateForm.warehouseId}</td>
          </tr>
          <tr>
            <td><label class="text-right" for="warehouseName">WAREHOUSE NAME　:　</label></td>
            <td>${stockUpdateForm.warehouseName}</td>
          </tr>
          <tr>
            <td><label for="warehouseAddress" class="text-right">WAREHOUSE ADDRESS　:　</label></td>
            <td>${stockUpdateForm.warehouseAddress}</td>
          </tr>
          <tr>
            <td><label for="warehouseTel" class="text-right">WAREHOUSE TEL　:　</label></td>
            <td>${stockUpdateForm.warehouseTel}</td>
          </tr>
          <tr>
            <td><label for="quantity" class="text-right">QUANTITY　:　</label></td>
            <td>${stockUpdateForm.quantity}</td>
          </tr>
        </table>
        <spring:url var="returnUrl" value="/stock/updateReInput" />
        <a href="${returnUrl}" class="btn"><i class="icon-arrow-left icon"></i>&nbsp; Return</a>
        <button type="submit" class="btn btn-danger" name="update"><i class="icon-ok-sign icon-white icon"></i>&nbsp; Update</button>
      </form:form>
    
    </div>
    
    <div class="span2"></div>
  </div>  
</div>
</html>