package com.sygs.dao.sqlserver.kcgflxyqd;

import com.sygs.pojo.mysql.kcgflxyqd.Kcgflxyqd;
import com.sygs.pojo.sqlserver.kcgflxyqd.KcgflxyqdSql;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface KcgflxyqdSqlMapper {
    Kcgflxyqd viewOaKflxyqd(Map<String ,Object>  map);
    int deleteByPrimaryKey(@Param("billno") Integer Integer, @Param("entid") String entid);

    int insert(KcgflxyqdSql record);

    int insertSelective(KcgflxyqdSql record);

    KcgflxyqdSql selectByPrimaryKey(@Param("billno") Integer Integer, @Param("entid") String entid);

    int updateByPrimaryKeySelective(KcgflxyqdSql record);

    int updateByPrimaryKey(KcgflxyqdSql record);

    KcgflxyqdSql find(KcgflxyqdSql record);

    List<KcgflxyqdSql> list(KcgflxyqdSql record);
}