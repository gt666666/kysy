package com.sygs.dao.sqlserver.kxsflxymt;

import com.sygs.pojo.mysql.kxsflxymt.Kxsflxymt;
import com.sygs.pojo.sqlserver.kxsflxymt.KxsflxymtSql;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Map;

@Component
@Mapper
public interface KxsflxymtSqlMapper {

    Kxsflxymt viewOaKxyflmt(Map<String,Object>  map);

    int deleteByPrimaryKey(@Param("billno") Integer Integer, @Param("entid") String entid);

    int insert(KxsflxymtSql record);

    int insertSelective(KxsflxymtSql record);

    KxsflxymtSql selectByPrimaryKey(@Param("billno") Integer Integer, @Param("entid") String entid);

    int updateByPrimaryKeySelective(KxsflxymtSql record);

    int updateByPrimaryKeyWithBLOBs(KxsflxymtSql record);

    int updateByPrimaryKey(KxsflxymtSql record);

    KxsflxymtSql find(KxsflxymtSql record);

    List<KxsflxymtSql> list(KxsflxymtSql record);
}