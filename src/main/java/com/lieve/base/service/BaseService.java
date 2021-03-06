package com.lieve.base.service;
/**
 * @version 1.0
 * @author <a> href="mailto:sunyoboy@gmail.com">sunyoboy</a>
 * @since 2018/10/13 下午6:52
 */

import com.lieve.base.common.enums.Season;
import com.lieve.base.common.enums.Unit;
import com.lieve.base.common.enums.Weekday;
import com.lieve.base.common.exception.BizException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.invoke.MethodHandles;

import com.lieve.base.common.util.TransactionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BaseService {

    @Resource
    private TransactionUtil transactionUtil;

    private void doSome(int value) {
        System.out.println(value);
    }

    public void handleTransaction() {
        boolean result = transactionUtil.transact(s -> doSome(1));
    }

    private static final Logger logger = LoggerFactory
        .getLogger(MethodHandles.lookup().lookupClass());

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

    public void describe(Weekday weekday) {
        switch (weekday) {
            case 星期一:
                System.out.println(Weekday.星期一 + " is very hot");
                break;
            case 星期二:
                System.out.println(Weekday.星期二 + " is very cold");
                break;
            default:
                break;
        }
    }

    public void describe(Unit unit) {
        switch (unit) {
            case A:
                System.out.println(Unit.A.getName() + " is very hot");
                break;
            case B:
                System.out.println(Unit.B.getName() + " is very cold");
                break;
            default:
                break;
        }
    }

    public void traversal() {
        for (Unit unit : Unit.values()) {
            System.out.println(unit);
        }
    }

    public void doStuff() throws BizException {
        try {
            InputStream inputStream = new FileInputStream("abc.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new BizException(e);
        }
    }
}
