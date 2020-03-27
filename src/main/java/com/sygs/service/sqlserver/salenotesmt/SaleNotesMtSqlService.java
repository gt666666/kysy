package com.sygs.service.sqlserver.salenotesmt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sygs.dao.sqlserver.salenotesmt.SaleNotesMtSqlMapper;
import com.sygs.pojo.sqlserver.salenotesmt.SaleNotesMtSql;

/**
 * 销售调价开票单
 *
 * @author gaoting
 */
@Service
public class SaleNotesMtSqlService {
    private SaleNotesMtSqlMapper saleNotesMtSqlMapper;

        @Autowired
        public SaleNotesMtSqlService(SaleNotesMtSqlMapper saleNotesMtSqlMapper) {

            this.saleNotesMtSqlMapper = saleNotesMtSqlMapper;
        }

        /**
         * <p> 方法描述：根据记录id查询记录. </p>
         * <p> 创建时间：2020-03-04 16:08:20 </p>
         * <p> 创建作者：gaoting </p>
         * <p> 修改作者： </p>
         *
         * @param billno ,entid
         */
        public SaleNotesMtSql selectById(String billno, String entid) {
            return this.saleNotesMtSqlMapper.selectByPrimaryKey(billno,entid);
        }


}
