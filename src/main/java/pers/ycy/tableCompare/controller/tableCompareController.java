package pers.ycy.tableCompare.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.ycy.javacode.system.WrapperResponse;
import pers.ycy.tableCompare.dto.ScheamCompareDTO;
import pers.ycy.tableCompare.service.TableCompareService;

/**
 * @Description: 库表对比工具
 * @Author: ycy
 * @Date: 2021-09-13
 */
@RestController
@Api(tags = "库表对比工具")
@RequestMapping("pers/ycy/tableCompare")
public class tableCompareController {
    @Autowired
    private TableCompareService tableCompareService;

    /**
     * 查询库表对比结果
     */
    @ApiOperation("查询库表对比结果")
    @GetMapping("/getTableCompareResult")
    public WrapperResponse<ScheamCompareDTO> getTableCompareResult() throws Exception {
        return tableCompareService.getTableCompareResult();
    }
}
