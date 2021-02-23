package com.onekk.gen.util;

public class TableNameUtil {

    public static String getTableName(String name,String className){

       if(name.contains("do.vm")){
           return className+"Do.java";
       }
       if(name.contains("mapper.vm")){
           return className+"Mapper.java";
       }
       if(name.contains("mapperXml.vm")){
           return className+"Mapper.xml";
       }
       if(name.contains("service.vm")){
           return className+"Service.java";
       }
       if(name.contains("serviceImpl.vm")){
           return className+"ServiceImpl.java";
       }
       return name;
    }
}
