package com.sygs.dao.mysql.creditadjmt;

import com.sygs.pojo.mysql.creditadjmt.CreditAdjMt;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper
public interface CreditAdjMtMapper {
    int deleteByPrimaryKey(@Param("billno") Integer billno, @Param("entid") String entid);


    int insertSelective(CreditAdjMt record);

    CreditAdjMt selectByPrimaryKey(@Param("billno") Integer billno, @Param("entid") String entid);

    int updateByPrimaryKeySelective(CreditAdjMt record);


    int updateByPrimaryKey(CreditAdjMt record);

    CreditAdjMt find(CreditAdjMt record);

    List<CreditAdjMt> list(CreditAdjMt record);
}