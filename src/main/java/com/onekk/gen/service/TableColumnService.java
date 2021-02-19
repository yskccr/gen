package com.onekk.gen.service;

import com.onekk.gen.dto.OnekkTableColumn;

import java.util.List;

public interface TableColumnService {

    List<OnekkTableColumn> quireColumn(String tableName);
}
