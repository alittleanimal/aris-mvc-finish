package com.accenture.aris.inventory.business.service;

import java.io.Serializable;

import com.accenture.aris.core.support.ServiceResult;
import com.accenture.aris.inventory.business.entity.StockEntity;
import com.accenture.aris.inventory.business.entity.StockInfoEntity;
import com.accenture.aris.inventory.business.entity.StockTrackEntity;

public interface StockService extends Serializable {
	public ServiceResult<Void> searchStockInfoService(StockInfoEntity entity,int page);
	public ServiceResult<StockInfoEntity> readStockInfoService(int id);
	public ServiceResult<Boolean> updateStockService(StockEntity stockEntity,StockTrackEntity stockTrackEntity);
	public ServiceResult<Boolean> updateStockService(StockEntity stockEntity);
	public ServiceResult<Boolean> deleteStockService(int id);
	
}
