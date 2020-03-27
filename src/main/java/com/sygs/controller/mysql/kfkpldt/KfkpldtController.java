package com.sygs.controller.mysql.kfkpldt;

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
import com.sygs.pojo.mysql.kfkpldt.Kfkpldt;
import com.sygs.service.mysql.kfkpldt.KfkpldtService;
/**
 * 正常付款批量子表
 *
 * @author gaoting
 * @date：2020-03-20 13:55:23
 */
@RestController
@RequestMapping("/kfkpldt")
public class KfkpldtController extends AbstractBaseController {

    private KfkpldtService kfkpldtService;
    @Autowired
    public KfkpldtController(KfkpldtService record) {
        this.kfkpldtService = record;
    }


    @PostMapping("/insertSelective")
    public CommonResult insertSelective(Kfkpldt record) {
        this.kfkpldtService.insertSelective(record);
        return result(ResultEnum.INSERT_SUCCESS);
    }


    @PostMapping("/deleteById")
    public  CommonResult deleteById( Integer billno,String  entid) {
        int i=this.kfkpldtService.deleteById(billno,entid);
        if(i==1){
        return result(ResultEnum.DELETE_SUCCESS);
        }
        return  result(ResultEnum.DELETE_ERROR);
    }


    @PostMapping("/updateById")
    public CommonResult updateById(Kfkpldt record) {
        int i= this.kfkpldtService.updateById(record);
        if (i==1) {
        return result(ResultEnum.UPDATE_SUCCESS);
        }
        return  result(ResultEnum.UPDATE_ERROR);
    }


    @GetMapping("/selectById")
    public CommonResult selectById( Integer billno,String  entid) {
        return resultData(ResultEnum.SELECT_SUCCESS,this.kfkpldtService.selectById(billno,entid));
    }


    @GetMapping("/listAll")
    public CommonResult listAll() {
        return resultData(ResultEnum.SELECT_SUCCESS,this.kfkpldtService.list(null));
    }

    @GetMapping("/findByQuery")
    public Page<Kfkpldt> findByQuery(Kfkpldt record) {
        PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
        return new Page<Kfkpldt>(this.kfkpldtService.findByQuery(record));

    }
}

