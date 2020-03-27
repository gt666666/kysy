package com.sygs.controller.mysql.kcgflxybm;

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
import com.sygs.pojo.mysql.kcgflxybm.Kcgflxybm;
import com.sygs.service.mysql.kcgflxybm.KcgflxybmService;
/**
 * 采购返利子表
 *
 * @author gaoting
 * @date：2020-03-23 10:50:32
 */
@RestController
@RequestMapping("/kcgflxybm")
public class KcgflxybmController extends AbstractBaseController {

    private KcgflxybmService kcgflxybmService;
    @Autowired
    public KcgflxybmController(KcgflxybmService record) {
        this.kcgflxybmService = record;
    }


    @PostMapping("/insertSelective")
    public CommonResult insertSelective(Kcgflxybm record) {
        this.kcgflxybmService.insertSelective(record);
        return result(ResultEnum.INSERT_SUCCESS);
    }


    @PostMapping("/deleteById")
    public  CommonResult deleteById( Integer billno,String  entid) {
        int i=this.kcgflxybmService.deleteById(billno,entid);
        if(i==1){
        return result(ResultEnum.DELETE_SUCCESS);
        }
        return  result(ResultEnum.DELETE_ERROR);
    }


    @PostMapping("/updateById")
    public CommonResult updateById(Kcgflxybm record) {
        int i= this.kcgflxybmService.updateById(record);
        if (i==1) {
        return result(ResultEnum.UPDATE_SUCCESS);
        }
        return  result(ResultEnum.UPDATE_ERROR);
    }


    @GetMapping("/selectById")
    public CommonResult selectById( Integer billno,String  entid) {
        return resultData(ResultEnum.SELECT_SUCCESS,this.kcgflxybmService.selectById(billno,entid));
    }


    @GetMapping("/listAll")
    public CommonResult listAll() {
        return resultData(ResultEnum.SELECT_SUCCESS,this.kcgflxybmService.list(null));
    }

    @GetMapping("/findByQuery")
    public Page<Kcgflxybm> findByQuery(Kcgflxybm record) {
        PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
        return new Page<Kcgflxybm>(this.kcgflxybmService.findByQuery(record));

    }
}

