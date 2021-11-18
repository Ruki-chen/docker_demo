package com.example.docker_demo.vo;

import com.example.docker_demo.entity.HelloEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * @Author cwr
 */
@ApiModel("hello")
@Data
public class HelloVo {

    @ApiModelProperty("Id")
    private Long              id;
    /**
     * 鱼塘名称
     */
    @ApiModelProperty("名字")
    private String            name;

    public  HelloVo(){
    }

    public  HelloVo(HelloEntity helloEntity){
        if(helloEntity != null){
            BeanUtils.copyProperties(helloEntity, this);
        }
    }


    public HelloEntity toHelloEntity() {
        HelloEntity helloEntity = new HelloEntity();
        BeanUtils.copyProperties(this, helloEntity);
        return helloEntity;
    }
}
