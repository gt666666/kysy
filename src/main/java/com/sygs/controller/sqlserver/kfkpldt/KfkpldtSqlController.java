package com.sygs.controller.sqlserver.kfkpldt;

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
import com.sygs.pojo.sqlserver.kfkpldt.KfkpldtSql;
import com.sygs.service.sqlserver.kfkpldt.KfkpldtSqlService;
/**
 * 正常付款批量子表
 *
 * @author gaoting
 * @date：2020-03-20 13:48:56
 */
@RestController
@RequestMapping("/kfkpldtsql")
public class KfkpldtSqlController extends AbstractBaseController {

    private KfkpldtSqlService kfkpldtSqlService;
    @Autowired
    public KfkpldtSqlController(KfkpldtSqlService record) {
        this.kfkpldtSqlService = record;
    }


    @PostMapping("/insertSelective")
    public CommonResult insertSelective(KfkpldtSql record) {
        this.kfkpldtSqlService.insertSelective(record);
        return result(ResultEnum.INSERT_SUCCESS);
    }


    @PostMapping("/deleteById")
    public  CommonResult deleteById( Integer billno,String  entid) {
        int i=this.kfkpldtSqlService.deleteById(billno,entid);
        if(i==1){
        return result(ResultEnum.DELETE_SUCCESS);
        }
        return  result(ResultEnum.DELETE_ERROR);
    }


    @PostMapping("/updateById")
    public CommonResult updateById(KfkpldtSql record) {
        int i= this.kfkpldtSqlService.updateById(record);
        if (i==1) {
        return result(ResultEnum.UPDATE_SUCCESS);
        }
        return  result(ResultEnum.UPDATE_ERROR);
    }


    @GetMapping("/selectById")
    public CommonResult selectById( Integer billno,String  entid) {
        return resultData(ResultEnum.SELECT_SUCCESS,this.kfkpldtSqlService.selectById(billno,entid));
    }


    @GetMapping("/listAll")
    public CommonResult listAll() {
        return resultData(ResultEnum.SELECT_SUCCESS,this.kfkpldtSqlService.list(null));
    }

    @GetMapping("/findByQuery")
    public Page<KfkpldtSql> findByQuery(KfkpldtSql record) {
        PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
        return new Page<KfkpldtSql>(this.kfkpldtSqlService.findByQuery(record));

    }
}

