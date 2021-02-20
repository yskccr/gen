package com.onekk.gen.service.impl;

import com.onekk.gen.dto.OnekkTableColumnResult;
import com.onekk.gen.mapper.OnekkTableColumnMapper;
import com.onekk.gen.service.TableColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableColumnServiceImpl implements TableColumnService {

    @Autowired
    OnekkTableColumnMapper onekkTableColumnMapper;

    @Override
    public List<OnekkTableColumnResult> quireColumn(String tableName) {
        return onekkTableColumnMapper.quireColumn(tableName);
    }
}