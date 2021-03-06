package com.sygs.config.global;

import com.sygs.controller.abs.AbstractBaseController;
import com.sygs.enums.ResultEnum;
import com.sygs.pojo.CommonResult;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 自定义的公共异常处理器
 * 1.声明异常处理器
 * 2.对异常统一处理
 */
@RestControllerAdvice  //控制层的切面处理
public class GlobalHandler extends AbstractBaseController {

//    @InitBinder
//    public void initBinder(WebDataBinder binder) {    // 对所有控制层的日期格式进行处理
//        // 首先建立一个可以将字符串转换为日期的工具程序类
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        // 明确的描述此时需要注册一个日期格式的转化处理程序类
//        binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(sdf, true));
//    }

    /**
     * 用户名不存在
     **/
    @ExceptionHandler(value = UnknownAccountException.class)
    public CommonResult unknownAccountException() {
        return result(ResultEnum.USERNAME_NOTEXIST);
    }

    /**
     * 密码错误
     **/
    @ExceptionHandler(value = IncorrectCredentialsException.class)
    public CommonResult incorrectCredentialsException() {
        return result(ResultEnum.PASSWORD_ERROR);
    }

    /**
     * 账户被锁定
     **/
    @ExceptionHandler(value = LockedAccountException.class)
    public CommonResult lockedAccountException() {
        return result(ResultEnum.LOCKEDACCOUNT);
    }

}