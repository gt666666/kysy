package com.sygs.service.mysql.salenotesmt;

import cn.hutool.core.date.DateTime;
import com.sygs.dao.mysql.salenotesdt.SaleNotesDtMapper;
import com.sygs.dao.sqlserver.salenotesdt.SaleNotesDtSqlMapper;
import com.sygs.dao.sqlserver.salenotesmt.SaleNotesMtSqlMapper;
import com.sygs.pojo.mysql.salenotesdt.SaleNotesDt;
import com.sygs.pojo.mysql.salenotesmt.SaleNotesMt;
import com.sygs.utils.Tools;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sygs.config.global.FailException;
import com.sygs.enums.ResultEnum;
import com.sygs.dao.mysql.salenotesmt.SaleNotesMtMapper;
import javax.annotation.Resource;
import javax.jws.WebService;
import java.util.Date;
import java.util.List;

/**
 * 销售调价开票单
 *
 * @author gaoting
 */

@WebService
@Service
public class SaleNotesMtService {

    @Resource
    private SaleNotesDtMapper saleNotesDtMapper;
    @Resource
    private SaleNotesMtMapper saleNotesMtMapper;
    @Resource
    private SaleNotesMtSqlMapper saleNotesMtSqlMapper;
    @Resource
    private SaleNotesDtSqlMapper saleNotesDtSqlMapper;

    public SaleNotesMtService() {

    }

    /**
     * <p> 方法描述：添加记录（要修改xml对应的方法，让其返回添加记录的id）. </p>
     * <p> 创建时间：2020-03-04 17:51:12 </p>
     * <p> 创建作者：gaoting </p>
     * <p> 修改作者： </p>
     *
     * @param billno , entid记录对象
     */
    @Transactional(rollbackFor = Exception.class)
    public void insertSelective(String billno, String entid) {
        SaleNotesMt saleNotesMt = this.saleNotesMtSqlMapper.viewOaSaleNotesMt(billno, entid);
        saleNotesMt.setCreateDate(new DateTime());
        saleNotesMt.setIsDelete(false);
        saleNotesMt.setStatus(false);
        List<SaleNotesDt> saleNotesDts = this.saleNotesDtSqlMapper.ViewOASaleNotesDt(billno, entid);
        for (SaleNotesDt saleNotesDt : saleNotesDts) {
            saleNotesDt.setIsDelete(false);
            saleNotesDt.setStatus(false);
            saleNotesDt.setCreateDate(new Date());
        }
        this.saleNotesMtMapper.insertSelective(saleNotesMt);
        this.saleNotesDtMapper.insertForeach(saleNotesDts);
    }

    /**
     * <p> 方法描述：通过记录id删除记录. </p>
     * <p> 创建时间：2020-03-04 17:51:12 </p>
     * <p> 创建作者：gaoting </p>
     * <p> 修改作者： </p>
     *
     * @param billno ,entid
     */
    @Transactional(rollbackFor = Exception.class)
    public int deleteById(String billno, String entid) {
        SaleNotesMt record = this.selectById(billno, entid);
        if (null == record) {
            throw new FailException(ResultEnum.RECORD_IS_NULL);
        }
        return this.saleNotesMtMapper.deleteByPrimaryKey(billno, entid);
    }

    /**
     * <p> 方法描述：更新记录. </p>
     * <p> 创建时间：2020-03-04 17:51:12 </p>
     * <p> 创建作者：gaoting </p>
     * <p> 修改作者： </p>
     *
     * @param record 记录对象
     */
    @Transactional(rollbackFor = Exception.class)
    public int updateById(SaleNotesMt record) {
        // 先查询，再次修改。记录必须有id才能修改
        if (Tools.isBlank(record.getBillno()) || Tools.isBlank(record.getBillno())) {
            throw new FailException(ResultEnum.RECORD_IS_NULL);
        }
        // 未查询到记录的不能修改
        SaleNotesMt select = this.selectById(record.getBillno(), record.getEntid());
        if (null == select) {
            throw new FailException(ResultEnum.RECORD_IS_NULL);
        }
        return this.saleNotesMtMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * <p> 方法描述：根据记录id查询记录. </p>
     * <p> 创建时间：2020-03-04 17:51:12 </p>
     * <p> 创建作者：gaoting </p>
     * <p> 修改作者： </p>
     *
     * @param billno ，entid
     */
    public SaleNotesMt selectById(String billno, String entid)  {
        return this.saleNotesMtMapper.selectByPrimaryKey(billno, entid);
    }

    /**
     * <p> 方法描述：根据 查询对象 查询出单条记录. </p>
     * <p> 创建时间：2020-03-04 17:51:12 </p>
     * <p> 创建作者：gaoting </p>
     * <p> 修改作者： </p>
     *
     * @param record 查询对象
     */
    public SaleNotesMt find(SaleNotesMt record)  {
        return this.saleNotesMtMapper.find(record);
    }

    /**
     * <p> 方法描述：根据 查询对象 查询出列表记录. </p>
     * <p> 创建时间：2020-03-04 17:51:12 </p>
     * <p> 创建作者：gaoting </p>
     * <p> 修改作者： </p>
     *
     * @param ，entid 查询对象
     */

    public List<SaleNotesMt> list() {
        SaleNotesMt saleNotesmt = new SaleNotesMt();
        saleNotesmt.setStatus(false);
        List<SaleNotesMt> saleNotesMtList = this.saleNotesMtMapper.list(saleNotesmt);  //主表所有没有审核的数据
        SaleNotesDt saleNotesDt = null;
        for (SaleNotesMt saleNotesMt1 : saleNotesMtList) {
            saleNotesDt = new SaleNotesDt();
            saleNotesDt.setStatus(false);
            saleNotesDt.setBillno(saleNotesMt1.getBillno());
            saleNotesDt.setEntid(saleNotesMt1.getEntid());
            List<SaleNotesDt> SaleNotesDtList = this.saleNotesDtMapper.list(saleNotesDt);
            saleNotesMt1.setSaleNotesDts(SaleNotesDtList);
        }
        SaleNotesMt saleNotemt1 = new SaleNotesMt();
        saleNotemt1.setMsg(ResultEnum.SELECT_SUCCESS.getMessage());
        saleNotemt1.setCode(ResultEnum.SELECT_SUCCESS.getCode());
        saleNotesMtList.add(saleNotemt1);
        return saleNotesMtList;
    }

    /**
     * <p> 方法描述：根据 查询对象 分页查询数据. </p>
     * <p> 创建时间：2020-03-04 17:51:12 </p>
     * <p> 创建作者：gaoting </p>
     * <p> 修改作者： </p>
     *
     * @param record 查询对象
     */
    public List<SaleNotesMt> findByQuery(SaleNotesMt record) {
        return this.saleNotesMtMapper.list(record);
    }

}
