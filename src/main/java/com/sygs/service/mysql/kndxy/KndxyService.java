package com.sygs.service.mysql.kndxy;

import cn.hutool.core.date.DateTime;
import com.sygs.dao.sqlserver.kndxy.KndxySqlMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sygs.config.global.FailException;
import com.sygs.enums.LogInfoTypeEnum;
import com.sygs.enums.ResultEnum;
import com.sygs.enums.TableNameEnum;
import com.sygs.service.loginfo.LogInfoService;
import com.sygs.utils.Tools;
import com.sygs.dao.mysql.kndxy.KndxyMapper;
import com.sygs.pojo.mysql.kndxy.Kndxy;

import javax.annotation.Resource;
import javax.jws.WebService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 销售年度协议
 *
 * @author gaoting
 */
@Service
@WebService
public class KndxyService {
    @Resource
    private KndxyMapper kndxyMapper;
    @Resource
    private KndxySqlMapper kndxySqlMapper;

    public KndxyService() {
    }


    /**
     * <p> 方法描述：添加记录（要修改xml对应的方法，让其返回添加记录的id）. </p>
     * <p> 创建时间：2020-03-23 08:52:11 </p>
     * <p> 创建作者：gaoting </p>
     * <p> 修改作者： </p>
     *
     * @param billno ,entid   记录对象
     */
    @Transactional(rollbackFor = Exception.class)
    public void insertSelective(Integer billno, String entid) {
        Map<String, Object> map = new HashMap<>();
        map.put("billno", billno);
        map.put("entid", entid);
        Kndxy kndxy = this.kndxySqlMapper.viewOaKndxy(map);
        System.err.println(kndxy);
        kndxy.setCreateDate(new DateTime());
        kndxy.setIsDelete(false);
        kndxy.setStatus(false);
        this.kndxyMapper.insertSelective(kndxy);
    }

    /**
     * <p> 方法描述：通过记录id删除记录. </p>
     * <p> 创建时间：2020-03-23 08:52:11 </p>
     * <p> 创建作者：gaoting </p>
     * <p> 修改作者： </p>
     *
     * @param billno ,entid
     */
    @Transactional(rollbackFor = Exception.class)
    public int deleteById(Integer billno, String entid) {
        Kndxy record = this.selectById(billno, entid);
        if (null == record) {
            throw new FailException(ResultEnum.RECORD_IS_NULL);
        }
        return this.kndxyMapper.deleteByPrimaryKey(billno, entid);
    }

    /**
     * <p> 方法描述：更新记录. </p>
     * <p> 创建时间：2020-03-23 08:52:11 </p>
     * <p> 创建作者：gaoting </p>
     * <p> 修改作者： </p>
     *
     * @param record 记录对象
     */
    @Transactional(rollbackFor = Exception.class)
    public int updateById(Kndxy record) {
        // 先查询，再次修改。记录必须有id才能修改
        if (Tools.isBlank(record.getBillno()) || Tools.isBlank(record.getBillno())) {
            throw new FailException(ResultEnum.RECORD_IS_NULL);
        }
        // 未查询到记录的不能修改
        Kndxy select = this.selectById(record.getBillno(), record.getEntid());
        if (null == select) {
            throw new FailException(ResultEnum.RECORD_IS_NULL);
        }
        return this.kndxyMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * <p> 方法描述：根据记录id查询记录. </p>
     * <p> 创建时间：2020-03-23 08:52:11 </p>
     * <p> 创建作者：gaoting </p>
     * <p> 修改作者： </p>
     *
     * @param billno ，entid
     */
    public Kndxy selectById(Integer billno, String entid) {
        return this.kndxyMapper.selectByPrimaryKey(billno, entid);
    }

    /**
     * <p> 方法描述：根据 查询对象 查询出单条记录. </p>
     * <p> 创建时间：2020-03-23 08:52:11 </p>
     * <p> 创建作者：gaoting </p>
     * <p> 修改作者： </p>
     *
     * @param record 查询对象
     */
    public Kndxy find(Kndxy record) {
        return this.kndxyMapper.find(record);
    }

    /**
     * <p> 方法描述：根据 查询对象 查询出列表记录. </p>
     * <p> 创建时间：2020-03-23 08:52:11 </p>
     * <p> 创建作者：gaoting </p>
     * <p> 修改作者： </p>
     *
     * @param
     */
    public List<Kndxy> list() {
        Kndxy  kndxy=new Kndxy();
        kndxy.setStatus(false);
        return this.kndxyMapper.list(kndxy);
    }

    /**
     * <p> 方法描述：根据 查询对象 分页查询数据. </p>
     * <p> 创建时间：2020-03-23 08:52:11 </p>
     * <p> 创建作者：gaoting </p>
     * <p> 修改作者： </p>
     *
     * @param record 查询对象
     */
    public List<Kndxy> findByQuery(Kndxy record) {

        return this.kndxyMapper.list(record);
    }

}
