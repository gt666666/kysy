package com.sygs.service.mysql.mastername;

import cn.hutool.core.date.DateTime;
import com.sygs.dao.mysql.detailname.DetailnameMapper;
import com.sygs.utils.Tools;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sygs.config.global.FailException;
import com.sygs.enums.ResultEnum;
import com.sygs.dao.mysql.mastername.MasternameMapper;
import com.sygs.pojo.mysql.mastername.Mastername;

import java.util.List;

/**
 * @author gaoting
 */
@Service
public class MasternameService {
    private MasternameMapper masternameMapper;
    @Autowired
    private DetailnameMapper  detailnameMapper;

    @Autowired
    public MasternameService(MasternameMapper masternameMapper) {

        this.masternameMapper = masternameMapper;
    }

    /**
     * <p> 方法描述：添加记录（要修改xml对应的方法，让其返回添加记录的id）. </p>
     * <p> 创建时间：2020-02-21 09:55:04 </p>
     * <p> 创建作者：gaoting </p>
     * <p> 修改作者： </p>
     *
     * @param record 记录对象
     */
    @Transactional(rollbackFor = Exception.class)
    public Long insertSelective(Mastername record) {

        record.setCreateDate(new DateTime());
        record.setIsDelete(false);
        this.masternameMapper.insertSelective(record);

       return  record.getMid();

    }

    /**
     * <p> 方法描述：通过记录id删除记录. </p>
     * <p> 创建时间：2020-02-21 09:55:04 </p>
     * <p> 创建作者：gaoting </p>
     * <p> 修改作者： </p>
     *
     * @param mid 记录id
     */
    @Transactional(rollbackFor = Exception.class)
    public int deleteById(Long mid) {
        Mastername record = this.selectById(mid);
        System.err.println(mid);
        if (null == record) {
            throw new FailException(ResultEnum.RECORD_IS_NULL);
        }
        this.detailnameMapper.deleteBYMasternamePrimaryKey(mid);
        return this.masternameMapper.deleteByPrimaryKey(mid);
    }

    /**
     * <p> 方法描述：更新记录. </p>
     * <p> 创建时间：2020-02-21 09:55:04 </p>
     * <p> 创建作者：gaoting </p>
     * <p> 修改作者： </p>
     *
     * @param record 记录对象
     */
    @Transactional(rollbackFor = Exception.class)
    public int updateById(Mastername record) {
        // 先查询，再次修改。记录必须有id才能修改
        if (Tools.isBlank(record.getMid())) {
            throw new FailException(ResultEnum.RECORD_IS_NULL);
        }
        // 未查询到记录的不能修改
        Mastername select = this.selectById(record.getMid());
        if (null == select) {
            throw new FailException(ResultEnum.RECORD_IS_NULL);
        }
        return this.masternameMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * <p> 方法描述：根据记录id查询记录. </p>
     * <p> 创建时间：2020-02-21 09:55:04 </p>
     * <p> 创建作者：gaoting </p>
     * <p> 修改作者： </p>
     *
     * @param mid 记录id
     */
    public Mastername selectById(Long mid) {
        return this.masternameMapper.selectByPrimaryKey(mid);
    }

    /**
     * <p> 方法描述：根据 查询对象 查询出单条记录. </p>
     * <p> 创建时间：2020-02-21 09:55:04 </p>
     * <p> 创建作者：gaoting </p>
     * <p> 修改作者： </p>
     *
     * @param record 查询对象
     */
    public Mastername find(Mastername record) {
        return this.masternameMapper.find(record);
    }

    /**
     * <p> 方法描述：根据 查询对象 查询出列表记录. </p>
     * <p> 创建时间：2020-02-21 09:55:04 </p>
     * <p> 创建作者：gaoting </p>
     * <p> 修改作者： </p>
     *
     * @param record 查询对象
     */
    public List<Mastername> list(Mastername record) {
        return this.masternameMapper.list(record);
    }

    /**
     * <p> 方法描述：根据 查询对象 分页查询数据. </p>
     * <p> 创建时间：2020-02-21 09:55:04 </p>
     * <p> 创建作者：gaoting </p>
     * <p> 修改作者： </p>
     *
     * @param record 查询对象
     */
    public List<Mastername> findByQuery(Mastername record) {

        return this.masternameMapper.list(record);
    }

}
