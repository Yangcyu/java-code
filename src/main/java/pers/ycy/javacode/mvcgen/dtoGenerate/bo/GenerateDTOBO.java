package pers.ycy.javacode.mvcgen.dtoGenerate.bo;

import pers.ycy.javacode.mvcgen.dtoGenerate.dto.DTOFileDTO;
import pers.ycy.javacode.mvcgen.dtoGenerate.dto.ColumnInfoDTO;

import java.util.List;

/***
 * @title: GenerateDTOBO
 * @projectName java-code
 * @description: TODO
 * @author yangchenyu
 * @date 2020-12-08
 */
public interface GenerateDTOBO {

    List<ColumnInfoDTO> getColumnInfoByTable(String tableName) throws Exception;

    String getDTOInfo(DTOFileDTO dtoFileDTO) throws Exception;


}
