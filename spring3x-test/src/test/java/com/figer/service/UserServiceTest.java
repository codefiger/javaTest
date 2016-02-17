package com.figer.service;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.figer.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"classpath*:applicationContext*.xml"
})
public class UserServiceTest {
	@Autowired
	private UserService userService;

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testHasMatchUser(){
		User user = new User();
		user.setUserName("figer");
		user.setPassword("123456");
		boolean b1 = userService.hasMatchUser(user.getUserName(), user.getPassword());
		boolean b2 = userService.hasMatchUser("admin", "123456");
		assertTrue(b2);
		//assertTrue(b1);
	}
	
	@Test
	public void testFindUserByUsername(){
		User user = userService.findUserByUsername("admin");
		System.out.println(user.getPassword());
	}
	
	@Test
	public void testLoginSuccess(){
		User user = userService.findUserByUsername("admin");
		if (user != null) {
			userService.loginSuccess(user);
		}
	}

}
