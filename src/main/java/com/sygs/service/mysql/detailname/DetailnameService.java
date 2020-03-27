package com.sygs.service.mysql.detailname;

import cn.hutool.core.date.DateTime;
import com.sygs.utils.Tools;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sygs.config.global.FailException;
import com.sygs.enums.ResultEnum;
import com.sygs.dao.mysql.detailname.DetailnameMapper;
import com.sygs.pojo.mysql.detailname.Detailname;
import java.util.List;

/**
 * 
 *
 * @author gaoting
 */
@Service
public class DetailnameService {
    private DetailnameMapper detailnameMapper;

        @Autowired
        public DetailnameService(DetailnameMapper detailnameMapper) {

            this.detailnameMapper = detailnameMapper;
        }

        /**
         * <p> 方法描述：添加记录（要修改xml对应的方法，让其返回添加记录的id）. </p>
         * <p> 创建时间：2020-02-22 21:05:38 </p>
         * <p> 创建作者：gaoting </p>
         * <p> 修改作者： </p>
         *
         * @param record 记录对象
         */
        @Transactional(rollbackFor = Exception.class)
        public void insertSelective(Detailname record) {
            record.setCreateDate(new DateTime());
            record.setIsDelete(false);
            this.detailnameMapper.insertSelective(record);

        }

        /**
         * <p> 方法描述：通过记录id删除记录. </p>
         * <p> 创建时间：2020-02-22 21:05:38 </p>
         * <p> 创建作者：gaoting </p>
         * <p> 修改作者： </p>
         *
         * @param id 记录id
         */
        @Transactional(rollbackFor = Exception.class)
        public int deleteById(Long id) {
             Detailname record =this.selectById(id);
                if (null == record) {
                throw new FailException(ResultEnum.RECORD_IS_NULL);
             }
             return  this.detailnameMapper.deleteByPrimaryKey(id);
        }

        /**
         * <p> 方法描述：更新记录. </p>
         * <p> 创建时间：2020-02-22 21:05:38 </p>
         * <p> 创建作者：gaoting </p>
         * <p> 修改作者： </p>
         *
         * @param record 记录对象
         */
        @Transactional(rollbackFor = Exception.class)
        public int updateById(Detailname record) {
            // 先查询，再次修改。记录必须有id才能修改
            if (Tools.isBlank(record.getId())) {
            throw new FailException(ResultEnum.RECORD_IS_NULL);
            }
             // 未查询到记录的不能修改
             Detailname select = this.selectById(record.getId());
             if (null == select) {
             throw new FailException(ResultEnum.RECORD_IS_NULL);
             }
             return this.detailnameMapper.updateByPrimaryKeySelective(record);
        }

        /**
         * <p> 方法描述：根据记录id查询记录. </p>
         * <p> 创建时间：2020-02-22 21:05:38 </p>
         * <p> 创建作者：gaoting </p>
         * <p> 修改作者： </p>
         *
         * @param id 记录id
         */
        public Detailname selectById(Long id) {
            return this.detailnameMapper.selectByPrimaryKey(id);
        }

        /**
         * <p> 方法描述：根据 查询对象 查询出单条记录. </p>
         * <p> 创建时间：2020-02-22 21:05:38 </p>
         * <p> 创建作者：gaoting </p>
         * <p> 修改作者： </p>
         *
         * @param record 查询对象
         */
        public Detailname find(Detailname record) {
             return this.detailnameMapper.find(record);
        }

        /**
         * <p> 方法描述：根据 查询对象 查询出列表记录. </p>
         * <p> 创建时间：2020-02-22 21:05:38 </p>
         * <p> 创建作者：gaoting </p>
         * <p> 修改作者： </p>
         *
         * @param mid 查询对象
         */
        public List<Detailname> list(Long mid) {
                return this.detailnameMapper.list(mid);
         }

        /**
         * <p> 方法描述：根据 查询对象 分页查询数据. </p>
         * <p> 创建时间：2020-02-22 21:05:38 </p>
         * <p> 创建作者：gaoting </p>
         * <p> 修改作者： </p>
         *
         * @param record 查询对象
         */
        public List<Detailname> findByQuery(Detailname record) {

             return  this.detailnameMapper.listQuery(record);
        }

}
