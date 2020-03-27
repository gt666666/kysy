package com.sygs.dao.mysql.kxsflxymt;

import com.sygs.pojo.mysql.kxsflxymt.Kxsflxymt;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component
public interface KxsflxymtMapper {
    int deleteByPrimaryKey(@Param("billno") Integer Integer, @Param("entid") String entid);

    int insert(Kxsflxymt record);

    int insertSelective(Kxsflxymt record);

    Kxsflxymt selectByPrimaryKey(@Param("billno") Integer Integer, @Param("entid") String entid);

    int updateByPrimaryKeySelective(Kxsflxymt record);

    int updateByPrimaryKeyWithBLOBs(Kxsflxymt record);

    int updateByPrimaryKey(Kxsflxymt record);

    Kxsflxymt find(Kxsflxymt record);

    List<Kxsflxymt> list(Kxsflxymt record);
}