package com.sygs.controller.mysql.kcgflxykh;

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
import com.sygs.pojo.mysql.kcgflxykh.Kcgflxykh;
import com.sygs.service.mysql.kcgflxykh.KcgflxykhService;
/**
 * 采购返利子表
 *
 * @author gaoting
 * @date：2020-03-23 11:01:59
 */
@RestController
@RequestMapping("/kcgflxykh")
public class KcgflxykhController extends AbstractBaseController {

    private KcgflxykhService kcgflxykhService;
    @Autowired
    public KcgflxykhController(KcgflxykhService record) {
        this.kcgflxykhService = record;
    }


    @PostMapping("/insertSelective")
    public CommonResult insertSelective(Kcgflxykh record) {
        this.kcgflxykhService.insertSelective(record);
        return result(ResultEnum.INSERT_SUCCESS);
    }


    @PostMapping("/deleteById")
    public  CommonResult deleteById( Integer billno,String  entid) {
        int i=this.kcgflxykhService.deleteById(billno,entid);
        if(i==1){
        return result(ResultEnum.DELETE_SUCCESS);
        }
        return  result(ResultEnum.DELETE_ERROR);
    }


    @PostMapping("/updateById")
    public CommonResult updateById(Kcgflxykh record) {
        int i= this.kcgflxykhService.updateById(record);
        if (i==1) {
        return result(ResultEnum.UPDATE_SUCCESS);
        }
        return  result(ResultEnum.UPDATE_ERROR);
    }


    @GetMapping("/selectById")
    public CommonResult selectById( Integer billno,String  entid) {
        return resultData(ResultEnum.SELECT_SUCCESS,this.kcgflxykhService.selectById(billno,entid));
    }


    @GetMapping("/listAll")
    public CommonResult listAll() {
        return resultData(ResultEnum.SELECT_SUCCESS,this.kcgflxykhService.list(null));
    }

    @GetMapping("/findByQuery")
    public Page<Kcgflxykh> findByQuery(Kcgflxykh record) {
        PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
        return new Page<Kcgflxykh>(this.kcgflxykhService.findByQuery(record));

    }
}

