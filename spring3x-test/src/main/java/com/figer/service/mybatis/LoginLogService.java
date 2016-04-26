package com.figer.service.mybatis;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.figer.gen.mybatis.TLoginLog;
import com.figer.gen.mybatis.TLoginLogExample;
import com.figer.mapper.TLoginLogMapper;

@Service
public class LoginLogService {
	@Autowired
	TLoginLogMapper tLoginLogMapper;
	
	public TLoginLog getLoginLogByIp(String ip){
		TLoginLogExample example = new TLoginLogExample();
		example.createCriteria().andIpEqualTo(ip);
		if (tLoginLogMapper.selectByExample(example) != null && tLoginLogMapper.selectByExample(example).size() != 0) {
			return tLoginLogMapper.selectByExample(example).get(0);
		}else{
			return null;
		}
	}
	
	public boolean updateLoginLog(TLoginLog log){
		return tLoginLogMapper.updateByPrimaryKey(log) >= 1;
	}
	
	public void loginLogTransaction(String ip){
		TLoginLog log = getLoginLogByIp("test-1");
		System.out.println(log.getUserId());
		log.setUserId(log.getUserId() + 1);
		
		
		updateLoginLog(log);
		System.out.println("----------success");
		throw new RuntimeException();
	}
	
	public void loginLogTransaction2(String ip){
		TLoginLog log = getLoginLogByIp("test-1");
		System.out.println(log.getUserId());
		log.setUserId(log.getUserId() + 1);
		
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		updateLoginLog(log);
	}

	public PageList<TLoginLog> findLoginLog(String ip, PageBounds pageBounds){
		return tLoginLogMapper.findLoginLog(ip, pageBounds);
	}
	
	
}
