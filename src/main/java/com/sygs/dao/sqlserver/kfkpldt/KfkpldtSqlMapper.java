package com.sygs.dao.sqlserver.kfkpldt;

import com.sygs.pojo.mysql.kfkpldt.Kfkpldt;
import com.sygs.pojo.sqlserver.kfkpldt.KfkpldtSql;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface KfkpldtSqlMapper {

    List<Kfkpldt> viewOaKfkpldt(Map<String ,Object> map);

    int deleteByPrimaryKey(@Param("billno") Integer Integer, @Param("entid") String entid);

    int insert(KfkpldtSql record);

    int insertSelective(KfkpldtSql record);

    KfkpldtSql selectByPrimaryKey(@Param("billno") Integer Integer, @Param("entid") String entid);

    int updateByPrimaryKeySelective(KfkpldtSql record);

    int updateByPrimaryKey(KfkpldtSql record);

    KfkpldtSql find(KfkpldtSql record);

    List<KfkpldtSql> list(KfkpldtSql record);
}