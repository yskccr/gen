package com.onekk.gen.controller;


import cn.hutool.core.io.IoUtil;
import cn.hutool.http.HttpResponse;
import com.onekk.gen.dto.OnekkTableColumnResult;
import com.onekk.gen.dto.OnekkTableEntity;
import com.onekk.gen.dto.OnekkTableEntityDto;
import com.onekk.gen.service.TableColumnService;
import com.onekk.gen.util.GenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;


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

    @PostMapping("/creat")
    public void tableCreat(@RequestBody OnekkTableEntityDto entity, HttpServletResponse response) throws IOException {
        OnekkTableEntity onekkTableEntity = tableColumnService.queryTableEntity(entity.getTableName(), entity.getClassName(), entity.getAuther(), entity.getComments());
        GenUtil genUtil = new GenUtil();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);
        genUtil.GenCreat(onekkTableEntity,zip);
        ServletOutputStream out = response.getOutputStream();
        IoUtil.close(zip);
        IoUtil.close(outputStream);
        IoUtil.write(out,true,outputStream.toByteArray());

    }

}
