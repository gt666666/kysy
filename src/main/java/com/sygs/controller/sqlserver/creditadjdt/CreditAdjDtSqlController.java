package com.sygs.controller.sqlserver.creditadjdt;

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
import com.sygs.pojo.sqlserver.creditadjdt.CreditAdjDtSql;
import com.sygs.service.sqlserver.creditadjdt.CreditAdjDtSqlService;
/**
 * 信贷申请子表
 *
 * @author gaoting
 * @date：2020-03-13 09:58:37
 */
@RestController
@RequestMapping("/creditadjdtsql")
public class CreditAdjDtSqlController extends AbstractBaseController {

    private CreditAdjDtSqlService creditAdjDtSqlService;
    @Autowired
    public CreditAdjDtSqlController(CreditAdjDtSqlService record) {
        this.creditAdjDtSqlService = record;
    }


    @PostMapping("/insertSelective")
    public CommonResult insertSelective(CreditAdjDtSql record) {
        this.creditAdjDtSqlService.insertSelective(record);
        return result(ResultEnum.INSERT_SUCCESS);
    }


    @PostMapping("/deleteById")
    public  CommonResult deleteById( Integer billno,String  entid) {
        int i=this.creditAdjDtSqlService.deleteById(billno,entid);
        if(i==1){
        return result(ResultEnum.DELETE_SUCCESS);
        }
        return  result(ResultEnum.DELETE_ERROR);
    }


    @PostMapping("/updateById")
    public CommonResult updateById(CreditAdjDtSql record) {
        int i= this.creditAdjDtSqlService.updateById(record);
        if (i==1) {
        return result(ResultEnum.UPDATE_SUCCESS);
        }
        return  result(ResultEnum.UPDATE_ERROR);
    }


    @GetMapping("/selectById")
    public CommonResult selectById( Integer billno,String  entid) {
        return resultData(ResultEnum.SELECT_SUCCESS,this.creditAdjDtSqlService.selectById(billno,entid));
    }


    @GetMapping("/listAll")
    public CommonResult listAll() {
        return resultData(ResultEnum.SELECT_SUCCESS,this.creditAdjDtSqlService.list(null));
    }

    @GetMapping("/findByQuery")
    public Page<CreditAdjDtSql> findByQuery(CreditAdjDtSql record) {
        PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
        return new Page<CreditAdjDtSql>(this.creditAdjDtSqlService.findByQuery(record));

    }
}

