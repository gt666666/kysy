package com.sygs.dao.sqlserver.kxsflxydt;

import com.sygs.pojo.mysql.kxsflxydt.Kxsflxydt;
import com.sygs.pojo.sqlserver.kxsflxydt.KxsflxydtSql;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface KxsflxydtSqlMapper {

    List<Kxsflxydt>  viewOaKxyfldt(Map<String ,Object> map);

    int deleteByPrimaryKey(@Param("billno") Integer Integer, @Param("entid") String entid);

    int insert(KxsflxydtSql record);

    int insertSelective(KxsflxydtSql record);

    KxsflxydtSql selectByPrimaryKey(@Param("billno") Integer Integer, @Param("entid") String entid);

    int updateByPrimaryKeySelective(KxsflxydtSql record);

    int updateByPrimaryKeyWithBLOBs(KxsflxydtSql record);

    int updateByPrimaryKey(KxsflxydtSql record);

    KxsflxydtSql find(KxsflxydtSql record);

    List<KxsflxydtSql> list(KxsflxydtSql record);
}