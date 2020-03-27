package com.sygs.dao.mysql.creditadjdt;

import com.sygs.pojo.mysql.creditadjdt.CreditAdjDt;
import com.sygs.pojo.mysql.kyfkpldt.Kyfkpldt;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper
public interface CreditAdjDtMapper {
    int deleteByPrimaryKey(@Param("billno") Integer billno, @Param("entid") String entid);

    int insert(CreditAdjDt record);

    int insertSelective(CreditAdjDt  record);

    CreditAdjDt  selectByPrimaryKey(@Param("billno") Integer billno, @Param("entid") String entid);

    int updateByPrimaryKeySelective(CreditAdjDt record);

    int updateByPrimaryKeyWithBLOBs(CreditAdjDt  record);

    int updateByPrimaryKey(CreditAdjDt record);

    CreditAdjDt find(CreditAdjDt record);

    List<CreditAdjDt> list(CreditAdjDt record);

    boolean insertForeach (List<CreditAdjDt>  list);
}