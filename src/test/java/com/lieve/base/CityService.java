package com.lieve.base;

import com.lieve.base.entity.City;
import com.lieve.base.mapper.CityMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author sunlijiang
 * @date 2019/6/29
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class CityService {

    @Resource
    private CityMapper cityMapper;

    @Test
    public void test() {
        City city = cityMapper.findByState("b");
        log.info("city : {}", city);
    }
}
