package com.example.docker_demo.vo;

import com.example.docker_demo.entity.HelloEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

/**
 * @Author cwr
 */
@ApiModel("hello-试图对象")
@Data
@NoArgsConstructor
public class HelloVo extends BaseVo{

    /**
     * 鱼塘名称
     */
    @ApiModelProperty("名字")
    private String            name;


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
