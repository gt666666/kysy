package com.sygs.controller.sqlserver.kcgflxyqd;

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
import com.sygs.pojo.sqlserver.kcgflxyqd.KcgflxyqdSql;
import com.sygs.service.sqlserver.kcgflxyqd.KcgflxyqdSqlService;
/**
 * 采购返利子表
 *
 * @author gaoting
 * @date：2020-03-24 14:02:52
 */
@RestController
@RequestMapping("/kcgflxyqdsql")
public class KcgflxyqdSqlController extends AbstractBaseController {

    private KcgflxyqdSqlService kcgflxyqdSqlService;
    @Autowired
    public KcgflxyqdSqlController(KcgflxyqdSqlService record) {
        this.kcgflxyqdSqlService = record;
    }


    @PostMapping("/insertSelective")
    public CommonResult insertSelective(KcgflxyqdSql record) {
        this.kcgflxyqdSqlService.insertSelective(record);
        return result(ResultEnum.INSERT_SUCCESS);
    }


    @PostMapping("/deleteById")
    public  CommonResult deleteById( Integer billno,String  entid) {
        int i=this.kcgflxyqdSqlService.deleteById(billno,entid);
        if(i==1){
        return result(ResultEnum.DELETE_SUCCESS);
        }
        return  result(ResultEnum.DELETE_ERROR);
    }


    @PostMapping("/updateById")
    public CommonResult updateById(KcgflxyqdSql record) {
        int i= this.kcgflxyqdSqlService.updateById(record);
        if (i==1) {
        return result(ResultEnum.UPDATE_SUCCESS);
        }
        return  result(ResultEnum.UPDATE_ERROR);
    }


    @GetMapping("/selectById")
    public CommonResult selectById( Integer billno,String  entid) {
        return resultData(ResultEnum.SELECT_SUCCESS,this.kcgflxyqdSqlService.selectById(billno,entid));
    }


    @GetMapping("/listAll")
    public CommonResult listAll() {
        return resultData(ResultEnum.SELECT_SUCCESS,this.kcgflxyqdSqlService.list(null));
    }

    @GetMapping("/findByQuery")
    public Page<KcgflxyqdSql> findByQuery(KcgflxyqdSql record) {
        PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
        return new Page<KcgflxyqdSql>(this.kcgflxyqdSqlService.findByQuery(record));

    }
}

