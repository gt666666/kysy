package com.sygs.controller.mysql.creditadjdt;

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
import com.sygs.pojo.mysql.creditadjdt.CreditAdjDt;
import com.sygs.service.mysql.creditadjdt.CreditAdjDtService;
/**
 * 信贷申请子表
 *
 * @author gaoting
 * @date：2020-03-13 10:14:34
 */
@RestController
@RequestMapping("/creditadjdt")
public class CreditAdjDtController extends AbstractBaseController {

    private CreditAdjDtService creditAdjDtService;
    @Autowired
    public CreditAdjDtController(CreditAdjDtService record) {
        this.creditAdjDtService = record;
    }


    @PostMapping("/insertSelective")
    public CommonResult insertSelective(CreditAdjDt record) {
        this.creditAdjDtService.insertSelective(record);
        return result(ResultEnum.INSERT_SUCCESS);
    }


    @PostMapping("/deleteById")
    public  CommonResult deleteById( Integer billno,String  entid) {
        int i=this.creditAdjDtService.deleteById(billno,entid);
        if(i==1){
        return result(ResultEnum.DELETE_SUCCESS);
        }
        return  result(ResultEnum.DELETE_ERROR);
    }


    @PostMapping("/updateById")
    public CommonResult updateById(CreditAdjDt record) {
        int i= this.creditAdjDtService.updateById(record);
        if (i==1) {
        return result(ResultEnum.UPDATE_SUCCESS);
        }
        return  result(ResultEnum.UPDATE_ERROR);
    }


    @GetMapping("/selectById")
    public CommonResult selectById( Integer billno,String  entid) {
        return resultData(ResultEnum.SELECT_SUCCESS,this.creditAdjDtService.selectById(billno,entid));
    }


    @GetMapping("/listAll")
    public CommonResult listAll() {
        return resultData(ResultEnum.SELECT_SUCCESS,this.creditAdjDtService.list(null));
    }

    @GetMapping("/findByQuery")
    public Page<CreditAdjDt> findByQuery(CreditAdjDt record) {
        PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
        return new Page<CreditAdjDt>(this.creditAdjDtService.findByQuery(record));

    }
}

