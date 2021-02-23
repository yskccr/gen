package com.onekk.gen.config;


import cn.hutool.setting.dialect.Props;

import org.springframework.stereotype.Component;

/**
 *
 * @author ysk
 */
@Component
public class TableEntityConfig {

    public Props getPropertiesConfiguration(){
        return new Props("generator.properties");
    }

}
