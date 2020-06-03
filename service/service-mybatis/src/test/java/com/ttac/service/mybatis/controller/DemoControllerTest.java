package com.ttac.service.mybatis.controller;

import com.ttac.common.utils.BigdecimalFormatUtils;
import com.ttac.service.mybatis.vo.CompareToDemo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * description:
 *
 * @author bang.tang
 * @date 2019/12/25--14:49
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class DemoControllerTest {


    @Test
    public void bigDecimalTest(){
        BigDecimal bigDecimal = new BigDecimal("0.4");
        String s = BigdecimalFormatUtils.formatePrice(bigDecimal);
        log.info("s:{}",s);
        BigDecimal bigDecimal1 = new BigDecimal("12324.5465");
        String s1 = BigdecimalFormatUtils.formatePrice(bigDecimal1);
        log.info("si:{}", s1);
        BigDecimal bigDecimal2 = new BigDecimal("12");
        String s2 = BigdecimalFormatUtils.formatePrice(bigDecimal2);
        log.info("s2:{}", s2);
        BigDecimal bigDecimal3 = new BigDecimal("0.33");
        String s3 = BigdecimalFormatUtils.formatePrice(bigDecimal3);
        log.info("s3:{}",s3);
        BigDecimal bigDecimal4 = new BigDecimal("34.56");
        String s4 = BigdecimalFormatUtils.formatePrice(bigDecimal4);
        log.info("s4:{}", s4);
        BigDecimal bigDecimal5 = new BigDecimal("0.354256");
        String s5 = BigdecimalFormatUtils.formatePrice(bigDecimal5);
        log.info("s5:{}",s5);
    }

    @Test
    public void bigDecimalCompareToTest(){
        List<CompareToDemo> list1 = Lists.newArrayList();
        for (int i = 0; i<7; i++){
            CompareToDemo demo = new CompareToDemo();
            demo.setName("demo:"+i);
            double floor = Math.floor(Math.random() * 50);
            demo.setPrice(new BigDecimal(floor));
            demo.setAge(Math.random()*100);
            list1.add(demo);
        }
        list1.forEach(c->{
            log.info("排序前:{}", c);
        });
        list1 = list1.stream().sorted(Comparator.comparing(CompareToDemo::getPrice, BigDecimal::compareTo)).collect(Collectors.toList());
        list1.forEach(c->{
            log.info("123排序后:{}", c);
        });
//        BigDecimal bigDecimal = new BigDecimal("1.345");
//        BigDecimal bigDecimal1 = new BigDecimal("32.5");
//        BigDecimal bigDecimal2 = new BigDecimal("-1.345");
//        BigDecimal bigDecimal3 = new BigDecimal("0.975");
//        List<BigDecimal> list = Lists.newArrayList(bigDecimal, bigDecimal1, bigDecimal2, bigDecimal3);
//        List<BigDecimal> collect = list.stream().sorted(BigDecimal::compareTo).collect(Collectors.toList());
//        log.info("排序后:{}", collect);
    }


    @Test
    public void stringBuilderTest(){
        String prefixVersionKey = "";
        String ak = "sersdcs232";
        StringBuilder builder = new StringBuilder();
        builder.append("pccmin.redis.device.init");
        if (StringUtils.isNotBlank(prefixVersionKey)){
            builder.append(".").append(prefixVersionKey).append(":");
        }
        String s = builder.append(ak.trim()).toString();
        log.info("拼接后字符串:{}",s);
    }

    @Test
    public void stringContains(){
       String d = "SJ12";
        boolean sj = d.contains("SJ");
        boolean contains = "SJ".contains(d);
        log.info("sj:{}", sj);
        log.info("contains:{}", contains);
    }

}