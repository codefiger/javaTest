package com.figer.springrmi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"classpath:springrmi/server-beans.xml"
})
public class SpringRmiServerTest {
	
	@Test
	public void test() throws Exception {
		while(true){
			Thread.sleep(100000);
		}
	};

}
