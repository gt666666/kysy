package com.sygs.service.mysql.kyfkplmt;

import cn.hutool.core.date.DateTime;
import com.sygs.dao.mysql.kyfkhtmx.KyfkhtmxMapper;
import com.sygs.dao.mysql.kyfkpldt.KyfkpldtMapper;
import com.sygs.dao.sqlserver.kyfkhtmx.KyfkhtmxSqlMapper;
import com.sygs.dao.sqlserver.kyfkpldt.KyfkpldtSqlMapper;
import com.sygs.dao.sqlserver.kyfkplmt.KyfkplmtSqlMapper;
import com.sygs.pojo.mysql.kyfkhtmx.Kyfkhtmx;
import com.sygs.pojo.mysql.kyfkpldt.Kyfkpldt;
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
     * @param record 记录对象
     */
    @Transactional(rollbackFor = Exception.class)
    public int updateById(Kyfkplmt record) {
        // 先查询，再次修改。记录必须有id才能修改
        if (Tools.isBlank(record.getBillno()) || Tools.isBlank(record.getBillno())) {
            throw new FailException(ResultEnum.RECORD_IS_NULL);
        }
        // 未查询到记录的不能修改
        Kyfkplmt select = this.selectById(record.getBillno(), record.getEntid());
        if (null == select) {
            throw new FailException(ResultEnum.RECORD_IS_NULL);
        }
        return this.kyfkplmtMapper.updateByPrimaryKeySelective(record);
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
     *
     * @param
     */
    public List<Kyfkplmt> list() {
        Kyfkplmt kyfkplmt = new Kyfkplmt();
        kyfkplmt.setStatus(false);
        List<Kyfkplmt> kyfkplmtsList = this.kyfkplmtMapper.list(kyfkplmt); //预付款申请汇总单主表没有审核的数据
        Kyfkpldt kyfkpldt = null;
        for (Kyfkplmt kyfkplmt1 : kyfkplmtsList) {
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
        Kyfkplmt kyfkplmt1 = new Kyfkplmt();
        kyfkplmt1.setMsg(ResultEnum.SELECT_SUCCESS.getMessage());
        kyfkplmt1.setCode(ResultEnum.SELECT_SUCCESS.getCode());
        kyfkplmtsList.add(kyfkplmt1);
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
