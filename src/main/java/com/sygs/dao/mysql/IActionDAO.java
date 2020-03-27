package com.sygs.dao.mysql;

import org.apache.ibatis.annotations.Mapper;
import java.util.Set;

/**
 * 类描述：
 * 创建作者：gt
 * 创建日期 ： 2019/11/19
 */
@Mapper
public interface IActionDAO {
    public Set<String> findAllActionByMember(String mid);
}
