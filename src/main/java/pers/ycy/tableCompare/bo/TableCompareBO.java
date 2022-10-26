package pers.ycy.tableCompare.bo;

import pers.ycy.tableCompare.dto.ScheamCompareDTO;

import java.util.List;

/***
 * @title: TableCompareBO
 * @projectName java-code
 * @description: TODO
 * @author yangchenyu
 * @date 2021-09-13
 */
public interface TableCompareBO {
    /**
     * 查询库表对比结果
     */
    ScheamCompareDTO getTableCompareResult() throws Exception;
}
