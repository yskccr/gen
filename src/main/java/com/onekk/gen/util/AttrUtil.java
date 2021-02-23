package com.onekk.gen.util;

import cn.hutool.setting.dialect.Props;
import com.onekk.gen.config.TableEntityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class AttrUtil {

    @Autowired
    TableEntityConfig tableEntityConfig;

    public  String getAttrType(String dataType){
        Props props = tableEntityConfig.getPropertiesConfiguration();
        return props.containsKey(dataType)? (String) props.get(dataType) :"String";
    }

    public String getAttrName(String coolumnName){
        coolumnName = coolumnName.toLowerCase();
        coolumnName = conversion(coolumnName);
        return coolumnName;
    }

    private String conversion(String coolumnName) {
        StringBuilder stb = new StringBuilder();

        String[] s = coolumnName.split("_");
        if(s.length>1){
            stb.append(s[0]);
            for(int i=1;i<s.length;i++){
                stb.append(StringUtils.capitalize(s[i]));
            }
        }else {
            stb.append(s[0]);
        }
        return stb.toString();
    }


}
