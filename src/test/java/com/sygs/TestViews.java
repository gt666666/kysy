package com.sygs;

import com.sygs.controller.mysql.kyfkplmt.KyfkplmtController;
import com.sygs.dao.sqlserver.kyfkplmt.KyfkplmtSqlMapper;
import com.sygs.dao.sqlserver.salenotesdt.SaleNotesDtSqlMapper;
import com.sygs.dao.sqlserver.salenotesmt.SaleNotesMtSqlMapper;
import com.sygs.pojo.mysql.creditadjmt.CreditAdjMt;
import com.sygs.pojo.mysql.kyfkplmt.Kyfkplmt;
import com.sygs.pojo.mysql.salenotesdt.SaleNotesDt;
import com.sygs.service.mysql.creditadjmt.CreditAdjMtService;

import com.sygs.service.mysql.goodsfirstnew.GoodsFirstNewService;
import com.sygs.service.mysql.kndxy.KndxyService;
import com.sygs.service.mysql.kplfkmt.KPlfkmtService;
import com.sygs.service.mysql.kxsflxymt.KxsflxymtService;
import com.sygs.service.mysql.kyfkplmt.KyfkplmtService;
import com.sygs.service.mysql.salenotesmt.SaleNotesMtService;
import com.sygs.utils.MD5Code;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest(classes = KysyApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class TestViews {
   @Autowired
   private SaleNotesMtSqlMapper saleNotesMtSqlMapper;
   @Autowired
   private SaleNotesMtService saleNotesMtService;
   @Autowired
   private  CreditAdjMtService creditAdjMtService;
   @Resource
    private   KndxyService   kndxyService;
    @Resource
   private KxsflxymtService  kxsflxymtService;

    @Autowired
    private  KyfkplmtService  kyfkplmtService;
    @Autowired
   private GoodsFirstNewService  goodsFirstNewService;

    @Autowired
    private SaleNotesDtSqlMapper  saleNotesDtSqlMapper;



    @Test
    public  void testSaleNotesMtSqlMapper(){
        System.err.println(this.saleNotesMtSqlMapper.viewOaSaleNotesMt("7482966","E1VQBVG2U48"));
    }
    @Test
    public  void testSaleNotesMtInsert(){
       this.saleNotesMtService.insertSelective("7487971","E1VQBVG2U48");
    }

    @Test
    public void testSaleNotesDtSelect(){
        List<SaleNotesDt>  saleNotesDts= this.saleNotesDtSqlMapper.ViewOASaleNotesDt("7487971", "E1VQBVG2U48");
        System.err.println(saleNotesDts);
    }
    @Test
    public void test1(){
        this.kyfkplmtService.insertSelective(7488549,"E1VQBVG2U48");
    }
//    @Test
//    public void test2(){
//        System.out.println(this.kyfkplmtService.listAll());
//    }

    @Test
    public void test3(){

        this.kyfkplmtService.insertSelective(7488549,"E1VQBVG2U48");

    }
    @Test
    public void test4(){

        String admin = new MD5Code().getMD5ofStr("admin");
        System.out.println(admin);
    }


}
