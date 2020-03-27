package com.sygs.controller.sqlserver.kcgflxyzc;

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
import com.sygs.pojo.sqlserver.kcgflxyzc.KcgflxyzcSql;
import com.sygs.service.sqlserver.kcgflxyzc.KcgflxyzcSqlService;
/**
 * 采购返利子表
 *
 * @author gaoting
 * @date：2020-03-24 14:54:25
 */
@RestController
@RequestMapping("/kcgflxyzcsql")
public class KcgflxyzcSqlController extends AbstractBaseController {

    private KcgflxyzcSqlService kcgflxyzcSqlService;
    @Autowired
    public KcgflxyzcSqlController(KcgflxyzcSqlService record) {
        this.kcgflxyzcSqlService = record;
    }


    @PostMapping("/insertSelective")
    public CommonResult insertSelective(KcgflxyzcSql record) {
        this.kcgflxyzcSqlService.insertSelective(record);
        return result(ResultEnum.INSERT_SUCCESS);
    }


    @PostMapping("/deleteById")
    public  CommonResult deleteById( Integer billno,String  entid) {
        int i=this.kcgflxyzcSqlService.deleteById(billno,entid);
        if(i==1){
        return result(ResultEnum.DELETE_SUCCESS);
        }
        return  result(ResultEnum.DELETE_ERROR);
    }


    @PostMapping("/updateById")
    public CommonResult updateById(KcgflxyzcSql record) {
        int i= this.kcgflxyzcSqlService.updateById(record);
        if (i==1) {
        return result(ResultEnum.UPDATE_SUCCESS);
        }
        return  result(ResultEnum.UPDATE_ERROR);
    }


    @GetMapping("/selectById")
    public CommonResult selectById( Integer billno,String  entid) {
        return resultData(ResultEnum.SELECT_SUCCESS,this.kcgflxyzcSqlService.selectById(billno,entid));
    }


    @GetMapping("/listAll")
    public CommonResult listAll() {
        return resultData(ResultEnum.SELECT_SUCCESS,this.kcgflxyzcSqlService.list(null));
    }

    @GetMapping("/findByQuery")
    public Page<KcgflxyzcSql> findByQuery(KcgflxyzcSql record) {
        PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
        return new Page<KcgflxyzcSql>(this.kcgflxyzcSqlService.findByQuery(record));

    }
}

