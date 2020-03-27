package com.sygs.config.shiro;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.Set;
/**
 * 自定义角色、权限Filter
 */
public class CustomRolesOrAuthorizationFilter extends AuthorizationFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object o) throws Exception {
        Subject subject = getSubject(request, response);
        //获取当前访问路径所需要的角色集合
        String[] rolesArray = (String[]) o;
        //没有角色限制，可以直接访问
        if (rolesArray == null || rolesArray.length == 0) {
            return true;
        }
        Set<String> roles = CollectionUtils.asSet(rolesArray);
        //当前subject是roles中的任意一个，则由权限
        for (String role : roles) {
            if (subject.hasRole(role)) {
                return true;
            }
        }
        return false;    //是否包含有角色
    }
}
