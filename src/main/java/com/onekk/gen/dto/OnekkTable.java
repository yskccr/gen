package com.onekk.gen.dto;

import lombok.Data;

import java.util.Date;

@Data
public class OnekkTable {
    /**
     * 表的名称
     */
    private String tableName;

    /**
     *   表的备注
     */
    private String comments;

    /**
     * 数据库引擎
     */
    private String ENGINE;

    /**
     * 创建时间
     */
    private Date creatDate;

}
