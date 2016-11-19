package com.figer.mapper;

import com.figer.mybatis.TUser;

public interface TUserMapper {
    int insert(TUser record);

    int insertSelective(TUser record);

    TUser selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);
}