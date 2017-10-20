package com.accenture.aris.inventory.business.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.aris.core.support.ServiceResult;
import com.accenture.aris.core.support.message.Messages;
import com.accenture.aris.core.support.pagination.Pagination;
import com.accenture.aris.core.support.pagination.PaginationUtils;
import com.accenture.aris.inventory.business.entity.StockEntity;
import com.accenture.aris.inventory.business.entity.StockInfoEntity;
import com.accenture.aris.inventory.business.entity.StockTrackEntity;
import com.accenture.aris.inventory.business.repository.StockRepository;
import com.accenture.aris.inventory.business.repository.StockTrackRepository;
import com.accenture.aris.inventory.business.service.StockService;

@Service
public class StockServiceImpl implements StockService {
	private static final long serialVersionUID = 4775138227367404038L;

	@Autowired
	private Messages messages;

	@Autowired
	private StockRepository stockRepository;
	
	@Autowired
	private StockTrackRepository stockTrackRepository;

	@Override
	public ServiceResult<Void> searchStockInfoService(StockInfoEntity entity,
			int page) {
		if(entity == null){
			entity = new StockInfoEntity();
		}
		int recordCount = stockRepository.countByStockInfoEntity(entity);
		int disp = 5;
		int offset = (page -1)*disp;

		List<StockInfoEntity> stocks = stockRepository.selectByStockInfoEntity(entity, new RowBounds(offset,disp));
		List<Pagination> pages = PaginationUtils.pagination(recordCount, page, disp);
		ServiceResult<Void> result = new ServiceResult<Void>();
		result.setAttribute("stocks", stocks);
		result.setAttribute("pages", pages);
		return result;
	}

	@Override
	public ServiceResult<StockInfoEntity> readStockInfoService(int id) {
		StockInfoEntity stockInfoEntity = stockRepository.selectByIdDetailedInfo(id);
		ServiceResult<StockInfoEntity> result = new ServiceResult<StockInfoEntity>();
		result.setAttribute("stock", stockInfoEntity);
		return result;
	}

	@Override
	public ServiceResult<Boolean> updateStockService(StockEntity stockEntity,
			StockTrackEntity stockTrackEntity) {
		
		try {
			int count1 = stockRepository.updateByPrimaryKeySelective(stockEntity);
			int count2 = stockTrackRepository.updateByPrimaryKeySelective(stockTrackEntity);
			
			if (count1 == 1 && count2 == 1) {
				return new ServiceResult<Boolean>(true); 
			}else {
				return new ServiceResult<Boolean>(false);
			}
		} catch (Exception e) {
			ServiceResult<Boolean> result = new ServiceResult<Boolean>(false);
	        result.setErrorCode("E0001");
	        return result;
		}
		
	}

	@Override
	public ServiceResult<Boolean> updateStockService(StockEntity stockEntity) {
		try {
			int count1 = stockRepository.updateByPrimaryKeySelective(stockEntity);
			
			if (count1 == 1) {
				return new ServiceResult<Boolean>(true); 
			}else {
				return new ServiceResult<Boolean>(false);
			}
		} catch (Exception e) {
			ServiceResult<Boolean> result = new ServiceResult<Boolean>(false);
	        result.setErrorCode("E0001");
	        return result;
		}
	}

}
