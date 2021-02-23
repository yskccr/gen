package com.onekk.gen.util;


import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.IoUtil;
import com.onekk.gen.dto.OnekkTableEntity;
import org.apache.velocity.VelocityContext;


import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class GenUtil {

    private List<String> getTemplate(String... template){
        LinkedList<String> List = new LinkedList<>();
        List.add("template/do.vm");
        return List;
    }


    public byte[] GenCreat(OnekkTableEntity onekkTableEntity) throws IOException {
        VelocityUtil velocityUtil = new VelocityUtil();
        VelocityUtil init = velocityUtil.init();
        VelocityContext velocityContext = new VelocityContext();
        velocityContext.put("comments",onekkTableEntity.getComments());
        velocityContext.put("author",onekkTableEntity.getAuther());
        velocityContext.put("datetime", DateUtil.now());
        velocityContext.put("className",onekkTableEntity.getClassName());
        velocityContext.put("columns",onekkTableEntity.getColumns());
        velocityContext.put("tableName",onekkTableEntity.getTableName());
        Map<String, String> context = init.getContext(getTemplate(), velocityContext);
        return zipFile(context, onekkTableEntity.getClassName());

    }


    private byte[] zipFile(Map<String, String> context,String classNme) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);
        for(Map.Entry entry: context.entrySet()){
            String key = (String) entry.getKey();
            ZipEntry zipEntry = new ZipEntry(TableNameUtil.getTableName(key, classNme));
            zip.putNextEntry(zipEntry);
            String contens = (String) entry.getValue();
            byte[] bytes = contens.getBytes("UTF-8");
            IoUtil.write(zip,true,bytes);
        }
        byte[] bytes = outputStream.toByteArray();
        IoUtil.close(outputStream);
        return bytes;

    }


}
