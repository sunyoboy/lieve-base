package com.lieve.base.common.util.eventbus;
/**
 * @version 1.0
 * @author <a> href="mailto:sunyoboy@gmail.com">sunyoboy</a>
 * @since 2018/12/2 下午4:30
 */

import com.google.common.eventbus.Subscribe;
import java.lang.invoke.MethodHandles;
import javax.swing.event.ChangeEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventBusChangeRecorder {

    private static final Logger logger = LoggerFactory
        .getLogger(MethodHandles.lookup().lookupClass());

    @Subscribe public void recordCustomerChange(ChangeEvent event) {
        // recordChange(event.getChange());
    }
}
