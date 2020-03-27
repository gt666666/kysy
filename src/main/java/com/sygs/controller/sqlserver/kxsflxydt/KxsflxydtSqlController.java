package com.sygs.controller.sqlserver.kxsflxydt;

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
import com.sygs.pojo.sqlserver.kxsflxydt.KxsflxydtSql;
import com.sygs.service.sqlserver.kxsflxydt.KxsflxydtSqlService;
/**
 * 销售返利协议子表
 *
 * @author gaoting
 * @date：2020-03-20 16:22:28
 */
@RestController
@RequestMapping("/kxsflxydtsql")
public class KxsflxydtSqlController extends AbstractBaseController {

    private KxsflxydtSqlService kxsflxydtSqlService;
    @Autowired
    public KxsflxydtSqlController(KxsflxydtSqlService record) {
        this.kxsflxydtSqlService = record;
    }


    @PostMapping("/insertSelective")
    public CommonResult insertSelective(KxsflxydtSql record) {
        this.kxsflxydtSqlService.insertSelective(record);
        return result(ResultEnum.INSERT_SUCCESS);
    }


    @PostMapping("/deleteById")
    public  CommonResult deleteById( Integer billno,String  entid) {
        int i=this.kxsflxydtSqlService.deleteById(billno,entid);
        if(i==1){
        return result(ResultEnum.DELETE_SUCCESS);
        }
        return  result(ResultEnum.DELETE_ERROR);
    }


    @PostMapping("/updateById")
    public CommonResult updateById(KxsflxydtSql record) {
        int i= this.kxsflxydtSqlService.updateById(record);
        if (i==1) {
        return result(ResultEnum.UPDATE_SUCCESS);
        }
        return  result(ResultEnum.UPDATE_ERROR);
    }


    @GetMapping("/selectById")
    public CommonResult selectById( Integer billno,String  entid) {
        return resultData(ResultEnum.SELECT_SUCCESS,this.kxsflxydtSqlService.selectById(billno,entid));
    }


    @GetMapping("/listAll")
    public CommonResult listAll() {
        return resultData(ResultEnum.SELECT_SUCCESS,this.kxsflxydtSqlService.list(null));
    }

    @GetMapping("/findByQuery")
    public Page<KxsflxydtSql> findByQuery(KxsflxydtSql record) {
        PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
        return new Page<KxsflxydtSql>(this.kxsflxydtSqlService.findByQuery(record));

    }
}

