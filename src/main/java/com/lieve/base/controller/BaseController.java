package com.lieve.base.controller;
/**
 * @version 1.0
 * @author <a> href="mailto:sunyoboy@gmail.com">sunyoboy</a>
 * @since 2018/10/13 下午6:47
 */

import com.lieve.base.common.enums.Season;
import com.lieve.base.common.enums.Unit;
import com.lieve.base.common.enums.Weekday;
import com.lieve.base.common.exception.BizException;
import com.lieve.base.service.BaseService;

import java.lang.invoke.MethodHandles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    private static final Logger logger = LoggerFactory
        .getLogger(MethodHandles.lookup().lookupClass());

    @Autowired
    private BaseService baseService;

    @PostMapping("/hello")
    public ResponseEntity queryMessage(@RequestParam Season season) {
        baseService.describe(season);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @PostMapping("/world")
    public ResponseEntity queryMessage(@RequestParam Weekday weekday) {
        baseService.describe(weekday);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @PostMapping("/hi")
    public ResponseEntity queryMessage(@RequestParam int unitValue) throws BizException {
        baseService.doStuff();
        baseService.traversal();
        Unit unit = Unit.getUnit(unitValue);
        if (!ObjectUtils.isEmpty(unit)) {
            baseService.describe(unit);
        }
        return new ResponseEntity<>("", HttpStatus.OK);
    }

}
