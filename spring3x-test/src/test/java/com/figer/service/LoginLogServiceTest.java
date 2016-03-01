package com.figer.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.figer.service.mybatis.LoginLogService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"classpath*:applicationContext-mybatis.xml"
})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false) 
public class LoginLogServiceTest {
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
	
}
