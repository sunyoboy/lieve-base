package com.lieve.base.common.enums;

import com.lieve.base.common.exception.InvalidValueException;
import lombok.Getter;

/**
 * @author <a> href="mailto:sunyoboy@gmail.com">sunyoboy</a>
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

    public static String getName(int value) throws InvalidValueException {
        for (Unit unit : values()) {
            if (unit.getValue() == value) {
                return unit.getName();
            }
        }
        throw new InvalidValueException();
    }

    public static void main(String[] args) throws InvalidValueException {
        System.out.println(getName(1));
        System.out.println(getName(2));
    }
}
