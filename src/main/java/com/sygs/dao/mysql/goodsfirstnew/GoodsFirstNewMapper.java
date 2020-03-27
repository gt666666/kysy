package com.sygs.dao.mysql.goodsfirstnew;

import com.sygs.pojo.mysql.goodsfirstnew.GoodsFirstNew;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component
public interface GoodsFirstNewMapper {
    int deleteByPrimaryKey(@Param("billno") Integer billno, @Param("entid") String entid);

    int insert(GoodsFirstNew record);

    int insertSelective(GoodsFirstNew record);

    GoodsFirstNew selectByPrimaryKey(@Param("billno") Integer billno, @Param("entid") String entid);

    int updateByPrimaryKeySelective(GoodsFirstNew record);

    int updateByPrimaryKey(GoodsFirstNew record);

    GoodsFirstNew find(GoodsFirstNew record);

    List<GoodsFirstNew> list(GoodsFirstNew record);
}