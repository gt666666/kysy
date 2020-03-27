package com.sygs.controller.sqlserver.kxsflxymt;

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
import com.sygs.pojo.sqlserver.kxsflxymt.KxsflxymtSql;
import com.sygs.service.sqlserver.kxsflxymt.KxsflxymtSqlService;
/**
 * 销售返利协议主表
 *
 * @author gaoting
 * @date：2020-03-20 15:48:22
 */
@RestController
@RequestMapping("/kxsflxymtsql")
public class KxsflxymtSqlController extends AbstractBaseController {

    private KxsflxymtSqlService kxsflxymtSqlService;
    @Autowired
    public KxsflxymtSqlController(KxsflxymtSqlService record) {
        this.kxsflxymtSqlService = record;
    }


    @PostMapping("/insertSelective")
    public CommonResult insertSelective(KxsflxymtSql record) {
        this.kxsflxymtSqlService.insertSelective(record);
        return result(ResultEnum.INSERT_SUCCESS);
    }


    @PostMapping("/deleteById")
    public  CommonResult deleteById( Integer billno,String  entid) {
        int i=this.kxsflxymtSqlService.deleteById(billno,entid);
        if(i==1){
        return result(ResultEnum.DELETE_SUCCESS);
        }
        return  result(ResultEnum.DELETE_ERROR);
    }


    @PostMapping("/updateById")
    public CommonResult updateById(KxsflxymtSql record) {
        int i= this.kxsflxymtSqlService.updateById(record);
        if (i==1) {
        return result(ResultEnum.UPDATE_SUCCESS);
        }
        return  result(ResultEnum.UPDATE_ERROR);
    }


    @GetMapping("/selectById")
    public CommonResult selectById( Integer billno,String  entid) {
        return resultData(ResultEnum.SELECT_SUCCESS,this.kxsflxymtSqlService.selectById(billno,entid));
    }


    @GetMapping("/listAll")
    public CommonResult listAll() {
        return resultData(ResultEnum.SELECT_SUCCESS,this.kxsflxymtSqlService.list(null));
    }

    @GetMapping("/findByQuery")
    public Page<KxsflxymtSql> findByQuery(KxsflxymtSql record) {
        PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
        return new Page<KxsflxymtSql>(this.kxsflxymtSqlService.findByQuery(record));

    }
}

