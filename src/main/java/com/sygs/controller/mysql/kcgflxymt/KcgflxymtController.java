package com.sygs.controller.mysql.kcgflxymt;

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
import com.sygs.pojo.mysql.kcgflxymt.Kcgflxymt;
import com.sygs.service.mysql.kcgflxymt.KcgflxymtService;
/**
 * 采购返利主表
 *
 * @author gaoting
 * @date：2020-03-23 10:15:07
 */
@RestController
@RequestMapping("/kcgflxymt")
public class KcgflxymtController extends AbstractBaseController {

    private KcgflxymtService kcgflxymtService;
    @Autowired
    public KcgflxymtController(KcgflxymtService record) {
        this.kcgflxymtService = record;
    }


    @PostMapping("/insertSelective")
    public CommonResult insertSelective(Kcgflxymt record) {
        this.kcgflxymtService.insertSelective(record);
        return result(ResultEnum.INSERT_SUCCESS);
    }


    @PostMapping("/deleteById")
    public  CommonResult deleteById( Integer billno,String  entid) {
        int i=this.kcgflxymtService.deleteById(billno,entid);
        if(i==1){
        return result(ResultEnum.DELETE_SUCCESS);
        }
        return  result(ResultEnum.DELETE_ERROR);
    }


    @PostMapping("/updateById")
    public CommonResult updateById(Kcgflxymt record) {
        int i= this.kcgflxymtService.updateById(record);
        if (i==1) {
        return result(ResultEnum.UPDATE_SUCCESS);
        }
        return  result(ResultEnum.UPDATE_ERROR);
    }


    @GetMapping("/selectById")
    public CommonResult selectById( Integer billno,String  entid) {
        return resultData(ResultEnum.SELECT_SUCCESS,this.kcgflxymtService.selectById(billno,entid));
    }


    @GetMapping("/listAll")
    public CommonResult listAll() {
        return resultData(ResultEnum.SELECT_SUCCESS,this.kcgflxymtService.list(null));
    }

    @GetMapping("/findByQuery")
    public Page<Kcgflxymt> findByQuery(Kcgflxymt record) {
        PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
        return new Page<Kcgflxymt>(this.kcgflxymtService.findByQuery(record));

    }
}

