package com.sygs.dao.sqlserver.kyfkplmt;

import com.sygs.pojo.mysql.kyfkplmt.Kyfkplmt;
import com.sygs.pojo.sqlserver.kyfkplmt.KyfkplmtSql;
import lombok.Data;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Mapper
public interface KyfkplmtSqlMapper {

    Kyfkplmt viewOaKyfkplmt(Map<String, Object> map);

    int deleteByPrimaryKey(@Param("billno") Integer Integer, @Param("entid") String entid);

    int insert(KyfkplmtSql record);

    int insertSelective(KyfkplmtSql record);

    KyfkplmtSql selectByPrimaryKey(@Param("billno") Integer billno, @Param("entid") String entid);

    int updateByPrimaryKeySelective(KyfkplmtSql record);

    int updateByPrimaryKeyWithBLOBs(KyfkplmtSql record);

    int updateByPrimaryKey(KyfkplmtSql record);

    KyfkplmtSql find(KyfkplmtSql record);

    List<KyfkplmtSql> list(KyfkplmtSql record);
}