<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<html>
 <div class="row">
  <div class="span12">
    
    <!-- breadcrumb -->
    <div class="header">
      <ul class="breadcrumb">
        <li>TOP<span class="divider">&gt;</span></li>
        <li>STOCK<span class="divider">&gt;</span></li>
        <li>UPDATE<span class="divider">&gt;</span></li>
        <li>UPDATE INPUT</li>
      </ul>
    </div>
    
    <!-- top message -->
    <c:if test="${not empty message}">
          <div class="alert alert-error">
            <a class="close" data-dismiss="alert">x</a> <span
              class="inline-help"><c:out value="${message}"></c:out></span>
          </div>
         </c:if>
    <!-- content -->
    <div class="row">
    
      <!-- right space -->
      <div class="span2"></div>
      
      <!-- main content -->
      <div class="span8">
        
        <!-- UPDATE FORM -->
        <div class="text-center"><h4>STOCK UPDATE</h4></div>
        <spring:url var="updateConfirm" value="/stock/updateConfirm" />
        <form:form id="stockUpdateForm" class="form-horizontal" action="${updateConfirm}" method="post" modelAttribute ="stockUpdateForm">
        	<%-- <c:set var = "stock" value = "${stock}"/> --%>
          <div class="control-group">
            <label for="dvdEanCode" class="control-label">DVD EAN CODE</label>
            <div class="controls">
              <input id="dvdEanCode" name="dvdEanCode" class="input-large span4" readonly="readonly" type="text" value="${stockUpdateForm.dvdEanCode}"/>
            </div>
          </div>
          
          <div class="control-group ">
            <label for="dvdTitle" class="control-label">DVD TITLE</label>
            <div class="controls">
              <input id="dvdTitle" name="dvdTitle" class="input-large span4" readonly="readonly" type="text" value="${stockUpdateForm.dvdTitle}"/>
            </div>
          </div>

          <div class="control-group">
            <label for="warehouseId" class="control-label">WAREHOUSE ID</label>
            <div class="controls">
              <input id="warehouseId" name="warehouseId" class="input-large span4" readonly="readonly" type="text" value="${stockUpdateForm.warehouseId}"/>
            </div>
          </div>

          <div class="control-group">
            <label for="warehouseName" class="control-label">WAREHOUSE NAME</label>
            <div class="controls">
              <input id="warehouseName" name="warehouseName" class="input-large span4" readonly="readonly" type="text" value="${stockUpdateForm.warehouseName}"/>
            </div>
          </div>

          <div class="control-group">
            <label for="warehouseAddress" class="control-label">WAREHOUSE ADDRESS</label>
            <div class="controls">
              <input id="warehouseAddress" name="warehouseAddress" class="input-large span4" readonly="readonly" type="text" value="${stockUpdateForm.warehouseAddress}"/>
            </div>
          </div>

          <div class="control-group">
            <label for="warehouseTel" class="control-label">WAREHOUSE TEL</label>
            <div class="controls">
              <input id="warehouseTel" name="warehouseTel" class="input-large span4" readonly="readonly" type="text" value="${stockUpdateForm.warehouseTel}"/>
            </div>
          </div>

          <div class="control-group">
            <label for="quantity" class="control-label">QUANTITY</label>
            <div class="controls">
              <input id="quantity" name="quantity" class="input-large span4" type="text" value="${stockUpdateForm.quantity}"/>
            </div>
          </div>

          <!-- submit or return button -->
          <div class="control-group">
            <div class="controls">
              <spring:url var="cancelUrl" value="/stock/updateInput" />
              <a href="${cancelUrl}" class="btn"><i class="icon-remove-sign icon"></i>&nbsp; Cancel</a>
              <button class="btn btn-success" type="submit" name="update">Confirm &nbsp;<i class="icon-play icon-white icon"></i></button>
			  <!-- <a class="btn btn-success" href="javascript:stockUpdateForm.submit();">Confirm &nbsp;<i class="icon-play icon-white icon"></i></a>  -->
 
              
            </div>
          </div>
          
        </form:form>
      </div>
      
      <!-- left space -->
      <div class="span2"></div>
      
    </div>
  </div>
</div>

</html>