package com.figer.mapper;

import com.figer.gen.mybatis.TLoginLog;
import com.figer.gen.mybatis.TLoginLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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
}