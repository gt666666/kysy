package com.sygs.controller.mysql.kyfkhtmx;

import org.springframework.web.bind.annotation.*;
import com.sygs.controller.abs.AbstractBaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sygs.enums.ResultEnum ;
import com.sygs.utils.Page;
import com.github.pagehelper.PageHelper;
import com.sygs.utils.PaginationContext;
import com.sygs.pojo.CommonResult;
import com.sygs.pojo.mysql.kyfkhtmx.Kyfkhtmx;
import com.sygs.service.mysql.kyfkhtmx.KyfkhtmxService;
/**
 * 预付款申请单批量商品明细表
 *
 * @author gaoting
 * @date：2020-03-11 14:09:25
 */
@RestController
@RequestMapping("/kyfkhtmx")
public class KyfkhtmxController extends AbstractBaseController {

    private KyfkhtmxService kyfkhtmxService;
    @Autowired
    public KyfkhtmxController(KyfkhtmxService record) {
        this.kyfkhtmxService = record;
    }


    @PostMapping("/insertSelective")
    public CommonResult insertSelective(Kyfkhtmx record) {
        this.kyfkhtmxService.insertSelective(record);
        return result(ResultEnum.INSERT_SUCCESS);
    }


    @PostMapping("/deleteById")
    public  CommonResult deleteById( Integer billno,String  entid) {
        int i=this.kyfkhtmxService.deleteById(billno,entid);
        if(i==1){
        return result(ResultEnum.DELETE_SUCCESS);
        }
        return  result(ResultEnum.DELETE_ERROR);
    }


    @PostMapping("/updateById")
    public CommonResult updateById(Kyfkhtmx record) {
        int i= this.kyfkhtmxService.updateById(record);
        if (i==1) {
        return result(ResultEnum.UPDATE_SUCCESS);
        }
        return  result(ResultEnum.UPDATE_ERROR);
    }


    @GetMapping("/selectById")
    public CommonResult selectById( Integer billno,String  entid) {
        return resultData(ResultEnum.SELECT_SUCCESS,this.kyfkhtmxService.selectById(billno,entid));
    }


    @GetMapping("/listAll")
    public CommonResult listAll() {
        return resultData(ResultEnum.SELECT_SUCCESS,this.kyfkhtmxService.list(null));
    }

    @GetMapping("/findByQuery")
    public Page<Kyfkhtmx> findByQuery(Kyfkhtmx record) {
        PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
        return new Page<Kyfkhtmx>(this.kyfkhtmxService.findByQuery(record));

    }
}

