package com.sygs.controller.sqlserver.kcgflxymt;

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
import com.sygs.pojo.sqlserver.kcgflxymt.KcgflxymtSql;
import com.sygs.service.sqlserver.kcgflxymt.KcgflxymtSqlService;
/**
 * 采购返利主表
 *
 * @author gaoting
 * @date：2020-03-23 10:23:00
 */
@RestController
@RequestMapping("/kcgflxymtsql")
public class KcgflxymtSqlController extends AbstractBaseController {

    private KcgflxymtSqlService kcgflxymtSqlService;
    @Autowired
    public KcgflxymtSqlController(KcgflxymtSqlService record) {
        this.kcgflxymtSqlService = record;
    }


    @PostMapping("/insertSelective")
    public CommonResult insertSelective(KcgflxymtSql record) {
        this.kcgflxymtSqlService.insertSelective(record);
        return result(ResultEnum.INSERT_SUCCESS);
    }


    @PostMapping("/deleteById")
    public  CommonResult deleteById( Integer billno,String  entid) {
        int i=this.kcgflxymtSqlService.deleteById(billno,entid);
        if(i==1){
        return result(ResultEnum.DELETE_SUCCESS);
        }
        return  result(ResultEnum.DELETE_ERROR);
    }


    @PostMapping("/updateById")
    public CommonResult updateById(KcgflxymtSql record) {
        int i= this.kcgflxymtSqlService.updateById(record);
        if (i==1) {
        return result(ResultEnum.UPDATE_SUCCESS);
        }
        return  result(ResultEnum.UPDATE_ERROR);
    }


    @GetMapping("/selectById")
    public CommonResult selectById( Integer billno,String  entid) {
        return resultData(ResultEnum.SELECT_SUCCESS,this.kcgflxymtSqlService.selectById(billno,entid));
    }


    @GetMapping("/listAll")
    public CommonResult listAll() {
        return resultData(ResultEnum.SELECT_SUCCESS,this.kcgflxymtSqlService.list(null));
    }

    @GetMapping("/findByQuery")
    public Page<KcgflxymtSql> findByQuery(KcgflxymtSql record) {
        PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
        return new Page<KcgflxymtSql>(this.kcgflxymtSqlService.findByQuery(record));

    }
}

