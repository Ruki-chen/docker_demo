package com.example.docker_demo.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * @author cwr
 * @desc
 * @date 2021/12/01
 */
@Data
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date createTime;

    private Date   updateTime;

    private Integer delFlag;
}
