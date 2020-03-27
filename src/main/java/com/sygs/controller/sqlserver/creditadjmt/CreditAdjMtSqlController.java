package com.sygs.controller.sqlserver.creditadjmt;

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
import com.sygs.pojo.sqlserver.creditadjmt.CreditAdjMtSql;
import com.sygs.service.sqlserver.creditadjmt.CreditAdjMtSqlService;
/**
 * 信贷申请主表
 *
 * @author gaoting
 * @date：2020-03-13 10:08:41
 */
@RestController
@RequestMapping("/creditadjmtsql")
public class CreditAdjMtSqlController extends AbstractBaseController {

    private CreditAdjMtSqlService creditAdjMtSqlService;
    @Autowired
    public CreditAdjMtSqlController(CreditAdjMtSqlService record) {
        this.creditAdjMtSqlService = record;
    }


    @PostMapping("/insertSelective")
    public CommonResult insertSelective(CreditAdjMtSql record) {
        this.creditAdjMtSqlService.insertSelective(record);
        return result(ResultEnum.INSERT_SUCCESS);
    }


    @PostMapping("/deleteById")
    public  CommonResult deleteById( Integer billno,String  entid) {
        int i=this.creditAdjMtSqlService.deleteById(billno,entid);
        if(i==1){
        return result(ResultEnum.DELETE_SUCCESS);
        }
        return  result(ResultEnum.DELETE_ERROR);
    }


    @PostMapping("/updateById")
    public CommonResult updateById(CreditAdjMtSql record) {
        int i= this.creditAdjMtSqlService.updateById(record);
        if (i==1) {
        return result(ResultEnum.UPDATE_SUCCESS);
        }
        return  result(ResultEnum.UPDATE_ERROR);
    }


    @GetMapping("/selectById")
    public CommonResult selectById( Integer billno,String  entid) {
        return resultData(ResultEnum.SELECT_SUCCESS,this.creditAdjMtSqlService.selectById(billno,entid));
    }


    @GetMapping("/listAll")
    public CommonResult listAll() {
        return resultData(ResultEnum.SELECT_SUCCESS,this.creditAdjMtSqlService.list(null));
    }

    @GetMapping("/findByQuery")
    public Page<CreditAdjMtSql> findByQuery(CreditAdjMtSql record) {
        PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
        return new Page<CreditAdjMtSql>(this.creditAdjMtSqlService.findByQuery(record));

    }
}

