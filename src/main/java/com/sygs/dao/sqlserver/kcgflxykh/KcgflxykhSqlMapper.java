package com.sygs.dao.sqlserver.kcgflxykh;

import com.sygs.pojo.mysql.kcgflxykh.Kcgflxykh;
import com.sygs.pojo.sqlserver.kcgflxykh.KcgflxykhSql;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Mapper
public interface KcgflxykhSqlMapper {
    Kcgflxykh viewOaKflxykh(Map<String ,Object>  map);

    int deleteByPrimaryKey(@Param("billno") Integer Integer, @Param("entid") String entid);

    int insert(KcgflxykhSql record);

    int insertSelective(KcgflxykhSql record);

    KcgflxykhSql selectByPrimaryKey(@Param("billno") Integer Integer, @Param("entid") String entid);

    int updateByPrimaryKeySelective(KcgflxykhSql record);

    int updateByPrimaryKey(KcgflxykhSql record);

    KcgflxykhSql find(KcgflxykhSql record);

    List<KcgflxykhSql> list(KcgflxykhSql record);
}