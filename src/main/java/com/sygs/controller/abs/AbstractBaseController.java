package com.sygs.controller.abs;

import com.sygs.enums.ResultEnum;
import com.sygs.pojo.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import java.util.Locale;

/**
 * 类描述：
 * 创建作者：gt
 * 创建日期 ： 2019/11/25
 */
public abstract class AbstractBaseController {
    @Autowired
    private MessageSource messageSource;

    public String getMessage(String key, String... args) {
        return this.messageSource.getMessage(key, args, Locale.getDefault());
    }
    public CommonResult result(ResultEnum resultEnum ){
        CommonResult  commonResult=new CommonResult();
        commonResult.setCode(resultEnum.getCode());
        commonResult.setMsg(resultEnum.getMessage());
        return   commonResult;
    }
    public CommonResult resultData(ResultEnum resultEnum, Object obj ){
        CommonResult  commonResult=new CommonResult();
        commonResult.setCode(resultEnum.getCode());
        commonResult.setMsg(resultEnum.getMessage());
        commonResult.setData(obj);
        return   commonResult;
    }
}
