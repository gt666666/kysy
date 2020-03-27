package com.sygs.controller.sqlserver.kndxy;

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
import com.sygs.pojo.sqlserver.kndxy.KndxySql;
import com.sygs.service.sqlserver.kndxy.KndxySqlService;
/**
 * 销售年度协议
 *
 * @author gaoting
 * @date：2020-03-23 08:59:20
 */
@RestController
@RequestMapping("/kndxysql")
public class KndxySqlController extends AbstractBaseController {

    private KndxySqlService kndxySqlService;
    @Autowired
    public KndxySqlController(KndxySqlService record) {
        this.kndxySqlService = record;
    }


    @PostMapping("/insertSelective")
    public CommonResult insertSelective(KndxySql record) {
        this.kndxySqlService.insertSelective(record);
        return result(ResultEnum.INSERT_SUCCESS);
    }


    @PostMapping("/deleteById")
    public  CommonResult deleteById( Integer billno,String  entid) {
        int i=this.kndxySqlService.deleteById(billno,entid);
        if(i==1){
        return result(ResultEnum.DELETE_SUCCESS);
        }
        return  result(ResultEnum.DELETE_ERROR);
    }


    @PostMapping("/updateById")
    public CommonResult updateById(KndxySql record) {
        int i= this.kndxySqlService.updateById(record);
        if (i==1) {
        return result(ResultEnum.UPDATE_SUCCESS);
        }
        return  result(ResultEnum.UPDATE_ERROR);
    }


    @GetMapping("/selectById")
    public CommonResult selectById( Integer billno,String  entid) {
        return resultData(ResultEnum.SELECT_SUCCESS,this.kndxySqlService.selectById(billno,entid));
    }


    @GetMapping("/listAll")
    public CommonResult listAll() {
        return resultData(ResultEnum.SELECT_SUCCESS,this.kndxySqlService.list(null));
    }

    @GetMapping("/findByQuery")
    public Page<KndxySql> findByQuery(KndxySql record) {
        PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
        return new Page<KndxySql>(this.kndxySqlService.findByQuery(record));

    }
}

