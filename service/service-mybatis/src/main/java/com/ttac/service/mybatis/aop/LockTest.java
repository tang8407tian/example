package com.ttac.service.mybatis.aop;

import java.lang.annotation.*;

/**
 * description:
 *
 * @author bang.tang
 * @date 2020/8/8--14:11
 */
@Target({ElementType.PACKAGE,ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LockTest {

    String prefix() default "lock:";

    String key() default "";
}
