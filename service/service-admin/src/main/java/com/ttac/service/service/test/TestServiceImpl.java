package com.ttac.service.service.test;

import com.ttac.service.base.service.IdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * introduce：
 *
 * @date: 2018/10/22
 * @author: bang.tang
 * @time: 14:39
 */
@Service
public class TestServiceImpl implements  TestService{
    @Autowired
    private IdService idService;

    @Override
    public void test() {
        idService.getNextId();
    }
}
