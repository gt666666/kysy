package com.sygs.dao.sqlserver.kcgflxyzc;

import com.sygs.pojo.sqlserver.kcgflxyzc.KcgflxyzcSql;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import java.util.List;
@Mapper
@Component
public interface KcgflxyzcSqlMapper {
    int deleteByPrimaryKey(@Param("billno") Integer Integer, @Param("entid") String entid);

    int insert(KcgflxyzcSql record);

    int insertSelective(KcgflxyzcSql record);

    KcgflxyzcSql selectByPrimaryKey(@Param("billno") Integer Integer, @Param("entid") String entid);

    int updateByPrimaryKeySelective(KcgflxyzcSql record);

    int updateByPrimaryKey(KcgflxyzcSql record);

    KcgflxyzcSql find(KcgflxyzcSql record);

    List<KcgflxyzcSql> list(KcgflxyzcSql record);
}