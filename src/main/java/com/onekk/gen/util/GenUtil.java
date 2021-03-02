package com.onekk.gen.util;


import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.IoUtil;
import com.onekk.gen.dto.OnekkTableEntity;
import com.onekk.gen.enums.TemplateEnum;
import org.apache.velocity.VelocityContext;


import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 代码生成工具类
 */
public class GenUtil {

    private List<String> getTemplate(String... template){
        LinkedList<String> List = new LinkedList<>();
        List.add(TemplateEnum.Do.getSourcePath());
        List.add(TemplateEnum.Service.getSourcePath());
        return List;
    }


    public void GenCreat(OnekkTableEntity onekkTableEntity, ZipOutputStream zip) throws IOException {
        VelocityUtil velocityUtil = new VelocityUtil();
        VelocityUtil init = velocityUtil.init();
        VelocityContext velocityContext = new VelocityContext();
        velocityContext.put("comments",onekkTableEntity.getComments());
        velocityContext.put("author",onekkTableEntity.getAuther());
        velocityContext.put("date", DateUtil.now());
        velocityContext.put("className",onekkTableEntity.getClassName());
        velocityContext.put("columns",onekkTableEntity.getColumns());
        velocityContext.put("tableName",onekkTableEntity.getTableName());
        Map<String, String> context = init.getContext(getTemplate(), velocityContext);
        zipFile(context, onekkTableEntity.getClassName(),zip);

    }

    /**
     * 转换成zip文件
     * @param context
     * @param classNme
     * @param zip
     * @throws IOException
     */
    private void zipFile(Map<String, String> context,String classNme, ZipOutputStream zip) throws IOException {
        for(Map.Entry entry: context.entrySet()){
            String key = (String) entry.getKey();
            ZipEntry zipEntry = new ZipEntry(TableNameUtil.getTableName(key, classNme));
            zip.putNextEntry(zipEntry);

            String contens = (String) entry.getValue();
            byte[] bytes = contens.getBytes("UTF-8");


            IoUtil.write(zip,false,bytes);
            zip.closeEntry();
        }
    }
}
