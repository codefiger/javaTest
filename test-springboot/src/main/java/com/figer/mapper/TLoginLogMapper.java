package com.figer.mapper;

import java.util.List;

import com.figer.mybatis.TLoginLog;
import com.figer.mybatis.TLoginLogExample;
import org.apache.ibatis.annotations.Param;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public interface TLoginLogMapper {
    int countByExample(TLoginLogExample example);

    int deleteByExample(TLoginLogExample example);

    int deleteByPrimaryKey(Integer loginLogId);

    int insert(TLoginLog record);

    int insertSelective(TLoginLog record);

    List<TLoginLog> selectByExample(TLoginLogExample example);

    TLoginLog selectByPrimaryKey(Integer loginLogId);

    int updateByExampleSelective(@Param("record") TLoginLog record, @Param("example") TLoginLogExample example);

    int updateByExample(@Param("record") TLoginLog record, @Param("example") TLoginLogExample example);

    int updateByPrimaryKeySelective(TLoginLog record);

    int updateByPrimaryKey(TLoginLog record);

    PageList<TLoginLog> findLoginLog(String ip, PageBounds pageBounds);
}