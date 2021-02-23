package com.onekk.gen.util;


import lombok.extern.slf4j.Slf4j;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class VelocityUtil {
    VelocityEngine ve = null;

    public VelocityUtil  init(){
        // 初始化模板引擎
        ve = new VelocityEngine();
        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        ve.init();
        return this;
    }

    public Map<String,String> getContext(List<String> template, VelocityContext context) throws IOException {
        if(template.size()<1){
            log.error("template 不能为空");
            return null;
        }
        Template t=null;
        Map<String,String> map = new HashMap(4);
        // 输出
        StringWriter sw = new StringWriter();
        for(String temp:template){
            sw.flush();
            t = ve.getTemplate(temp,"UTF-8");
            t.merge(context,sw);
            map.put(temp,sw.toString());
        }
        sw.close();
        return map;
    }




}
