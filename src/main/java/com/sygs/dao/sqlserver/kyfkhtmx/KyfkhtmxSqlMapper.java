package com.sygs.dao.sqlserver.kyfkhtmx;

import com.sygs.pojo.mysql.kyfkhtmx.Kyfkhtmx;
import com.sygs.pojo.sqlserver.kyfkhtmx.KyfkhtmxSql;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface KyfkhtmxSqlMapper {
    int deleteByPrimaryKey(@Param("billno") Integer Integer, @Param("entid") String entid);

    int insert(KyfkhtmxSql record);

    int insertSelective(KyfkhtmxSql record);

    KyfkhtmxSql selectByPrimaryKey(@Param("billno") Integer Integer, @Param("entid") String entid);

    int updateByPrimaryKeySelective(KyfkhtmxSql record);

    int updateByPrimaryKeyWithBLOBs(KyfkhtmxSql record);

    int updateByPrimaryKey(KyfkhtmxSql record);

    KyfkhtmxSql find(KyfkhtmxSql record);

    List<KyfkhtmxSql> list(KyfkhtmxSql record);

    List<Kyfkhtmx> viewOaKyfkhtmx(Map<String ,Object>   map);
}