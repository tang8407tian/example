package com.ttac.service.mybatis.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * description:
 *
 * @author bang.tang
 * @date 2020/8/8--14:10
 */
@Aspect
@Slf4j
@Component
public class AnnotationAopTest {

//    @Around("@annotation(com.ttac.service.mybatis.aop.LockTest)")
    @Around("@annotation(lockTests)")
    public Object test(ProceedingJoinPoint point, LockTest lockTests) throws Exception{
        Object[] args = point.getArgs();
        for (Object arg : args) {
            log.info("参数:{}",arg);
        }
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        LockTest lockTest = method.getAnnotation(LockTest.class);
        String key = lockTest.key();
        String prefix = lockTest.prefix();
        log.info("key:{},prefix:{}", key, prefix);
        log.info("lockTests的key:{},prefix:{}", lockTests.key(), lockTests.prefix());

        return null;
    }

    @Before("@annotation(lockTests)")
    public Object testBefore(JoinPoint point, LockTest lockTests) throws Exception{
        Object[] args = point.getArgs();
        for (Object arg : args) {
            log.info("参数:{}",arg);
        }
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        LockTest lockTest = method.getAnnotation(LockTest.class);
        String key = lockTest.key();
        String prefix = lockTest.prefix();
        log.info("key:{},prefix:{}", key, prefix);
        log.info("lockTests的key:{},prefix:{}", lockTests.key(), lockTests.prefix());

        return null;
    }
}
