package com.sygs.dao.sqlserver.kcgflxybm;

import com.sygs.pojo.mysql.kcgflxybm.Kcgflxybm;
import com.sygs.pojo.sqlserver.kcgflxybm.KcgflxybmSql;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface KcgflxybmSqlMapper {
    Kcgflxybm viewOaKflxybm(Map<String  ,Object>  map);

    int deleteByPrimaryKey(@Param("billno") Integer Integer, @Param("entid") String entid);

    int insert(KcgflxybmSql record);

    int insertSelective(KcgflxybmSql record);

    KcgflxybmSql selectByPrimaryKey(@Param("billno") Integer Integer, @Param("entid") String entid);

    int updateByPrimaryKeySelective(KcgflxybmSql record);

    int updateByPrimaryKey(KcgflxybmSql record);

    KcgflxybmSql find(KcgflxybmSql record);

    List<KcgflxybmSql> list(KcgflxybmSql record);
}