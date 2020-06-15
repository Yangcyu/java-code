package pers.ycy.javacode.business.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/******************************************
 * @Table: clct_bill_b
 * @Description: 缴费信息（税务半责)--单位通知单
 * @author ycy
 * @date   2020-06-15
 ******************************************/
@ApiModel(value="缴费信息（税务半责)--单位通知单")
@Data
public class ClctBill implements Serializable {
    /**
     * 征集通知单编号
     */
    @ApiModelProperty(value="征集通知单编号")
    private String clctBillId;

    /**
     * 唯一记录号
     */
    @ApiModelProperty(value="唯一记录号")
    private String rid;

    /**
     * 经办机构代码
     */
    @ApiModelProperty(value="经办机构代码")
    private String optinsCode;

    /**
     * 业务流水号
     */
    @ApiModelProperty(value="业务流水号")
    private String bizSn;

    /**
     * 当事人编号
     */
    @ApiModelProperty(value="当事人编号")
    private String ptcpId;

    /**
     * 单位编号
     */
    @ApiModelProperty(value="单位编号")
    private String empId;

    /**
     * 人员编号
     */
    @ApiModelProperty(value="人员编号")
    private String psnId;

    /**
     * 统一征收标志
     */
    @ApiModelProperty(value="统一征收标志")
    private String unifClctFlag;

    /**
     * 等额应征缴标志
     */
    @ApiModelProperty(value="等额应征缴标志")
    private String eqlClctFlag;

    /**
     * 当事人征缴计划事件编号
     */
    @ApiModelProperty(value="当事人征缴计划事件编号")
    private String ptcpClctPlanEvtId;

    /**
     * 征集通知单类型
     */
    @ApiModelProperty(value="征集通知单类型")
    private String clctBillType;

    /**
     * 对应费款所属期
     */
    @ApiModelProperty(value="对应费款所属期")
    private String accrym;

    /**
     * 是否参与单位托收
     */
    @ApiModelProperty(value="是否参与单位托收")
    private String empClctFlag;

    /**
     * 金额
     */
    @ApiModelProperty(value="金额")
    private Double amt;

    /**
     * 征集通知接收对象编号
     */
    @ApiModelProperty(value="征集通知接收对象编号")
    private String clctNotcRecObjId;

    /**
     * 征缴方式
     */
    @ApiModelProperty(value="征缴方式")
    private String clctWay;

    /**
     * 当事人银行账号编号
     */
    @ApiModelProperty(value="当事人银行账号编号")
    private String ptcpBankacctId;

    /**
     * 户名
     */
    @ApiModelProperty(value="户名")
    private String acctname;

    /**
     * 银行帐号
     */
    @ApiModelProperty(value="银行帐号")
    private String bankAcct;

    /**
     * 征集通知单据号
     */
    @ApiModelProperty(value="征集通知单据号")
    private String clctNotcDocno;

    /**
     * 到账划拨标志
     */
    @ApiModelProperty(value="到账划拨标志")
    private String arvlTrafFlag;

    /**
     * 到账日期
     */
    @ApiModelProperty(value="到账日期")
    private Date arvlDate;

    /**
     * 通知单发送批次
     */
    @ApiModelProperty(value="通知单发送批次")
    private String billSendBatch;

    /**
     * 发送操作员
     */
    @ApiModelProperty(value="发送操作员")
    private String sendOpter;

    /**
     * 发送日期
     */
    @ApiModelProperty(value="发送日期")
    private Date sendDate;

    /**
     * 发送标志
     */
    @ApiModelProperty(value="发送标志")
    private String sendFlag;

    /**
     * 复核人
     */
    @ApiModelProperty(value="复核人")
    private String rechker;

    /**
     * 复核时间
     */
    @ApiModelProperty(value="复核时间")
    private Date rechkTime;

    /**
     * 复核标志
     */
    @ApiModelProperty(value="复核标志")
    private String inte;

    /**
     * 生成批次
     */
    @ApiModelProperty(value="生成批次")
    private String genaBatch;

    /**
     * 备注
     */
    @ApiModelProperty(value="备注")
    private String memo;

    /**
     * 银行编号
     */
    @ApiModelProperty(value="银行编号")
    private String bankId;

    /**
     * 险种类型
     */
    @ApiModelProperty(value="险种类型")
    private String insutype;

    /**
     * 到账操作员
     */
    @ApiModelProperty(value="到账操作员")
    private String arvlOpter;

    /**
     * 实际到款金额
     */
    @ApiModelProperty(value="实际到款金额")
    private Double actArvlAmt;

    /**
     * 单位应缴金额
     */
    @ApiModelProperty(value="单位应缴金额")
    private Double empRecbAmt;

    /**
     * 个人应缴金额
     */
    @ApiModelProperty(value="个人应缴金额")
    private Double psnRecbAmt;

    /**
     * 应缴滞纳金
     */
    @ApiModelProperty(value="应缴滞纳金")
    private Double recbLatefee;

    /**
     * 利息
     */
    @ApiModelProperty(value="利息")
    private Double interest;

    /**
     * 单位欠费核销事件编号
     */
    @ApiModelProperty(value="单位欠费核销事件编号")
    private String empArraCancEvtId;

    /**
     * 核销标识
     */
    @ApiModelProperty(value="核销标识")
    private String cancFlag;

    /**
     * 核销年月
     */
    @ApiModelProperty(value="核销年月")
    private Date cancYm;

    /**
     * 用途
     */
    @ApiModelProperty(value="用途")
    private String purpose;

    /**
     * 应缴类型
     */
    @ApiModelProperty(value="应缴类型")
    private String recbType;

    /**
     * 创建人
     */
    @ApiModelProperty(value="创建人")
    private String crter;

    /**
     * 创建人姓名
     */
    @ApiModelProperty(value="创建人姓名")
    private String crterName;

    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间")
    private Date crteTime;

    /**
     * 创建机构
     */
    @ApiModelProperty(value="创建机构")
    private String crteOptins;

    /**
     * 经办人
     */
    @ApiModelProperty(value="经办人")
    private String opter;

    /**
     * 经办人姓名
     */
    @ApiModelProperty(value="经办人姓名")
    private String opterName;

    /**
     * 经办时间
     */
    @ApiModelProperty(value="经办时间")
    private Date optTime;

    /**
     * 经办机构
     */
    @ApiModelProperty(value="经办机构")
    private String optins;

    /**
     * 统筹区
     */
    @ApiModelProperty(value="统筹区")
    private String poolarea;

    private static final long serialVersionUID = 1L;
}