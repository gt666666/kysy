package com.sygs.dao.sqlserver.kplfkmt;

import com.sygs.pojo.mysql.kplfkmt.KPlfkmt;
import com.sygs.pojo.sqlserver.kplfkmt.KPlfkmtSql;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface KPlfkmtSqlMapper {
    KPlfkmt viewOaKplfkmt(Map<String, Object> map);

    int deleteByPrimaryKey(@Param("billno") Integer Integer, @Param("entid") String entid);

    int insert(KPlfkmtSql record);

    int insertSelective(KPlfkmtSql record);

    KPlfkmtSql selectByPrimaryKey(@Param("billno") Integer Integer, @Param("entid") String entid);

    int updateByPrimaryKeySelective(KPlfkmtSql record);

    int updateByPrimaryKey(KPlfkmtSql record);

    KPlfkmtSql find(KPlfkmtSql record);

    List<KPlfkmtSql> list(KPlfkmtSql record);
}