package com.sygs.dao.sqlserver.creditadjmt;

import com.sygs.pojo.mysql.creditadjmt.CreditAdjMt;
import com.sygs.pojo.sqlserver.creditadjmt.CreditAdjMtSql;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface CreditAdjMtSqlMapper {

    CreditAdjMt ViewOaCreditAdjMt(Map<String,Object>  map);

    int deleteByPrimaryKey(@Param("billno") Integer Integer, @Param("entid") String entid);

    int insertSelective(CreditAdjMtSql record);

    CreditAdjMtSql  selectByPrimaryKey(@Param("billno") Integer Integer, @Param("entid") String entid);

    int updateByPrimaryKeySelective(CreditAdjMtSql record);

    int updateByPrimaryKey(CreditAdjMtSql record);

    CreditAdjMtSql find(CreditAdjMtSql record);

    List<CreditAdjMtSql> list(CreditAdjMtSql record);
}