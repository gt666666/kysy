package com.sygs.controller.mysql.kcgflxyqd;

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
import com.sygs.pojo.mysql.kcgflxyqd.Kcgflxyqd;
import com.sygs.service.mysql.kcgflxyqd.KcgflxyqdService;
/**
 * 采购返利子表
 *
 * @author gaoting
 * @date：2020-03-24 14:11:35
 */
@RestController
@RequestMapping("/kcgflxyqd")
public class KcgflxyqdController extends AbstractBaseController {

    private KcgflxyqdService kcgflxyqdService;
    @Autowired
    public KcgflxyqdController(KcgflxyqdService record) {
        this.kcgflxyqdService = record;
    }


    @PostMapping("/insertSelective")
    public CommonResult insertSelective(Kcgflxyqd record) {
        this.kcgflxyqdService.insertSelective(record);
        return result(ResultEnum.INSERT_SUCCESS);
    }


    @PostMapping("/deleteById")
    public  CommonResult deleteById( Integer billno,String  entid) {
        int i=this.kcgflxyqdService.deleteById(billno,entid);
        if(i==1){
        return result(ResultEnum.DELETE_SUCCESS);
        }
        return  result(ResultEnum.DELETE_ERROR);
    }


    @PostMapping("/updateById")
    public CommonResult updateById(Kcgflxyqd record) {
        int i= this.kcgflxyqdService.updateById(record);
        if (i==1) {
        return result(ResultEnum.UPDATE_SUCCESS);
        }
        return  result(ResultEnum.UPDATE_ERROR);
    }


    @GetMapping("/selectById")
    public CommonResult selectById( Integer billno,String  entid) {
        return resultData(ResultEnum.SELECT_SUCCESS,this.kcgflxyqdService.selectById(billno,entid));
    }


    @GetMapping("/listAll")
    public CommonResult listAll() {
        return resultData(ResultEnum.SELECT_SUCCESS,this.kcgflxyqdService.list(null));
    }

    @GetMapping("/findByQuery")
    public Page<Kcgflxyqd> findByQuery(Kcgflxyqd record) {
        PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
        return new Page<Kcgflxyqd>(this.kcgflxyqdService.findByQuery(record));

    }
}

