package com.sygs.controller.mysql.kyfkpldt;

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
import com.sygs.pojo.mysql.kyfkpldt.Kyfkpldt;
import com.sygs.service.mysql.kyfkpldt.KyfkpldtService;
/**
 * 预付款申请汇总单子表
 *
 * @author gaoting
 * @date：2020-03-11 13:04:07
 */
@RestController
@RequestMapping("/kyfkpldt")
public class KyfkpldtController extends AbstractBaseController {

    private KyfkpldtService kyfkpldtService;
    @Autowired
    public KyfkpldtController(KyfkpldtService record) {
        this.kyfkpldtService = record;
    }


    @PostMapping("/insertSelective")
    public CommonResult insertSelective(Kyfkpldt record) {
        this.kyfkpldtService.insertSelective(record);
        return result(ResultEnum.INSERT_SUCCESS);
    }


    @PostMapping("/deleteById")
    public  CommonResult deleteById( Integer billno,String  entid) {
        int i=this.kyfkpldtService.deleteById(billno,entid);
        if(i==1){
        return result(ResultEnum.DELETE_SUCCESS);
        }
        return  result(ResultEnum.DELETE_ERROR);
    }


    @PostMapping("/updateById")
    public CommonResult updateById(Kyfkpldt record) {
        int i= this.kyfkpldtService.updateById(record);
        if (i==1) {
        return result(ResultEnum.UPDATE_SUCCESS);
        }
        return  result(ResultEnum.UPDATE_ERROR);
    }


    @GetMapping("/selectById")
    public CommonResult selectById( Integer billno,String  entid) {
        return resultData(ResultEnum.SELECT_SUCCESS,this.kyfkpldtService.selectById(billno,entid));
    }


    @GetMapping("/listAll")
    public CommonResult listAll() {
        return resultData(ResultEnum.SELECT_SUCCESS,this.kyfkpldtService.list(null));
    }

    @GetMapping("/findByQuery")
    public Page<Kyfkpldt> findByQuery(Kyfkpldt record) {
        PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
        return new Page<Kyfkpldt>(this.kyfkpldtService.findByQuery(record));

    }
}

