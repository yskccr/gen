package com.onekk.gen.service.impl;

import com.onekk.gen.constant.TableConstants;
import com.onekk.gen.dto.OnekkTable;
import com.onekk.gen.dto.OnekkTableColumnResult;
import com.onekk.gen.dto.OnekkTableEntity;
import com.onekk.gen.mapper.OnekkTableColumnMapper;
import com.onekk.gen.service.TableColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class TableColumnServiceImpl implements TableColumnService {

    @Autowired
    OnekkTableColumnMapper onekkTableColumnMapper;

    @Override
    public List<OnekkTableColumnResult> quireColumn(String tableName) {
        return onekkTableColumnMapper.quireColumn(tableName);
    }

    @Override
    public OnekkTable queryTableMess(String tableName) {
        return onekkTableColumnMapper.queryTableMess(tableName);
    }

    @Override
    public OnekkTableEntity queryTableEntity(String tableName,String ClassName,String auther,String Comments) {
        OnekkTableEntity onekkTableEntity = new OnekkTableEntity();
        OnekkTable onekkTable = onekkTableColumnMapper.queryTableMess(tableName);
        List<OnekkTableColumnResult> onekkTableColumnResults = onekkTableColumnMapper.quireColumn(tableName);
        OnekkTableColumnResult pk = onekkTableColumnResults.stream().filter(x -> TableConstants.PRIMARY_KEY.equals(x.getColumnKey())).findFirst().get();

        onekkTableEntity.setClassName(StringUtils.capitalize(ClassName));
        onekkTableEntity.setClassnameUn(StringUtils.uncapitalize(ClassName));
        onekkTableEntity.setColumns(onekkTableColumnResults);
        onekkTableEntity.setComments(Comments);
        onekkTableEntity.setPk(pk);
        onekkTableEntity.setTableName(tableName);
        onekkTableEntity.setAuther(auther);
        onekkTableEntity.setComments(Comments);
        return onekkTableEntity;
    }
}
