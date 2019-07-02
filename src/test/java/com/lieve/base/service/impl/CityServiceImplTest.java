package com.lieve.base.service.impl;

import com.lieve.base.service.CityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @author sunlijiang
 * @date 2019/6/29
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CityServiceImplTest {

    @Resource
    private CityService cityService;

    @Test
    public void executeTransaction() {
        cityService.executeTransaction();
    }

    @Test
    public void executeTransaction2() {
        cityService.executeTransaction2();
    }
}