package com.lieve.base.common.annotation;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;

/**
 * @author sunlijiang
 * @date 2019/8/9
 */
@Component
public class LinuxListServiceImpl implements ListService {
    @Override
    public String showListCmd() {
        return "ls";
    }
}
