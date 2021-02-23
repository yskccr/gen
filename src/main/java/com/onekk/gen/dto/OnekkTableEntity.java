package com.onekk.gen.dto;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class OnekkTableEntity {
    /**
     * 表的名称
     */
    private String tableName;

    /**
     *   表的备注
     */
    private String comments;

    /**
     * 表的主键
     */
    private OnekkTabelColunmnAttributes pk;

    /**
     * 表的列名(不包含主键)
     */
    private List<OnekkTabelColunmnAttributes> columns;

    /**
     *  类名(第一个字母大写)，如：sys_user => SysUser
     */
    private String className;

    /**
     * 类名(第一个字母小写)，如：sys_user => sysUser
     */
    private String classnameUn;

    /**
     * 创建者
     */
    private String auther;

    /**
     * 额外参数
     */
    private Map paremMap;


}
