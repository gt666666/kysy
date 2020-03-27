package com.sygs.dao.sqlserver.goodsfirstnew;

import com.sygs.pojo.mysql.goodsfirstnew.GoodsFirstNew;
import com.sygs.pojo.sqlserver.goodsfirstnew.GoodsFirstNewSql;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Mapper
public interface GoodsFirstNewSqlMapper {

    GoodsFirstNew viewOaGoodsFirst(Map<String  ,Object>  map);

    int deleteByPrimaryKey(@Param("billno") Integer Integer, @Param("entid") String entid);

    int insert(GoodsFirstNewSql record);

    int insertSelective(GoodsFirstNewSql record);

    GoodsFirstNewSql selectByPrimaryKey(@Param("billno") Integer Integer, @Param("entid") String entid);

    int updateByPrimaryKeySelective(GoodsFirstNewSql record);

    int updateByPrimaryKey(GoodsFirstNewSql record);

    GoodsFirstNewSql find(GoodsFirstNewSql record);

    List<GoodsFirstNewSql> list(GoodsFirstNewSql record);
}