package pers.ycy.tableCompare.dto;

import lombok.Data;
import pers.ycy.javacode.mvcgen.dtoGenerate.dto.TableInfoDTO;

import java.util.List;
import java.util.Map;

/***
 * @title: ScheamCompareDTO
 * @projectName java-code
 * @description: TODO
 * @author yangchenyu
 * @date 2021-09-15
 */
@Data
public class ScheamCompareDTO {

    /**
     * 库表对比结果
     */
    private Map<TableInfoDTO, Integer> map ;

    /**
     * 表字段对比结果
     */
    private List<ColumnCompareDTO> compareDTOS ;
}
