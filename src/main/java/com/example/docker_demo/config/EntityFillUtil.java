package com.example.docker_demo.config;

import com.example.docker_demo.entity.BaseEntity;
import cn.hutool.core.date.DateUtil;
import org.springframework.util.StringUtils;

/**
 * @author cwr
 * @since 2021-12-01
 */
public class EntityFillUtil {

    public static <T extends BaseEntity> void fill(T t) {
        if (StringUtils.isEmpty(t.getId())) {
            t.setCreateTime(DateUtil.date());
            t.setUpdateTime(DateUtil.date());
            t.setDelFlag(0);
        } else {
            t.setUpdateTime(DateUtil.date());
        }
    }

}
