package com.onekk.gen.service;

import com.onekk.gen.dto.OnekkTableColumnResult;

import java.util.List;

public interface TableColumnService {

    List<OnekkTableColumnResult> quireColumn(String tableName);
}
