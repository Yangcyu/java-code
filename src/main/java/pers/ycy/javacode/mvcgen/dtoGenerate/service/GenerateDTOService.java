package pers.ycy.javacode.mvcgen.dtoGenerate.service;

import pers.ycy.javacode.mvcgen.dtoGenerate.dto.DTOFileDTO;
import pers.ycy.javacode.system.WrapperResponse;

/***
 * @title: GenerateDTOService
 * @projectName java-code
 * @description: TODO
 * @author yangchenyu
 * @date 2020-12-08
 */
public interface GenerateDTOService {

    WrapperResponse getColumnByTabelName(String tableName) throws Exception;


    WrapperResponse getDTOInfo(DTOFileDTO dtoFileDTO) throws Exception;

}
