package com.accenture.aris.inventory.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.accenture.aris.core.support.ServiceResult;
import com.accenture.aris.core.support.message.Messages;
import com.accenture.aris.inventory.business.entity.StockInfoEntity;
import com.accenture.aris.inventory.business.service.StockService;

@Controller
@RequestMapping(value = "/stock")
public class StockDetailController {
	
	private static final Logger LOGGER = LoggerFactory
			.getLogger(StockDetailController.class);
	
	@Autowired
	private Messages messages;
	
	@Autowired
	private StockService stockService;
	
	@RequestMapping(value = "/detail/{id}")
	public String detailAction(@PathVariable("id") int id, Model uiModel, SessionStatus status){
		
		ServiceResult<StockInfoEntity> serviceResult = stockService.readStockInfoService(id);
		StockInfoEntity stockInfoEntity = (StockInfoEntity) serviceResult.getAttribute("stock");
		
		uiModel.addAttribute("stock", stockInfoEntity);
		
		status.setComplete();
		return "stock/stockDetail";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}
	
	
}
