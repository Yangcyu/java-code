package pers.ycy.javacode.mvcgen.dtoGenerate.dto;

import lombok.Data;

import java.util.Objects;

/***
 * @title: TableInfoDTO
 * @projectName java-code
 * @description: TODO
 * @author yangchenyu
 * @date 2021-09-13
 */
@Data
public class TableInfoDTO {

    private String tableName;

    private String remarks;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TableInfoDTO that = (TableInfoDTO) o;
        return tableName.equals(that.tableName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tableName);
    }
}
