package pers.ycy.javacode.mbg.config;

import lombok.Data;

@Data
public class MbgUiConfigEntity {

    private String entityTargetProject;

    private String entityTargetPackage;

    private String daoTargetProject;

    private String daoTargetPackage;

    private String mapperTargetProject;

    private String mapperTargetPackage;

    private String tableName;
}
