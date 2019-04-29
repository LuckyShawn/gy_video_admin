package com.shawn.video.mapper;

import java.util.List;

import com.shawn.video.pojo.Bgm;
import com.shawn.video.pojo.BgmExample;
import org.apache.ibatis.annotations.Param;

public interface BgmMapper {
    int countByExample(BgmExample example);

    int deleteByExample(BgmExample example);

    int deleteByPrimaryKey(String id);

    int insert(Bgm record);

    int insertSelective(Bgm record);

    List<Bgm> selectByExample(BgmExample example);

    Bgm selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Bgm record, @Param("example") BgmExample example);

    int updateByExample(@Param("record") Bgm record, @Param("example") BgmExample example);

    int updateByPrimaryKeySelective(Bgm record);

    int updateByPrimaryKey(Bgm record);
}