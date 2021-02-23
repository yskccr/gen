package com.onekk.gen.dto;

import lombok.Data;

@Data
public class OnekkTabelColunmnAttributes {
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

    /**
     *  属性名称(第一个字母大写)，如：user_name => UserName
     */
    private String attrName;

    /**
     * 属性名称(第一个字母小写)，如：user_name => userName
     */
    private String attrNameUn;

    /**
     * 属性类型
     */
    private String attrType;

}
