package pers.ycy.javacode.business.codeGerenetor.service;

import pers.ycy.javacode.mbg.config.MbgUiConfigDTO;

public interface MbgService {

    Boolean mbgGenerator(MbgUiConfigDTO entity) throws Exception;

    Boolean makeDirs(MbgUiConfigDTO entity) throws Exception;

}