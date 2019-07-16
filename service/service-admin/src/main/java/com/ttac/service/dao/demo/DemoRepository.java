package com.ttac.service.dao.demo;

import com.ttac.service.dao.po.example.Demo1;
import org.springframework.data.repository.CrudRepository;

/**
 * description:
 *
 * @author bang.tang
 * @date 2019/5/27--10:09
 */
public interface DemoRepository extends CrudRepository<Demo1, Long> {
}
