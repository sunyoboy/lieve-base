package com.lieve.base.common.enums;

import lombok.Getter;

/**
 * @author <a> href="mailto:sunlijiang@didichuxing.com">sunlijiang</a>
 * @version 1.0
 * @since 2018/10/13 下午7:05
 */
public enum Unit {
    A("甲", 1), B("乙", 2);

    @Getter
    private String name;

    @Getter
    private int value;

    Unit(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public static Unit getUnit(int value) {
        for (Unit color : values()) {
            if (color.getValue() == value) {
                return color;
            }
        }
        throw new IndexOutOfBoundsException("Invalid value");
    }

}
