package com.example.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import cn.hutool.core.annotation.Alias;

/**
 * <p>
 * 
 * </p>
 *
 * @author 
 * @since 2023-03-19
 */
@Getter
@Setter
@ApiModel(value = "Personfile对象", description = "")
public class Personfile implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("入职日期")
    @Alias("入职日期")
    private String hiretime;

    @ApiModelProperty("身份证")
    @Alias("身份证")
    private String idcard;

    @ApiModelProperty("照片")
    @Alias("照片")
    private String avatarUrl;

    @ApiModelProperty("工资")
    @Alias("工资")
    private BigDecimal salary;

    @ApiModelProperty("员工姓名")
    @Alias("员工姓名")
    private String name;

    @ApiModelProperty("员工编号")
    @Alias("员工编号")
    private String number;

    @ApiModelProperty("关联员工的id")
    @Alias("关联员工的id")
    private Integer userid;


}
