package com.onekk.gen.controller;


import com.onekk.gen.dto.OnekkTableColumn;
import com.onekk.gen.service.TableColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/gen")
public class GenController {

    @Autowired
    TableColumnService tableColumnService;

    @GetMapping("/column/{tableName}")
    public List<OnekkTableColumn> getQuireColumn(@PathVariable("tableName") String tableName){
        return tableColumnService.quireColumn(tableName);
    }

}
