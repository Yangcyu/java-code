package pers.ycy.javacode.mvcgen.dtoGenerate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.ycy.javacode.mvcgen.dtoGenerate.dto.DTOFileDTO;
import pers.ycy.javacode.mvcgen.dtoGenerate.bo.GenerateDTOBO;
import pers.ycy.javacode.mvcgen.dtoGenerate.service.GenerateDTOService;
import pers.ycy.javacode.system.WrapperResponse;

/***
 * @title: GenerateDTOServiceImpl
 * @projectName java-code
 * @description: TODO
 * @author yangchenyu
 * @date 2020-12-08
 */
@Service
public class GenerateDTOServiceImpl implements GenerateDTOService {

    @Autowired
    private GenerateDTOBO generateDTOBO;


    @Override
    public WrapperResponse getColumnByTabelName(String tableName) throws Exception {
        return WrapperResponse.success(generateDTOBO.getColumnInfoByTable(tableName));
    }

    @Override
    public WrapperResponse getDTOInfo(DTOFileDTO dtoFileDTO) throws Exception {
        return WrapperResponse.success(generateDTOBO.getDTOInfo(dtoFileDTO));
    }
}
