package com.sygs.service.mysql.kyfkplmt;

import cn.hutool.core.date.DateTime;
import com.sygs.dao.mysql.kyfkhtmx.KyfkhtmxMapper;
import com.sygs.dao.mysql.kyfkpldt.KyfkpldtMapper;
import com.sygs.dao.sqlserver.kyfkhtmx.KyfkhtmxSqlMapper;
import com.sygs.dao.sqlserver.kyfkpldt.KyfkpldtSqlMapper;
import com.sygs.dao.sqlserver.kyfkplmt.KyfkplmtSqlMapper;
import com.sygs.pojo.mysql.kyfkhtmx.Kyfkhtmx;
import com.sygs.pojo.mysql.kyfkpldt.Kyfkpldt;
import com.sygs.pojo.sqlserver.kyfkpldt.KyfkpldtSql;
import com.sygs.pojo.sqlserver.kyfkplmt.KyfkplmtSql;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import com.sygs.config.global.FailException;
import com.sygs.enums.ResultEnum;
import com.sygs.utils.Tools;
import com.sygs.dao.mysql.kyfkplmt.KyfkplmtMapper;
import com.sygs.pojo.mysql.kyfkplmt.Kyfkplmt;
import javax.annotation.Resource;
import javax.jws.WebService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 预付款申请汇总单主表
 *
 * @author gaoting
 */
@Service
@WebService
public class KyfkplmtService {
    @Resource
    private KyfkplmtMapper kyfkplmtMapper;
    @Resource
    private KyfkplmtSqlMapper kyfkplmtSqlMapper;
    @Resource
    private KyfkpldtMapper kyfkpldtMapper;
    @Resource
    private KyfkpldtSqlMapper kyfkpldtSqlMapper;
    @Resource
    private KyfkhtmxSqlMapper kyfkhtmxSqlMapper;
    @Resource
    private KyfkhtmxMapper kyfkhtmxMapper;

    public KyfkplmtService() {
    }

    /**
     * <p> 方法描述：添加记录（要修改xml对应的方法，让其返回添加记录的id）. </p>
     * <p> 创建时间：2020-03-11 11:40:03 </p>
     * <p> 创建作者：gaoting </p>
     * <p> 修改作者： </p>
     *
     * @param billno,entid
     */
    @Transactional(rollbackFor = Exception.class)
    public void insertSelective(Integer billno, String entid) {

        Map<String, Object> map = new HashMap<>();
        map.put("billno", billno);
        map.put("entid", entid);
        Kyfkplmt kyfkplmt = this.kyfkplmtSqlMapper.viewOaKyfkplmt(map);
        kyfkplmt.setCreateDate(new DateTime());
        kyfkplmt.setIsDelete(false);
        kyfkplmt.setStatus(false);
        kyfkplmt.setIsQushu(false);
        this.kyfkplmtMapper.insertSelective(kyfkplmt);   //预付款申请单批量主表插入
        List<Kyfkpldt> kyfkpldts = this.kyfkpldtSqlMapper.ViewOakYfkpldt(map);  //预付款申请单批量子表查询
        Map<String, Object> mapmx = null;
        for (Kyfkpldt kyfkpldt : kyfkpldts) {
            mapmx = new HashMap<>();
            mapmx.put("entid", entid);
            mapmx.put("billno", kyfkpldt.getRfbillno());
            kyfkpldt.setCreateDate(new DateTime());
            kyfkpldt.setIsDelete(false);
            kyfkpldt.setStatus(false);
            List<Kyfkhtmx> kyfkhtmxs = this.kyfkhtmxSqlMapper.viewOaKyfkhtmx(mapmx);
            for (Kyfkhtmx kyfkhtmx : kyfkhtmxs) {
                kyfkhtmx.setCreateDate(new DateTime());
                kyfkhtmx.setIsDelete(false);
                kyfkhtmx.setStatus(false);
            }
            this.kyfkhtmxMapper.insertForeach(kyfkhtmxs);   //预付款申请单批量商品明细表批量插入
        }
        this.kyfkpldtMapper.insertForeach(kyfkpldts);    //预付款申请单批量子表批量插入
    }

    /**
     * <p> 方法描述：通过记录id删除记录. </p>
     * <p> 创建时间：2020-03-11 11:40:03 </p>
     * <p> 创建作者：gaoting </p>
     * <p> 修改作者： </p>
     *
     * @param billno ,entid
     */
    @Transactional(rollbackFor = Exception.class)
    public int deleteById(Integer billno, String entid) {
        Kyfkplmt record = this.selectById(billno, entid);
        if (null == record) {
            throw new FailException(ResultEnum.RECORD_IS_NULL);
        }
        return this.kyfkplmtMapper.deleteByPrimaryKey(billno, entid);
    }

    /**
     * <p> 方法描述：更新记录. </p>
     * <p> 创建时间：2020-03-11 11:40:03 </p>
     * <p> 创建作者：gaoting </p>
     * <p> 修改作者： </p>
     *
     * @param    resData  记录对象
     */
    @Transactional(rollbackFor = Exception.class)
    public String updateById(String resData,String remark1,String remark2) {
        String[] split = resData.split(";");
        for(String  sp:split){
            String[] sps= sp.split(",");
            Kyfkplmt  kyfkplmt=new Kyfkplmt();
            kyfkplmt.setBillno(Integer.parseInt((sps[0])));
            kyfkplmt.setEntid(sps[2]);
            kyfkplmt.setStatus(true);
            int i = this.kyfkplmtMapper.updateByPrimaryKeySelective(kyfkplmt);

            Kyfkpldt  kyfkpldt=new Kyfkpldt();
            kyfkpldt.setStatus(true);
            kyfkpldt.setBillno(Integer.parseInt((sps[0])));
            kyfkpldt.setBillsn(Integer.parseInt(sps[1]));
            kyfkpldt.setEntid(sps[2]);
            int ii = this.kyfkpldtMapper.updateByPrimaryKeySelective(kyfkpldt);
            if(i>0&&ii>0){
                KyfkpldtSql kyfkpldtSql=new KyfkpldtSql();
                kyfkpldtSql.setBillno(Integer.parseInt((sps[0])));
                kyfkpldtSql.setBillsn(Integer.parseInt(sps[1]));
                kyfkpldtSql.setEntid(sps[2]);
                kyfkpldtSql.setKyj1(sps[3]);
                kyfkpldtSql.setKyj2(sps[3]);
                this.kyfkpldtSqlMapper.updateByPrimaryKeySelective(kyfkpldtSql);

                KyfkplmtSql kyfkplmtSql=new KyfkplmtSql();
                kyfkplmtSql.setCwzjzyj(remark1);
                kyfkplmtSql.setZjlzyj(remark2);
                kyfkplmtSql.setBillno(Integer.parseInt((sps[0])));
                kyfkplmtSql.setEntid(sps[2]);
                this.kyfkplmtSqlMapper.updateByPrimaryKeySelective(kyfkplmtSql);
            }
        }
        System.err.println("resData="+resData+"remark1="+remark1+"remark2="+remark2);
        return   "成功";
        // return this.kyfkplmtMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * <p> 方法描述：根据记录id查询记录. </p>
     * <p> 创建时间：2020-03-11 11:40:03 </p>
     * <p> 创建作者：gaoting </p>
     * <p> 修改作者： </p>
     *
     * @param billno ，entid
     */
    public Kyfkplmt selectById(Integer billno, String entid) {
        return this.kyfkplmtMapper.selectByPrimaryKey(billno, entid);
    }

    /**
     * <p> 方法描述：根据 查询对象 查询出单条记录. </p>
     * <p> 创建时间：2020-03-11 11:40:03 </p>
     * <p> 创建作者：gaoting </p>
     * <p> 修改作者： </p>
     *
     * @param record 查询对象
     */
    public Kyfkplmt find(Kyfkplmt record) {
        return this.kyfkplmtMapper.find(record);
    }

    /**
     * <p> 方法描述：根据 查询对象 查询出列表记录. </p>
     * <p> 创建时间：2020-03-11 11:40:03 </p>
     * <p> 创建作者：gaoting </p>
     * <p> 修改作者： </p>
     * @param
     */

    public List<Kyfkplmt> listAll(String  init) {
        Kyfkplmt kyfkplmt = new Kyfkplmt();
        kyfkplmt.setStatus(false);
        kyfkplmt.setIsQushu(false);
        List<Kyfkplmt> kyfkplmtsList = this.kyfkplmtMapper.list(kyfkplmt); //预付款申请汇总单主表没有审核的数据
        System.err.println(kyfkplmtsList.size());
        System.err.println(kyfkplmtsList);
              for( Kyfkplmt   kyfkplmts:kyfkplmtsList){
                  kyfkplmts.setIsQushu(true);
                  this.kyfkplmtMapper.updateByPrimaryKeySelective(kyfkplmts);   //取过的数据都修改为1
              }

        Kyfkpldt kyfkpldt = null;
        for (Kyfkplmt kyfkplmt1 : kyfkplmtsList) {
            kyfkplmt1.setGs("昆药集团医药商业有限公司 ");
            kyfkplmt1.setDeptId("昆商财务部 ");
            kyfkpldt = new Kyfkpldt();
            kyfkpldt.setStatus(false);
            kyfkpldt.setBillno(kyfkplmt1.getBillno());
            kyfkpldt.setEntid(kyfkplmt1.getEntid());
            List<Kyfkpldt> kyfkpldtList = this.kyfkpldtMapper.list(kyfkpldt);
            Kyfkhtmx kyfkhtmx = null;
            for (Kyfkpldt kyfkpldt1 : kyfkpldtList) {
                kyfkhtmx = new Kyfkhtmx();
                kyfkhtmx.setBillno(kyfkpldt1.getRfbillno());
                kyfkhtmx.setEntid(kyfkpldt1.getEntid());
                List<Kyfkhtmx> kyfkhtmxList = this.kyfkhtmxMapper.list(kyfkhtmx);
                kyfkpldt1.setKyfkhtmxes(kyfkhtmxList);   //预付款申请汇总单商品明细表
                kyfkplmt1.setKyfkpldts(kyfkpldtList);   //预付款申请汇总单子表
            }
        }
        return kyfkplmtsList;
    }

    /**
     * <p> 方法描述：根据 查询对象 分页查询数据. </p>
     * <p> 创建时间：2020-03-11 11:40:03 </p>
     * <p> 创建作者：gaoting </p>
     * <p> 修改作者： </p>
     *
     * @param record 查询对象
     */
    public List<Kyfkplmt> findByQuery(Kyfkplmt record) {


        return this.kyfkplmtMapper.list(record);
    }

}
