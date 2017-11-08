package com.accenture.aris.sample.business.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.dbunit.DatabaseUnitException;
import org.dbunit.ext.mysql.MySqlDataTypeFactory;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.xml.sax.SAXException;

import com.accenture.aris.core.support.utils.AssertUtils;
import com.accenture.aris.core.support.utils.DatabaseUtils;
import com.accenture.aris.inventory.business.entity.StockInfoEntity;
import com.accenture.aris.inventory.business.service.StockService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:webmvc-config-test.xml")
public class StockServiceTest {
	@Autowired
	StockService stockService;
	Map<String, List<?>> testData;

	@Before
	public void init() throws DataAccessException, IOException, SQLException,
			DatabaseUnitException, ParserConfigurationException, SAXException,
			org.apache.poi.openxml4j.exceptions.InvalidFormatException {
		DatabaseUtils.execute(DatabaseOperation.REFRESH,
				"data/TestStockService_Database.xls",
				new MySqlDataTypeFactory());
		testData = AssertUtils.getData("data/TestStockService_Entity.xml",
				"data/TestStockService_Entity.xls");
	}

	@After
	private void destory() throws DatabaseUnitException, IOException,
			SQLException {
		DatabaseUtils.execute(DatabaseOperation.DELETE,
				"data/TestStockService_Database.xls",
				new MySqlDataTypeFactory());
	}

	@Test
	public void testSearchStockInfoService_1() {
		List<StockInfoEntity> expected = (List<StockInfoEntity>) testData
				.get("TEST1_OUTPUT");
		List<StockInfoEntity> actual = (List<StockInfoEntity>) stockService
				.searchStockInfoService(null, 1).getAttribute("stocks");
		AssertUtils.assertEquals(expected, actual);
	}
}
