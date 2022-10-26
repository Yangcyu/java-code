package pers.ycy.javacode.mbg.service;

import pers.ycy.javacode.mbg.config.MbgUiConfigDTO;

public interface MbgService {

    Boolean mbgGenerator(MbgUiConfigDTO entity) throws Exception;

    Boolean makeDirs(MbgUiConfigDTO entity) throws Exception;

}
