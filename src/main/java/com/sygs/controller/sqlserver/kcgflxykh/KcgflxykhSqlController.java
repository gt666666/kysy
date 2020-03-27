package com.sygs.controller.sqlserver.kcgflxykh;

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
import com.sygs.pojo.sqlserver.kcgflxykh.KcgflxykhSql;
import com.sygs.service.sqlserver.kcgflxykh.KcgflxykhSqlService;
/**
 * 采购返利子表
 *
 * @author gaoting
 * @date：2020-03-23 11:07:18
 */
@RestController
@RequestMapping("/kcgflxykhsql")
public class KcgflxykhSqlController extends AbstractBaseController {

    private KcgflxykhSqlService kcgflxykhSqlService;
    @Autowired
    public KcgflxykhSqlController(KcgflxykhSqlService record) {
        this.kcgflxykhSqlService = record;
    }


    @PostMapping("/insertSelective")
    public CommonResult insertSelective(KcgflxykhSql record) {
        this.kcgflxykhSqlService.insertSelective(record);
        return result(ResultEnum.INSERT_SUCCESS);
    }


    @PostMapping("/deleteById")
    public  CommonResult deleteById( Integer billno,String  entid) {
        int i=this.kcgflxykhSqlService.deleteById(billno,entid);
        if(i==1){
        return result(ResultEnum.DELETE_SUCCESS);
        }
        return  result(ResultEnum.DELETE_ERROR);
    }


    @PostMapping("/updateById")
    public CommonResult updateById(KcgflxykhSql record) {
        int i= this.kcgflxykhSqlService.updateById(record);
        if (i==1) {
        return result(ResultEnum.UPDATE_SUCCESS);
        }
        return  result(ResultEnum.UPDATE_ERROR);
    }


    @GetMapping("/selectById")
    public CommonResult selectById( Integer billno,String  entid) {
        return resultData(ResultEnum.SELECT_SUCCESS,this.kcgflxykhSqlService.selectById(billno,entid));
    }


    @GetMapping("/listAll")
    public CommonResult listAll() {
        return resultData(ResultEnum.SELECT_SUCCESS,this.kcgflxykhSqlService.list(null));
    }

    @GetMapping("/findByQuery")
    public Page<KcgflxykhSql> findByQuery(KcgflxykhSql record) {
        PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
        return new Page<KcgflxykhSql>(this.kcgflxykhSqlService.findByQuery(record));

    }
}

