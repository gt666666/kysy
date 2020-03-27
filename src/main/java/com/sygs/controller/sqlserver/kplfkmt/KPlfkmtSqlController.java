package com.sygs.controller.sqlserver.kplfkmt;

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
import com.sygs.pojo.sqlserver.kplfkmt.KPlfkmtSql;
import com.sygs.service.sqlserver.kplfkmt.KPlfkmtSqlService;
/**
 * 正常付款批量主表
 *
 * @author gaoting
 * @date：2020-03-20 13:42:47
 */
@RestController
@RequestMapping("/kplfkmtsql")
public class KPlfkmtSqlController extends AbstractBaseController {

    private KPlfkmtSqlService kPlfkmtSqlService;
    @Autowired
    public KPlfkmtSqlController(KPlfkmtSqlService record) {
        this.kPlfkmtSqlService = record;
    }


    @PostMapping("/insertSelective")
    public CommonResult insertSelective(KPlfkmtSql record) {
        this.kPlfkmtSqlService.insertSelective(record);
        return result(ResultEnum.INSERT_SUCCESS);
    }


    @PostMapping("/deleteById")
    public  CommonResult deleteById( Integer billno,String  entid) {
        int i=this.kPlfkmtSqlService.deleteById(billno,entid);
        if(i==1){
        return result(ResultEnum.DELETE_SUCCESS);
        }
        return  result(ResultEnum.DELETE_ERROR);
    }


    @PostMapping("/updateById")
    public CommonResult updateById(KPlfkmtSql record) {
        int i= this.kPlfkmtSqlService.updateById(record);
        if (i==1) {
        return result(ResultEnum.UPDATE_SUCCESS);
        }
        return  result(ResultEnum.UPDATE_ERROR);
    }


    @GetMapping("/selectById")
    public CommonResult selectById( Integer billno,String  entid) {
        return resultData(ResultEnum.SELECT_SUCCESS,this.kPlfkmtSqlService.selectById(billno,entid));
    }


    @GetMapping("/listAll")
    public CommonResult listAll() {
        return resultData(ResultEnum.SELECT_SUCCESS,this.kPlfkmtSqlService.list(null));
    }

    @GetMapping("/findByQuery")
    public Page<KPlfkmtSql> findByQuery(KPlfkmtSql record) {
        PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
        return new Page<KPlfkmtSql>(this.kPlfkmtSqlService.findByQuery(record));

    }
}

