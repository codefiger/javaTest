package com.figer.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.figer.gen.mybatis.TLoginLog;
import com.figer.service.mybatis.LoginLogService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"classpath*:applicationContext-mybatis.xml"
})
public class LoginLogServiceTest {
	@Autowired
	private LoginLogService loginLogService;
	
	@Test
	public void testTransactionRepeatabeRead(){
		TLoginLog log = loginLogService.getLoginLogByIp("test-1");
		System.out.println(log.getLoginLogId());
	}
}
