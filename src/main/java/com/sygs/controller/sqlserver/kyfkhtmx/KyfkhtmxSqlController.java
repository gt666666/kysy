package com.sygs.controller.sqlserver.kyfkhtmx;

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
import com.sygs.pojo.sqlserver.kyfkhtmx.KyfkhtmxSql;
import com.sygs.service.sqlserver.kyfkhtmx.KyfkhtmxSqlService;
/**
 * 预付款申请单批量商品明细表
 *
 * @author gaoting
 * @date：2020-03-11 14:03:36
 */
@RestController
@RequestMapping("/kyfkhtmxsql")
public class KyfkhtmxSqlController extends AbstractBaseController {

    private KyfkhtmxSqlService kyfkhtmxSqlService;
    @Autowired
    public KyfkhtmxSqlController(KyfkhtmxSqlService record) {
        this.kyfkhtmxSqlService = record;
    }


    @PostMapping("/insertSelective")
    public CommonResult insertSelective(KyfkhtmxSql record) {
        this.kyfkhtmxSqlService.insertSelective(record);
        return result(ResultEnum.INSERT_SUCCESS);
    }


    @PostMapping("/deleteById")
    public  CommonResult deleteById( Integer billno,String  entid) {
        int i=this.kyfkhtmxSqlService.deleteById(billno,entid);
        if(i==1){
        return result(ResultEnum.DELETE_SUCCESS);
        }
        return  result(ResultEnum.DELETE_ERROR);
    }


    @PostMapping("/updateById")
    public CommonResult updateById(KyfkhtmxSql record) {
        int i= this.kyfkhtmxSqlService.updateById(record);
        if (i==1) {
        return result(ResultEnum.UPDATE_SUCCESS);
        }
        return  result(ResultEnum.UPDATE_ERROR);
    }


    @GetMapping("/selectById")
    public CommonResult selectById( Integer billno,String  entid) {
        return resultData(ResultEnum.SELECT_SUCCESS,this.kyfkhtmxSqlService.selectById(billno,entid));
    }


    @GetMapping("/listAll")
    public CommonResult listAll() {
        return resultData(ResultEnum.SELECT_SUCCESS,this.kyfkhtmxSqlService.list(null));
    }

    @GetMapping("/findByQuery")
    public Page<KyfkhtmxSql> findByQuery(KyfkhtmxSql record) {
        PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
        return new Page<KyfkhtmxSql>(this.kyfkhtmxSqlService.findByQuery(record));

    }
}

