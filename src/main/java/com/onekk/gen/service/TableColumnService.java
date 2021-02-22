package com.onekk.gen.service;

import com.onekk.gen.dto.OnekkTable;
import com.onekk.gen.dto.OnekkTableColumnResult;
import com.onekk.gen.dto.OnekkTableEntity;

import java.util.List;

public interface TableColumnService {

    List<OnekkTableColumnResult> quireColumn(String tableName);

    OnekkTable queryTableMess(String tableName);

    OnekkTableEntity queryTableEntity(String tableName,String ClassName,String auther,String Comments);
}
