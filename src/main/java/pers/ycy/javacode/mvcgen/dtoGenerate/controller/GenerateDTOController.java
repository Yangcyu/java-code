package pers.ycy.javacode.mvcgen.dtoGenerate.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.ycy.javacode.mvcgen.dtoGenerate.dto.DTOFileDTO;
import pers.ycy.javacode.mvcgen.dtoGenerate.service.GenerateDTOService;
import pers.ycy.javacode.system.WrapperResponse;

@Api(tags = "DTO生成")
@RestController
@RequestMapping("javacode/mvcgen/dtoGenerate")
public class GenerateDTOController {

    @Autowired
    private GenerateDTOService generateDTOService;

    /**
     * @Description: TODO
     * @Param: [tableName]
     * @Return: java.util.List<java.lang.String>
     * @Author: yangchenyu
     * @Date: 2021/6/25 8:13 下午
     */
    @GetMapping("/getColumnByTabelName")
    public WrapperResponse getColumnByTabelName(String tableName) throws Exception{
        return generateDTOService.getColumnByTabelName(tableName);
    }

    @PostMapping("/getDTOInfo")
    public WrapperResponse getDTOInfo(DTOFileDTO dtoFileDTO) throws Exception{
        return generateDTOService.getDTOInfo(dtoFileDTO);
    }

}
