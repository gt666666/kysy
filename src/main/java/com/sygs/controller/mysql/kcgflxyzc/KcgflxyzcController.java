package com.sygs.controller.mysql.kcgflxyzc;

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
import com.sygs.pojo.mysql.kcgflxyzc.Kcgflxyzc;
import com.sygs.service.mysql.kcgflxyzc.KcgflxyzcService;
/**
 * 采购返利子表
 *
 * @author gaoting
 * @date：2020-03-24 14:17:40
 */
@RestController
@RequestMapping("/kcgflxyzc")
public class KcgflxyzcController extends AbstractBaseController {

    private KcgflxyzcService kcgflxyzcService;
    @Autowired
    public KcgflxyzcController(KcgflxyzcService record) {
        this.kcgflxyzcService = record;
    }


    @PostMapping("/insertSelective")
    public CommonResult insertSelective(Kcgflxyzc record) {
        this.kcgflxyzcService.insertSelective(record);
        return result(ResultEnum.INSERT_SUCCESS);
    }


    @PostMapping("/deleteById")
    public  CommonResult deleteById( Integer billno,String  entid) {
        int i=this.kcgflxyzcService.deleteById(billno,entid);
        if(i==1){
        return result(ResultEnum.DELETE_SUCCESS);
        }
        return  result(ResultEnum.DELETE_ERROR);
    }


    @PostMapping("/updateById")
    public CommonResult updateById(Kcgflxyzc record) {
        int i= this.kcgflxyzcService.updateById(record);
        if (i==1) {
        return result(ResultEnum.UPDATE_SUCCESS);
        }
        return  result(ResultEnum.UPDATE_ERROR);
    }


    @GetMapping("/selectById")
    public CommonResult selectById( Integer billno,String  entid) {
        return resultData(ResultEnum.SELECT_SUCCESS,this.kcgflxyzcService.selectById(billno,entid));
    }


    @GetMapping("/listAll")
    public CommonResult listAll() {
        return resultData(ResultEnum.SELECT_SUCCESS,this.kcgflxyzcService.list(null));
    }

    @GetMapping("/findByQuery")
    public Page<Kcgflxyzc> findByQuery(Kcgflxyzc record) {
        PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
        return new Page<Kcgflxyzc>(this.kcgflxyzcService.findByQuery(record));

    }
}

