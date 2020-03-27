package com.sygs.service;
import com.sygs.dao.mysql.IActionDAO;
import com.sygs.dao.mysql.IMemberDAO;
import com.sygs.dao.mysql.IRoleDAO;
import com.sygs.pojo.Member;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/**
 * 类描述：
 * 创建作者：gt
 * 创建日期 ： 2019/11/19
 */
@Service
public class MemberServiceImpl {
    @Resource
    private IActionDAO actionDAO;
    @Resource
    private IMemberDAO memberDAO;
    @Resource
    private IRoleDAO roleDAO;

    public Member findById(String mid) {
        return this.memberDAO.findById(mid);
    }

    public Map<String, Set<String>> listAuthByMember(String mid) {
        Map<String, Set<String>> map = new HashMap<String, Set<String>>();
        map.put("allRoles", this.roleDAO.findAllRoleByMember(mid));
        map.put("allActions", this.actionDAO.findAllActionByMember(mid));
        return map;
    }
}
