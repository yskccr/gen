package com.onekk.gen.service.impl;

import com.onekk.gen.constant.TableConstants;
import com.onekk.gen.dto.OnekkTabelColunmnAttributes;
import com.onekk.gen.dto.OnekkTable;
import com.onekk.gen.dto.OnekkTableColumnResult;
import com.onekk.gen.dto.OnekkTableEntity;
import com.onekk.gen.mapper.OnekkTableColumnMapper;
import com.onekk.gen.service.TableColumnService;
import com.onekk.gen.util.AttrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TableColumnServiceImpl implements TableColumnService {

    @Autowired
    OnekkTableColumnMapper onekkTableColumnMapper;

    @Autowired
    AttrUtil attrUtil;

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
        List<OnekkTableColumnResult> onekkTableColumnResults = onekkTableColumnMapper.quireColumn(tableName);
        List<OnekkTabelColunmnAttributes> Attributes=Conversion(onekkTableColumnResults);
        OnekkTabelColunmnAttributes pk = Attributes.stream().filter(x -> TableConstants.PRIMARY_KEY.equals(x.getColumnKey())).findFirst().get();
        onekkTableEntity.setClassName(StringUtils.capitalize(ClassName));
        onekkTableEntity.setClassnameUn(StringUtils.uncapitalize(ClassName));
        onekkTableEntity.setColumns(Attributes);
        onekkTableEntity.setComments(Comments);
        onekkTableEntity.setPk(pk);
        onekkTableEntity.setTableName(tableName);
        onekkTableEntity.setAuther(auther);
        onekkTableEntity.setComments(Comments);
        return onekkTableEntity;
    }

    private List<OnekkTabelColunmnAttributes> Conversion(List<OnekkTableColumnResult> onekkTableColumnResults) {

        return onekkTableColumnResults.stream().map(x->{
            OnekkTabelColunmnAttributes onekkTabelColunmnAttributes = new OnekkTabelColunmnAttributes();
            onekkTabelColunmnAttributes.setColumnComment(x.getColumnComment());
            onekkTabelColunmnAttributes.setColumnKey(x.getColumnKey());
            onekkTabelColunmnAttributes.setColumnName(x.getColumnName());
            onekkTabelColunmnAttributes.setDataType(x.getDataType());
            onekkTabelColunmnAttributes.setAttrName(StringUtils.capitalize(attrUtil.getAttrName(x.getColumnName())));
            onekkTabelColunmnAttributes.setAttrNameUn(StringUtils.uncapitalize(attrUtil.getAttrName(x.getColumnName())));
            onekkTabelColunmnAttributes.setAttrType(attrUtil.getAttrType(x.getDataType()));

            return onekkTabelColunmnAttributes;
        }
        ).collect(Collectors.toList());
    }
}
