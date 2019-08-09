package com.lieve.base.common.annotation;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author sunlijiang
 * @date 2019/8/9
 */
@Component
public class WindowListServieImpl implements ListService {
    @Override
    public String showListCmd() {
        return "dir";
    }
}
