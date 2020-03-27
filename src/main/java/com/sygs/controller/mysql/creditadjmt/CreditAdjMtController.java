package com.sygs.controller.mysql.creditadjmt;

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
import com.sygs.pojo.mysql.creditadjmt.CreditAdjMt;
import com.sygs.service.mysql.creditadjmt.CreditAdjMtService;

import javax.servlet.http.HttpServletRequest;

/**
 * 信贷申请主表
 *
 * @author gaoting
 * @date：2020-03-13 09:47:29
 */
@RestController
@RequestMapping("/creditadjmt")
public class CreditAdjMtController extends AbstractBaseController {

    private CreditAdjMtService creditAdjMtService;
    @Autowired
    public CreditAdjMtController(CreditAdjMtService record) {
        this.creditAdjMtService = record;
    }


    @PostMapping("/insertSelective")
    public String insertSelective(Integer billno, String  entid, HttpServletRequest request) {
        String jsonpcallback = request.getParameter("jsonpcallback") ;
        this.creditAdjMtService.insertSelective(billno,entid);
        return jsonpcallback + "({\"billno\":\"" + billno + "\",\"entid\":\"" + entid + "\"})";
    }


    @PostMapping("/deleteById")
    public  CommonResult deleteById( Integer billno,String  entid) {
        int i=this.creditAdjMtService.deleteById(billno,entid);
        if(i==1){
        return result(ResultEnum.DELETE_SUCCESS);
        }
        return  result(ResultEnum.DELETE_ERROR);
    }


    @PostMapping("/updateById")
    public CommonResult updateById(CreditAdjMt record) {
        int i= this.creditAdjMtService.updateById(record);
        if (i==1) {
        return result(ResultEnum.UPDATE_SUCCESS);
        }
        return  result(ResultEnum.UPDATE_ERROR);
    }


    @GetMapping("/selectById")
    public CommonResult selectById( Integer billno,String  entid) {
        return resultData(ResultEnum.SELECT_SUCCESS,this.creditAdjMtService.selectById(billno,entid));
    }


    @GetMapping("/listAll")
    public CommonResult listAll() {
        return resultData(ResultEnum.SELECT_SUCCESS,this.creditAdjMtService.list());
    }

    @GetMapping("/findByQuery")
    public Page<CreditAdjMt> findByQuery(CreditAdjMt record) {
        PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
        return new Page<CreditAdjMt>(this.creditAdjMtService.findByQuery(record));

    }
}

