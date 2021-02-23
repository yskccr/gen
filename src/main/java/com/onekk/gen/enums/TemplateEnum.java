package com.onekk.gen.enums;

import lombok.Data;
import lombok.Getter;

/**
 * 模板枚举值
 * @author ysk
 */
@Getter
public enum TemplateEnum {
    Do("template/do.vm","do.vm"),

    Mapper("template/Mapper.vm","Mapper.vm"),

    MapperXml("template/MapperXml.vm","MapperXml.vm"),

    Service("template/Service.vm","Service.vm"),

    ServiceImpl("template/ServiceImpl.vm","ServiceImpl.vm");

    String SourcePath;
    String VmName;

    TemplateEnum(String sourcePath, String vmName) {
        SourcePath = sourcePath;
        VmName = vmName;
    }
}
