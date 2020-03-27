package com.sygs.controller.mysql.kxsflxydt;

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
import com.sygs.pojo.mysql.kxsflxydt.Kxsflxydt;
import com.sygs.service.mysql.kxsflxydt.KxsflxydtService;
/**
 * 销售返利协议子表
 *
 * @author gaoting
 * @date：2020-03-20 16:46:59
 */
@RestController
@RequestMapping("/kxsflxydt")
public class KxsflxydtController extends AbstractBaseController {

    private KxsflxydtService kxsflxydtSqlService;
    @Autowired
    public KxsflxydtController(KxsflxydtService record) {
        this.kxsflxydtSqlService = record;
    }


    @PostMapping("/insertSelective")
    public CommonResult insertSelective(Kxsflxydt record) {
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
    public CommonResult updateById(Kxsflxydt record) {
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
    public Page<Kxsflxydt> findByQuery(Kxsflxydt record) {
        PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
        return new Page<Kxsflxydt>(this.kxsflxydtSqlService.findByQuery(record));

    }
}

