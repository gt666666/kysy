package com.sygs.controller.sqlserver.kyfkpldt;

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
import com.sygs.pojo.sqlserver.kyfkpldt.KyfkpldtSql;
import com.sygs.service.sqlserver.kyfkpldt.KyfkpldtSqlService;
/**
 * 预付款申请汇总单子表
 *
 * @author gaoting
 * @date：2020-03-11 13:15:22
 */
@RestController
@RequestMapping("/kyfkpldtsql")
public class KyfkpldtSqlController extends AbstractBaseController {

    private KyfkpldtSqlService kyfkpldtSqlService;
    @Autowired
    public KyfkpldtSqlController(KyfkpldtSqlService record) {
        this.kyfkpldtSqlService = record;
    }


    @PostMapping("/insertSelective")
    public CommonResult insertSelective(KyfkpldtSql record) {
        this.kyfkpldtSqlService.insertSelective(record);
        return result(ResultEnum.INSERT_SUCCESS);
    }


    @PostMapping("/deleteById")
    public  CommonResult deleteById( Integer billno,String  entid) {
        int i=this.kyfkpldtSqlService.deleteById(billno,entid);
        if(i==1){
        return result(ResultEnum.DELETE_SUCCESS);
        }
        return  result(ResultEnum.DELETE_ERROR);
    }


    @PostMapping("/updateById")
    public CommonResult updateById(KyfkpldtSql record) {
        int i= this.kyfkpldtSqlService.updateById(record);
        if (i==1) {
        return result(ResultEnum.UPDATE_SUCCESS);
        }
        return  result(ResultEnum.UPDATE_ERROR);
    }


    @GetMapping("/selectById")
    public CommonResult selectById( Integer billno,String  entid) {
        return resultData(ResultEnum.SELECT_SUCCESS,this.kyfkpldtSqlService.selectById(billno,entid));
    }


    @GetMapping("/listAll")
    public CommonResult listAll() {
        return resultData(ResultEnum.SELECT_SUCCESS,this.kyfkpldtSqlService.list(null));
    }

    @GetMapping("/findByQuery")
    public Page<KyfkpldtSql> findByQuery(KyfkpldtSql record) {
        PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
        return new Page<KyfkpldtSql>(this.kyfkpldtSqlService.findByQuery(record));

    }
}

