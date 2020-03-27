package com.sygs.dao.mysql.kxsflxydt;

import com.sygs.pojo.mysql.kxsflxydt.Kxsflxydt;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper
public interface KxsflxydtMapper {
    boolean insertForeach (List<Kxsflxydt>  list);
    int deleteByPrimaryKey(@Param("billno") Integer Integer, @Param("entid") String entid);

    int insert(Kxsflxydt record);

    int insertSelective(Kxsflxydt record);

    Kxsflxydt selectByPrimaryKey(@Param("billno") Integer Integer, @Param("entid") String entid);

    int updateByPrimaryKeySelective(Kxsflxydt record);

    int updateByPrimaryKeyWithBLOBs(Kxsflxydt record);

    int updateByPrimaryKey(Kxsflxydt record);

    Kxsflxydt find(Kxsflxydt record);

    List<Kxsflxydt> list(Kxsflxydt record);
}