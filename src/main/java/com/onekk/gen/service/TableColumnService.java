package com.onekk.gen.service;

import com.onekk.gen.dto.OnekkTable;
import com.onekk.gen.dto.OnekkTableColumnResult;
import com.onekk.gen.dto.OnekkTableEntity;

import java.util.List;

public interface TableColumnService {
    /**
     * 查询表列
     * @param tableName
     * @return
     */
    List<OnekkTableColumnResult> quireColumn(String tableName);

    OnekkTable queryTableMess(String tableName);

    /**
     * 代码生成实体
     * @param tableName
     * @param ClassName
     * @param auther
     * @param Comments
     * @return
     */
    OnekkTableEntity queryTableEntity(String tableName,String ClassName,String auther,String Comments);
}
