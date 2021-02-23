package com.onekk.gen.util;


import cn.hutool.core.date.DateUtil;
import com.onekk.gen.dto.OnekkTableEntity;
import org.apache.velocity.VelocityContext;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GenUtil {

    private List<String> getTemplate(String... template){
        LinkedList<String> List = new LinkedList<>();
        List.add("template/do.vm");
        return List;
    }


    public void GenCreat(OnekkTableEntity onekkTableEntity) throws IOException {
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
    }

}
