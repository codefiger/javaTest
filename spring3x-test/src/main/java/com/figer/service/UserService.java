package com.figer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.figer.dao.LoginLogDao;
import com.figer.dao.UserDao;
import com.figer.domain.LoginLog;
import com.figer.domain.User;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private LoginLogDao loginLogDao;
	
	public boolean hasMatchUser(String username, String password){
		int count = userDao.getMatchCount(username, password);
		return count > 0; 
	}
	
	public User findUserByUsername(String username){
		return userDao.findUserByUserName(username);
	}
	
	public void loginSuccess(User user){
		user.setCredits( 5 + user.getCredits());
		LoginLog loginLog = new LoginLog();
		loginLog.setUserId(user.getUserId());
		loginLog.setIp(user.getLastIp());
		loginLog.setLoginDate(user.getLastVisit());
        userDao.updateLoginInfo(user);
        loginLogDao.insertLoginLog(loginLog);
	}
}
