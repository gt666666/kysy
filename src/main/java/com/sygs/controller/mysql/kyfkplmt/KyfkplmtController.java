package com.sygs.controller.mysql.kyfkplmt;

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
import com.sygs.pojo.mysql.kyfkplmt.Kyfkplmt;
import com.sygs.service.mysql.kyfkplmt.KyfkplmtService;

import javax.servlet.http.HttpServletRequest;

/**
 * 预付款申请汇总单主表
 *
 * @author gaoting
 * @date：2020-03-11 11:40:03
 */
@RestController
@RequestMapping("/kyfkplmt")
public class KyfkplmtController extends AbstractBaseController {

    private KyfkplmtService kyfkplmtService;
    @Autowired
    public KyfkplmtController(KyfkplmtService record) {
        this.kyfkplmtService = record;
    }


    @GetMapping("/insertSelective")
    public String insertSelective(Integer billno, String  entid, HttpServletRequest request) {
        String jsonpcallback = request.getParameter("jsonpcallback") ;
        this.kyfkplmtService.insertSelective(billno,entid);
        return jsonpcallback + "({\"billno\":\"" + billno + "\",\"entid\":\"" + entid + "\"})";
    }


    @PostMapping("/deleteById")
    public  CommonResult deleteById( Integer billno,String  entid) {
        int i=this.kyfkplmtService.deleteById(billno,entid);
        if(i==1){
        return result(ResultEnum.DELETE_SUCCESS);
        }
        return  result(ResultEnum.DELETE_ERROR);
    }


    @PostMapping("/updateById")
    public CommonResult updateById(Kyfkplmt record) {
        int i= this.kyfkplmtService.updateById(record);
        if (i==1) {
        return result(ResultEnum.UPDATE_SUCCESS);
        }
        return  result(ResultEnum.UPDATE_ERROR);
    }


    @GetMapping("/selectById")
    public CommonResult selectById( Integer billno,String  entid) {
        return resultData(ResultEnum.SELECT_SUCCESS,this.kyfkplmtService.selectById(billno,entid));
    }


    @GetMapping("/listAll")
    public CommonResult listAll() {
        return resultData(ResultEnum.SELECT_SUCCESS,this.kyfkplmtService.list());
    }

    @GetMapping("/findByQuery")
    public Page<Kyfkplmt> findByQuery(Kyfkplmt record) {
        PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
        return new Page<Kyfkplmt>(this.kyfkplmtService.findByQuery(record));

    }
}

