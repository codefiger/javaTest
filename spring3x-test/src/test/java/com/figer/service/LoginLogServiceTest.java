package com.figer.service;

import com.figer.gen.mybatis.TLoginLog;
import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.figer.service.mybatis.LoginLogService;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"classpath*:applicationContext-mybatis.xml"
})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false) 
public class LoginLogServiceTest {
  public static final Logger LOGGER = LoggerFactory.getLogger(LoginLogServiceTest.class);

	@Autowired
	private LoginLogService loginLogService;
	
	@Test
	@Transactional(isolation=Isolation.SERIALIZABLE)
	public void testTransactionRepeatabeRead(){
		loginLogService.loginLogTransaction("test-1");
	}
	
	@Test
	@Transactional(isolation=Isolation.SERIALIZABLE)
	public void testTransactionRepeatabeRead2(){
		loginLogService.loginLogTransaction2("test-1");
	}

	@Test
	public void testFindLoginLog(){
    PageBounds pageBounds = new PageBounds(1, 3, Order.formString("login_datetime.desc"), true);

		PageList<TLoginLog> logs = loginLogService.findLoginLog("test", pageBounds);
    LOGGER.info("total:{}", logs.getPaginator().getTotalCount());
		for (TLoginLog loginLog : logs){
			System.out.println(loginLog.getUserId() + "," + loginLog.getLoginDatetime());
		}
	}
	
}
