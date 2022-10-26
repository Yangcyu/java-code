package pers.ycy.tableCompare.service;

import pers.ycy.javacode.system.WrapperResponse;
import pers.ycy.tableCompare.dto.ScheamCompareDTO;

import java.util.List;

/***
 * @title: tableCompareService
 * @projectName java-code
 * @description: TODO
 * @author yangchenyu
 * @date 2021-09-13
 */
public interface TableCompareService {
    /**
     * 查询库表对比结果
     */
    WrapperResponse<ScheamCompareDTO> getTableCompareResult() throws Exception;
}
