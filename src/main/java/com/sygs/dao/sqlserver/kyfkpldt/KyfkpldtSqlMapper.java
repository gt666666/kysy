package com.sygs.dao.sqlserver.kyfkpldt;

import com.sygs.pojo.mysql.kyfkpldt.Kyfkpldt;
import com.sygs.pojo.sqlserver.kyfkpldt.KyfkpldtSql;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface KyfkpldtSqlMapper {
    int deleteByPrimaryKey(@Param("billno") Integer Integer, @Param("entid") String entid);

    int insert(KyfkpldtSql record);

    int insertSelective(KyfkpldtSql record);

    KyfkpldtSql selectByPrimaryKey(@Param("billno") Integer Integer, @Param("entid") String entid);

    int updateByPrimaryKeySelective(KyfkpldtSql record);


    int updateByPrimaryKey(KyfkpldtSql record);

    KyfkpldtSql find(KyfkpldtSql record);

    List<KyfkpldtSql> list(KyfkpldtSql record);

    List<Kyfkpldt> ViewOakYfkpldt(Map<String,Object> map);
}