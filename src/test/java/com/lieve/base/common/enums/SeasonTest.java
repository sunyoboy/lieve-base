package com.lieve.base.common.enums;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author <a> href="mailto:sunyoboy@gmail.com">sunlijiang</a>
 * @version 1.0
 * @since 2018/10/13 下午6:43
 */
public class SeasonTest {

    @Test
    public void season() {
        describe(Season.WINTER);
    }

    public void describe(Season season) {
        switch (season) {
            case SUMMER:
                System.out.println(Season.SUMMER + " is very hot");
                break;
            case WINTER:
                System.out.println(Season.WINTER + " is very cold");
                break;
            default:
                break;
        }
    }

}