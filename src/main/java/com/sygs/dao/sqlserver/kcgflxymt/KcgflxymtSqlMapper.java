package com.sygs.dao.sqlserver.kcgflxymt;

import com.sygs.pojo.mysql.kcgflxymt.Kcgflxymt;
import com.sygs.pojo.sqlserver.kcgflxymt.KcgflxymtSql;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Mapper
public interface KcgflxymtSqlMapper {

    Kcgflxymt viewOaKflxyMt(Map<String ,Object>  map);

    int deleteByPrimaryKey(@Param("billno") Integer Integer, @Param("entid") String entid);

    int insert(KcgflxymtSql record);

    int insertSelective(KcgflxymtSql record);

    KcgflxymtSql selectByPrimaryKey(@Param("billno") Integer Integer, @Param("entid") String entid);

    int updateByPrimaryKeySelective(KcgflxymtSql record);

    int updateByPrimaryKey(KcgflxymtSql record);

    KcgflxymtSql find(KcgflxymtSql record);

    List<KcgflxymtSql> list(KcgflxymtSql record);
}