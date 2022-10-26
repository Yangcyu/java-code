package pers.ycy.tableCompare.service.impl;

/***
 * @title: TableCompareServiceImpl
 * @projectName java-code
 * @description: TODO
 * @author yangchenyu
 * @date 2021-09-13
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.ycy.javacode.system.WrapperResponse;
import pers.ycy.tableCompare.bo.TableCompareBO;
import pers.ycy.tableCompare.dto.ScheamCompareDTO;
import pers.ycy.tableCompare.service.TableCompareService;

import java.util.List;

/**
 * @Description: 库表对比工具
 * @Author: ycy
 * @Date: 2021-09-13
 */
@Service
public class TableCompareServiceImpl implements TableCompareService {
    @Autowired
    private TableCompareBO tableCompareBO;
    /**
     * 查询库表对比结果
     */
    @Override
    public WrapperResponse<ScheamCompareDTO> getTableCompareResult() throws Exception {
        return WrapperResponse.success(tableCompareBO.getTableCompareResult());
    }
}
