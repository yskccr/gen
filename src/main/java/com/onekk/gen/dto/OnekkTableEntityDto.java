package com.onekk.gen.dto;

import lombok.Data;

@Data
public class OnekkTableEntityDto {
    /**
     * 表的名称
     */
    private String tableName;

    /**
     *   表的备注
     */
    private String comments;

    /**
     *类名
     */
    private String className;

    /**
     * 创建者
     */
    private String auther;
}
