package com.example.docker_demo.fo;

import com.example.docker_demo.config.EntityFillUtil;
import com.example.docker_demo.entity.HelloEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

/**
 * @Author cwr
 */
@ApiModel("hello-输入对象")
@Data
@NoArgsConstructor
public class HelloFo extends BaseFo{

    /**
     * 鱼塘名称
     */
    @ApiModelProperty("名字")
    private String            name;

    public  HelloFo(HelloEntity helloEntity){
        if(helloEntity != null){
            BeanUtils.copyProperties(helloEntity, this);
        }
    }


    public HelloEntity toHelloEntity() {
        HelloEntity helloEntity = new HelloEntity();
        BeanUtils.copyProperties(this, helloEntity);
        EntityFillUtil.fill(helloEntity);
        return helloEntity;
    }
}
