package com.lieve.base.controller;

import com.lieve.base.service.BaseService;
import com.lieve.base.service.CityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author sunlijiang
 * @date 2019/6/27
 */
@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Resource
    private BaseService baseService;

    @Resource
    private CityService cityService;

    @GetMapping("/start")
    public void startTransaction() {
        baseService.handleTransaction();
    }

    @GetMapping("/execute2")
    public void executeTransaction2() {
        cityService.executeTransaction2();
    }

    @GetMapping("/execute")
    public void executeTransaction() {
        cityService.executeTransaction();
    }
}
