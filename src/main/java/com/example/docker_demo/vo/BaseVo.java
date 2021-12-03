package com.example.docker_demo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author cwr
 * @desc
 * @date 2021/12/01
 */
@Data
@NoArgsConstructor
public abstract class BaseVo {
    @ApiModelProperty(value = "主键")
    private Long id;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "修改时间")
    private Date   updateTime;
    @ApiModelProperty(value = "删除状态，0-否，1-是")
    private Integer delFlag;
}
