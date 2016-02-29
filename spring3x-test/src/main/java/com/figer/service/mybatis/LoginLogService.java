package com.figer.service.mybatis;

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
}
