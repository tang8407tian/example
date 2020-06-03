package com.ttac.service.mybatis;

import com.google.common.collect.Lists;
import com.ttac.service.mybatis.controller.DemoController;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Objects;

/**
 * description:
 *
 * @author bang.tang
 * @date 2019/10/23--10:15
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class DemoTest {
    @Autowired
    private DemoController demoController;

    @Test
    public void ListTest(){
        List<String> list = Lists.newArrayList();
        list.forEach(c->log.info("ss:{}",c));
    }


    @Test
    public void logLogTest(){
        String hashed = BCrypt.hashpw("123123", BCrypt.gensalt());
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode = encoder.encode("111111");
        String encode1 = encoder.encode("123123");
        boolean matches = encoder.matches("111111", encode);
        log.info("encode:{}", encode);
        log.info("encode1:{}", encode1);
        log.info("matches:{}", matches);
        String s = BCrypt.hashpw("123123",hashed);
        log.info("hashed:{}", hashed);
        log.info("s:{}",s);
        log.info("flag:{}", Objects.equals(hashed, s));

//        PasswordEncoder
    }


//    @Autowired
//    private StaffInfoMapper staffInfoMapper;
//
//
//    @GetMapping("/updatePassword")
//    @ApiOperation(value = "修改密码")
//    @CheckToken(required = false)
//    @ApiImplicitParams({
//            @ApiImplicitParam(paramType = "header", name = "token", dataType = "String", required = true, value = "Bearer "),
//    })
//    public ResponseEntity updatePassword() {
//
//        List<StaffInfo> infos = staffInfoMapper.selectList(Wrappers.query());
//        if (CollectionUtils.isNotEmpty(infos)){
//            for (StaffInfo info : infos) {
//                BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//                String encode = encoder.encode(info.getStaffPwd());
//                log.info("修改后密码:{}", encode);
//                info.setStaffPwd(encode);
//                staffInfoMapper.updateById(info);
//            }
//        }
//
//        ResponseEntity entity = new ResponseEntity();
//        return entity;
//    }

    @Test
    public void formate(){
        BigDecimal bigDecimal = new BigDecimal("39.990475");
        BigDecimal bigDecimal2 = new BigDecimal("39.990475223121");
        BigDecimal bigDecimal3 = new BigDecimal("12339.990475223121");
        String b = "12339.990475223121";
        DecimalFormat df = new DecimalFormat("#.######");
        String format = df.format(bigDecimal);
        String format1 = df.format(bigDecimal2);
        String format2 = df.format(bigDecimal3);
        String format3 = df.format(b);

        log.info("format:{}", format);
        log.info("format:{}", format1);
        log.info("format:{}", format2);
        log.info("format:{}", format3);
    }

}
