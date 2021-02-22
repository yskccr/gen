package com.onekk.gen.controller;


import com.onekk.gen.dto.OnekkTableColumnResult;
import com.onekk.gen.dto.OnekkTableEntity;
import com.onekk.gen.dto.OnekkTableEntityDto;
import com.onekk.gen.service.TableColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/gen")
public class GenController {

    @Autowired
    TableColumnService tableColumnService;

    @GetMapping("/column/{tableName}")
    public List<OnekkTableColumnResult> getQuireColumn(@PathVariable("tableName") String tableName){
        return tableColumnService.quireColumn(tableName);
    }

    @PostMapping("/tableEntity")
    public OnekkTableEntity getTableEntity(@RequestBody OnekkTableEntityDto entity){
        return tableColumnService.queryTableEntity(entity.getTableName(),entity.getClassName(),entity.getAuther(),entity.getComments());
    }

}
