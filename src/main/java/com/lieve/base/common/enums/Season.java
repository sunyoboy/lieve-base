package com.lieve.base.common.enums;
/**
 * @version 1.0
 * @author <a> href="mailto:sunyoboy@gmail.com">sunyoboy</a>
 * @since 2018/10/13 下午6:37
 */

import java.lang.invoke.MethodHandles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 优势：
 * (1) 枚举常量更简单
 * (2) 枚举常量稳态型
 * (3) 枚举有内置方法
 * (4) 枚举可以自定义方法
 *
 * 劣势：
 * (1) 枚举类型不能继承
 *
 * 推荐使用枚举类型代替接口常量和类常量
 */
public enum Season {
    SPRING, SUMMER, AUTUMN, WINTER;
}
