package com.onekk.gen.dto;

import lombok.Data;

@Data
public class OnekkTableColumn {

    /**
     * 数据库字段名
     */
    private String columnName;
    /**
     * 字段类型
     */
    private String dataType;
    /**
     * 字段注释
     */
    private String columnComment;
    /**
     * 主键
     */
    private String columnKey;

}
