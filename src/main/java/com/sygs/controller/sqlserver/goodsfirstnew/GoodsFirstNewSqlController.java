package com.sygs.controller.sqlserver.goodsfirstnew;

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
import com.sygs.pojo.sqlserver.goodsfirstnew.GoodsFirstNewSql;
import com.sygs.service.sqlserver.goodsfirstnew.GoodsFirstNewSqlService;
/**
 * 首营商品
 *
 * @author gaoting
 * @date：2020-03-23 09:32:44
 */
@RestController
@RequestMapping("/goodsfirstnewsql")
public class GoodsFirstNewSqlController extends AbstractBaseController {

    private GoodsFirstNewSqlService goodsFirstNewSqlService;
    @Autowired
    public GoodsFirstNewSqlController(GoodsFirstNewSqlService record) {
        this.goodsFirstNewSqlService = record;
    }


    @PostMapping("/insertSelective")
    public CommonResult insertSelective(GoodsFirstNewSql record) {
        this.goodsFirstNewSqlService.insertSelective(record);
        return result(ResultEnum.INSERT_SUCCESS);
    }


    @PostMapping("/deleteById")
    public  CommonResult deleteById( Integer billno,String  entid) {
        int i=this.goodsFirstNewSqlService.deleteById(billno,entid);
        if(i==1){
        return result(ResultEnum.DELETE_SUCCESS);
        }
        return  result(ResultEnum.DELETE_ERROR);
    }


    @PostMapping("/updateById")
    public CommonResult updateById(GoodsFirstNewSql record) {
        int i= this.goodsFirstNewSqlService.updateById(record);
        if (i==1) {
        return result(ResultEnum.UPDATE_SUCCESS);
        }
        return  result(ResultEnum.UPDATE_ERROR);
    }


    @GetMapping("/selectById")
    public CommonResult selectById( Integer billno,String  entid) {
        return resultData(ResultEnum.SELECT_SUCCESS,this.goodsFirstNewSqlService.selectById(billno,entid));
    }


    @GetMapping("/listAll")
    public CommonResult listAll() {
        return resultData(ResultEnum.SELECT_SUCCESS,this.goodsFirstNewSqlService.list(null));
    }

    @GetMapping("/findByQuery")
    public Page<GoodsFirstNewSql> findByQuery(GoodsFirstNewSql record) {
        PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
        return new Page<GoodsFirstNewSql>(this.goodsFirstNewSqlService.findByQuery(record));

    }
}

