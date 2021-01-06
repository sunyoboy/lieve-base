package com.lieve.base.service.impl;

import com.lieve.base.common.exception.BizException;
import com.lieve.base.entity.City;
import com.lieve.base.entity.User;
import com.lieve.base.mapper.CityMapper;
import com.lieve.base.mapper.UserMapper;
import com.lieve.base.service.CityService;
import edu.princeton.cs.algs4.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;

/**
 * @author sunlijiang
 * @date 2019/6/29
 */
@Slf4j
@Service
public class CityServiceImpl implements CityService {

    @Resource
    private TransactionTemplate transactionTemplate;

    @Resource
    private PlatformTransactionManager platformTransactionManager;

    @Resource
    private UserMapper userMapper;

    @Resource
    private CityMapper cityMapper;


    @Override
    public void executeTransaction() {
        userMapper.queryUser(new User());
        userMapper.queryUser(new User());
        userMapper.queryUser(new User());
        userMapper.queryUser(new User());
        userMapper.queryUser(new User());
        /*transactionTemplate.execute(new TransactionCallback() {
            @Override
            public Object doInTransaction(TransactionStatus transactionStatus) {
                try {
                    userMapper.insert(User.builder().age(3).name("age").build());
                    cityMapper.insert(City.builder().name("zhengzhou").state("open").build());
                } catch (Exception e) {
                    transactionStatus.setRollbackOnly();
                    log.info("e : {}",e);
                }
                return null;
            }
        });*/
    }

    @Override
    public void executeTransaction2() {
        TransactionStatus status = platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
        try {
            userMapper.insert(User.builder().age(3).name("age").build());
            cityMapper.insert(City.builder().id(6).name("zhengzhou").state("open").build());
            platformTransactionManager.commit(status);
            log.info("commit transaction");
        } catch (Exception e) {
            platformTransactionManager.rollback(status);
            log.info("e : {}", e);
            throw new BizException(e);
        }

    }


}
