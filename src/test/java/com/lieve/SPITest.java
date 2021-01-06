package com.lieve;

import com.lieve.spi.Service;
import com.lieve.spi.impl.ServiceImpl;
import org.junit.Test;
import org.springframework.core.io.support.SpringFactoriesLoader;

import java.util.ServiceLoader;

/**
 * @author sunlijiang
 * @date 2019/7/3
 */
public class SPITest {

    ServiceLoader<Service> serviceLoader = ServiceLoader.load(Service.class);

    @Test
    public void testSPI() {
        Service service = getService();
        System.out.println(service.loadService());
        System.out.println(service.unloadService());
    }



    Service getService() {
        Service service = null;

        for (Service instance : serviceLoader) {
            System.out.println("out." + instance.loadService());
            service = instance;
        }
        return service;
    }

    @Test
    public void testFactoryLoader() {
        SpringFactoriesLoader springFactoriesLoader;
    }
}
