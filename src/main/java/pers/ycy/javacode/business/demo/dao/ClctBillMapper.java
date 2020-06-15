package pers.ycy.javacode.business.demo.dao;

import java.util.List;
import pers.ycy.javacode.business.demo.entity.ClctBill;

public interface ClctBillMapper {
    /**
     *@Description  根据主键删除
     */
    int deleteByPrimaryKey(String clctBillId);

    /**
     *@Description  插入
     */
    int insert(ClctBill record);

    /**
     *@Description   根据值分空插入
     */
    int insertSelective(ClctBill record);

    /**
     *@Description  根据主键查询
     */
    ClctBill selectByPrimaryKey(String clctBillId);

    /**
     *@Description  根据主键更新非空字段
     */
    int updateByPrimaryKeySelective(ClctBill record);

    /**
     *@Description  根据值分空更新
     */
    int updateByPrimaryKey(ClctBill record);

    /**
     *@Description  根据dto查询List
     */
    List<ClctBill> queryList(ClctBill record);

    /**
     *@Description   根据值分空批量插入
     */
    int insertBatchSelective(List<ClctBill> records);
}