package com.onekk.gen.util;

import com.onekk.gen.enums.TemplateEnum;

public class TableNameUtil {

    public static String getTableName(String name,String className){

       if(name.contains(TemplateEnum.Do.getVmName())){
           return className+"Do.java";
       }
       if(name.contains(TemplateEnum.Mapper.getVmName())){
           return className+"Mapper.java";
       }
       if(name.contains(TemplateEnum.MapperXml.getVmName())){
           return className+"Mapper.xml";
       }
       if(name.contains(TemplateEnum.Service.getVmName())){
           return className+"Service.java";
       }
       if(name.contains(TemplateEnum.ServiceImpl.getVmName())){
           return className+"ServiceImpl.java";
       }
       return name;
    }
}
