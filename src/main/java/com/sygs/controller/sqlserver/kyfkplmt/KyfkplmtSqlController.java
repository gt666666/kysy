package com.sygs.controller.sqlserver.kyfkplmt;

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
import com.sygs.pojo.sqlserver.kyfkplmt.KyfkplmtSql;
import com.sygs.service.sqlserver.kyfkplmt.KyfkplmtSqlService;
/**
 * 预付款申请汇总单主表
 *
 * @author gaoting
 * @date：2020-03-11 11:34:39
 */
@RestController
@RequestMapping("/kyfkplmtsql")
public class KyfkplmtSqlController extends AbstractBaseController {

    private KyfkplmtSqlService kyfkplmtSqlService;
    @Autowired
    public KyfkplmtSqlController(KyfkplmtSqlService record) {
        this.kyfkplmtSqlService = record;
    }


    @PostMapping("/insertSelective")
    public CommonResult insertSelective(KyfkplmtSql record) {
        this.kyfkplmtSqlService.insertSelective(record);
        return result(ResultEnum.INSERT_SUCCESS);
    }


    @PostMapping("/deleteById")
    public  CommonResult deleteById( Integer billno,String  entid) {
        int i=this.kyfkplmtSqlService.deleteById(billno,entid);
        if(i==1){
        return result(ResultEnum.DELETE_SUCCESS);
        }
        return  result(ResultEnum.DELETE_ERROR);
    }


    @PostMapping("/updateById")
    public CommonResult updateById(KyfkplmtSql record) {
        int i= this.kyfkplmtSqlService.updateById(record);
        if (i==1) {
        return result(ResultEnum.UPDATE_SUCCESS);
        }
        return  result(ResultEnum.UPDATE_ERROR);
    }


    @GetMapping("/selectById")
    public CommonResult selectById( Integer billno,String  entid) {
        return resultData(ResultEnum.SELECT_SUCCESS,this.kyfkplmtSqlService.selectById(billno,entid));
    }


    @GetMapping("/listAll")
    public CommonResult listAll() {
        return resultData(ResultEnum.SELECT_SUCCESS,this.kyfkplmtSqlService.list(null));
    }

    @GetMapping("/findByQuery")
    public Page<KyfkplmtSql> findByQuery(KyfkplmtSql record) {
        PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
        return new Page<KyfkplmtSql>(this.kyfkplmtSqlService.findByQuery(record));

    }
}

