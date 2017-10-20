package com.accenture.aris.inventory.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.accenture.aris.core.support.ServiceResult;
import com.accenture.aris.core.support.message.Messages;
import com.accenture.aris.inventory.business.entity.StockEntity;
import com.accenture.aris.inventory.business.entity.StockInfoEntity;
import com.accenture.aris.inventory.business.service.StockService;
import com.accenture.aris.inventory.mvc.form.StockUpdateForm;

@Controller
@RequestMapping(value = "/stock")
@SessionAttributes(value = "stockUpdateForm")
public class StockUpdateController {
	
	private static final Logger LOGGER = LoggerFactory
			.getLogger(StockUpdateController.class);
	
	@Autowired
	private Messages messages;
	
	@Autowired
	private StockService stockService;
	
	
	
	/**
	 * Input the Stock information that to be udpated.																														
	 * @param stockUpdateForm
	 * @param id
	 * @param uiModel
	 * @return
	 */
	@RequestMapping(value = "/updateInput/{id}")
	public String updateInputAction(StockUpdateForm stockUpdateForm, @PathVariable("id") int id, Model uiModel){
		StockInfoEntity stockInfoEntity = new StockInfoEntity();
		
		ServiceResult<StockInfoEntity> serviceResult = stockService.readStockInfoService(id);
		stockInfoEntity = (StockInfoEntity) serviceResult.getAttribute("stock");
		BeanUtils.copyProperties(stockInfoEntity, stockUpdateForm);
		
		uiModel.addAttribute("stock",stockInfoEntity);
		return "stock/updateInput";
	}
	
	/**
	 * Reinput the Stock inforamtion that to be updated.																														
	 * @param uiModel
	 * @return
	 */
	@RequestMapping(value = "/updateReInput")
	public String updateReInputAction(StockUpdateForm stockUpdateForm, Model uiModel){
		
		uiModel.addAttribute("stock",stockUpdateForm);
		return "stock/updateInput";
	}
	
	/**
	 * Confirm the Stock information that to be updated.																														
	 * @param stockUpdateForm
	 * @param result
	 * @param uiModel
	 * @return
	 */
	@RequestMapping(value = "/updateConfirm")
	public String updateConfirmAction(@Valid StockUpdateForm stockUpdateForm, BindingResult result, Model uiModel){
		if (result.hasErrors()) {
			LOGGER.debug("invalid request.");
			return "stock/updateInput";
		}
		
		StockInfoEntity stockInfoEntity = new StockInfoEntity();
		BeanUtils.copyProperties(stockUpdateForm, stockInfoEntity);
		
		return "stock/updateConfirm";
	}
	
	/**
	 * Update the Stock information.																														
	 * @param stockUpdateForm
	 * @param uiModel
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/update")
	public String updateAction(StockUpdateForm stockUpdateForm, Model uiModel,HttpServletRequest request){
		//StockInfoEntity stockInfoEntity = new StockInfoEntity();
		//stockService.updateStockService(stockEntity, stockTrackEntity)
		StockEntity stockEntity = new StockEntity();
		BeanUtils.copyProperties(stockUpdateForm, stockEntity);
		stockService.updateStockService(stockEntity);
		
		return "stock/updateComplete";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}

}
