package com.sygs.controller.mysql.goodsfirstnew;

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
import com.sygs.pojo.mysql.goodsfirstnew.GoodsFirstNew;
import com.sygs.service.mysql.goodsfirstnew.GoodsFirstNewService;

import javax.servlet.http.HttpServletRequest;

/**
 * 首营商品
 *
 * @author gaoting
 * @date：2020-03-23 09:36:01
 */
@RestController
@RequestMapping("/goodsfirstnew")
public class GoodsFirstNewController extends AbstractBaseController {

    private GoodsFirstNewService goodsFirstNewService;
    @Autowired
    public GoodsFirstNewController(GoodsFirstNewService record) {
        this.goodsFirstNewService = record;
    }


    @PostMapping("/insertSelective")
    public String insertSelective(Integer billno, String  entid, HttpServletRequest request) {
        String jsonpcallback = request.getParameter("jsonpcallback") ;
        this.goodsFirstNewService.insertSelective(billno,entid);
        return jsonpcallback + "({\"billno\":\"" + billno + "\",\"entid\":\"" + entid + "\"})";
    }


    @PostMapping("/deleteById")
    public  CommonResult deleteById( Integer billno,String  entid) {
        int i=this.goodsFirstNewService.deleteById(billno,entid);
        if(i==1){
        return result(ResultEnum.DELETE_SUCCESS);
        }
        return  result(ResultEnum.DELETE_ERROR);
    }


    @PostMapping("/updateById")
    public CommonResult updateById(GoodsFirstNew record) {
        int i= this.goodsFirstNewService.updateById(record);
        if (i==1) {
        return result(ResultEnum.UPDATE_SUCCESS);
        }
        return  result(ResultEnum.UPDATE_ERROR);
    }


    @GetMapping("/selectById")
    public CommonResult selectById( Integer billno,String  entid) {
        return resultData(ResultEnum.SELECT_SUCCESS,this.goodsFirstNewService.selectById(billno,entid));
    }


    @GetMapping("/listAll")
    public CommonResult listAll() {
        return resultData(ResultEnum.SELECT_SUCCESS,this.goodsFirstNewService.list());
    }

    @GetMapping("/findByQuery")
    public Page<GoodsFirstNew> findByQuery(GoodsFirstNew record) {
        PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
        return new Page<GoodsFirstNew>(this.goodsFirstNewService.findByQuery(record));

    }
}

