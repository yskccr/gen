package com.onekk.gen.mapper;

import com.onekk.gen.dto.OnekkTable;
import com.onekk.gen.dto.OnekkTableColumnResult;

import java.util.List;

public interface OnekkTableColumnMapper {

    List<OnekkTableColumnResult> quireColumn(String tableName);


    OnekkTable queryTableMess(String tableName);

}

