package com.figer.mapper;

import com.figer.gen.TLocation;
import com.figer.gen.TLocationExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository("tLocationMapper")
public interface TLocationMapper {
    int countByExample(TLocationExample example);

    int deleteByExample(TLocationExample example);

    int insert(TLocation record);

    int insertSelective(TLocation record);

    List<TLocation> selectByExample(TLocationExample example);

    int updateByExampleSelective(@Param("record") TLocation record, @Param("example") TLocationExample example);

    int updateByExample(@Param("record") TLocation record, @Param("example") TLocationExample example);
}