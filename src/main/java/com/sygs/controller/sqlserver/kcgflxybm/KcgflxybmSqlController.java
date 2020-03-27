package com.sygs.controller.sqlserver.kcgflxybm;

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
import com.sygs.pojo.sqlserver.kcgflxybm.KcgflxybmSql;
import com.sygs.service.sqlserver.kcgflxybm.KcgflxybmSqlService;
/**
 * 采购返利子表
 *
 * @author gaoting
 * @date：2020-03-23 10:40:34
 */
@RestController
@RequestMapping("/kcgflxybmsql")
public class KcgflxybmSqlController extends AbstractBaseController {

    private KcgflxybmSqlService kcgflxybmSqlService;
    @Autowired
    public KcgflxybmSqlController(KcgflxybmSqlService record) {
        this.kcgflxybmSqlService = record;
    }


    @PostMapping("/insertSelective")
    public CommonResult insertSelective(KcgflxybmSql record) {
        this.kcgflxybmSqlService.insertSelective(record);
        return result(ResultEnum.INSERT_SUCCESS);
    }


    @PostMapping("/deleteById")
    public  CommonResult deleteById( Integer billno,String  entid) {
        int i=this.kcgflxybmSqlService.deleteById(billno,entid);
        if(i==1){
        return result(ResultEnum.DELETE_SUCCESS);
        }
        return  result(ResultEnum.DELETE_ERROR);
    }


    @PostMapping("/updateById")
    public CommonResult updateById(KcgflxybmSql record) {
        int i= this.kcgflxybmSqlService.updateById(record);
        if (i==1) {
        return result(ResultEnum.UPDATE_SUCCESS);
        }
        return  result(ResultEnum.UPDATE_ERROR);
    }


    @GetMapping("/selectById")
    public CommonResult selectById( Integer billno,String  entid) {
        return resultData(ResultEnum.SELECT_SUCCESS,this.kcgflxybmSqlService.selectById(billno,entid));
    }


    @GetMapping("/listAll")
    public CommonResult listAll() {
        return resultData(ResultEnum.SELECT_SUCCESS,this.kcgflxybmSqlService.list(null));
    }

    @GetMapping("/findByQuery")
    public Page<KcgflxybmSql> findByQuery(KcgflxybmSql record) {
        PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
        return new Page<KcgflxybmSql>(this.kcgflxybmSqlService.findByQuery(record));

    }
}

