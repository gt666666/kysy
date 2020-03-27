package com.sygs.dao.sqlserver.creditadjdt;

import com.sygs.pojo.mysql.creditadjdt.CreditAdjDt;
import com.sygs.pojo.mysql.creditadjmt.CreditAdjMt;
import com.sygs.pojo.sqlserver.creditadjdt.CreditAdjDtSql;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Mapper
public interface CreditAdjDtSqlMapper {

    List<CreditAdjDt> ViewOaCreditAdjDt(Map<String,Object> map);

    int deleteByPrimaryKey(@Param("billno") Integer Integer, @Param("entid") String entid);

    int insertSelective(CreditAdjDtSql record);

    CreditAdjDtSql selectByPrimaryKey(@Param("billno") Integer Integer, @Param("entid") String entid);

    int updateByPrimaryKeySelective(CreditAdjDtSql record);

    int updateByPrimaryKey(CreditAdjDtSql record);

    CreditAdjDtSql find(CreditAdjDtSql record);

    List<CreditAdjDtSql> list(CreditAdjDtSql record);
}