package com.onekk.gen.mapper;

import com.onekk.gen.dto.OnekkTableColumn;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface OnekkTableColumnMapper {

    List<OnekkTableColumn> quireColumn(String tableName);

}

