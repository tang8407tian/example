package com.ttac.service.mybatis.controller.txt;

import com.ttac.service.mybatis.vo.ReadTxtVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * description: 读取txt 文件
 *
 * @author bang.tang
 * @date 2019/12/16--15:57
 */
@Api(tags = "读取txt文件api")
@RestController
@RequestMapping("/soa/read/txt/api/controller")
@Slf4j
public class ReadTextApiController {


    @ApiOperation("读取txt")
    @GetMapping("/readTxt")
    public void readTxt() {
        /* 读取数据 */
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("C:/Users/fish/Desktop/20191213_523/20191213MX523-03.txt")),
                    "UTF-8"));
            String lineTxt = null;
            List<ReadTxtVO> list = new ArrayList<>();
            //查看系统默认编码方式
            String property = System.getProperty("file.encoding");
            log.info("系统编码:{}", property);
            //数据以逗号分隔
            while ((lineTxt = br.readLine()) != null) {
                String[] values = lineTxt.split(",");
                ReadTxtVO vo = new ReadTxtVO();
                Class<? extends ReadTxtVO> aClass = vo.getClass();
                Field[] fields = aClass.getDeclaredFields();
                for (int i = 0; i < fields.length-1; i++) {
                    Field field = fields[i];
                    String value = values[i];
                    String d = value;
                    field.setAccessible(true);
                    field.set(vo, value);
                }

                log.info("vo：{}", vo);
                list.add(vo);
            }
            log.info("数量:{},解析后数据:{}",list.size(), list);
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
