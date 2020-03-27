package com.sygs.controller;
import com.sygs.controller.abs.AbstractBaseController;
import com.sygs.enums.ResultEnum;
import com.sygs.pojo.CommonResult;
import com.sygs.pojo.Member;
import com.sygs.service.MemberServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * 类描述：
 * 创建作者：gt
 * 创建日期 ： 2019/1/20
 */
@RestController
@Slf4j
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class MemberController extends AbstractBaseController {
    @Resource
    private MemberServiceImpl memberService;
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * shiro登录
     * 前端发送登录请求 => 接口部分获取用户名密码 => 通过subject.login =>  realm域的认证方法
     */
    //用户登录
    @PostMapping(value = "/login")
    public CommonResult login(String mid, String password) {
        //构造登录令牌
        /**
         * 密码加密：
         *     shiro提供的md5加密
         *     Md5Hash:
         *      参数一：加密的内容
         *              111111   --- abcd
         *      参数二：盐（加密的混淆字符串）（用户登录的用户名）
         *              111111+混淆字符串
         *      参数三：加密次数
         *
         */
        password = new Md5Hash(password, mid, 3).toString();
        UsernamePasswordToken upToken = new UsernamePasswordToken(mid, password);
        //1.获取subject
        Subject subject = SecurityUtils.getSubject();
        String session = (String) subject.getSession().getId(); //获取session
        Member member = this.memberService.findById(mid);   //获取登录用户信息
        Map<String, Object> map = new HashMap<>();
        map.put("jsession", session);  //登录的session
        map.put("member", member);  //登录用户信息
        //2.调用subject进行登录
        subject.login(upToken);
        Map<String, Set<String>> mRolesActions = this.memberService.listAuthByMember(mid);//获取用户的角色和权限
        map.put("mRolesActions", mRolesActions);  //登录的用户角色和权限
        this.redisTemplate.opsForHash().putAll(session,map);
        this.redisTemplate.expire(session,10, TimeUnit.HOURS);   //登录信息10小时后过期
        return resultData(ResultEnum.LOGIN_SUCCESS, map); //返回登录成功信息、session,用户名信息
    }

    //前台传来的token获取相应的角色信息
    @PostMapping(value = "/getRoles")
    public Object getRoles(String jsession) {
        return this.redisTemplate.opsForHash().entries(jsession);
    }

    @GetMapping("/autherror")
    public CommonResult autherror(int code) {
        return code == 1 ? result(ResultEnum.NOT_LOGIN): result(ResultEnum.NUNAUTHORIZED);
    }


}
