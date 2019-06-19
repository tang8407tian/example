package com.ttac.service.util;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Bao Hongbin
 * @since 2019-05-15
 */
public class BPwdEncoderUtil {

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    /**
     * 用BCryptPasswordEncoder进行加密
     * @param password
     * @return
     */
    public static String  encode(String password){
        return encoder.encode(password);
    }

    /**
     * 加密匹配
     * @param rawPassword
     * @param encodedPassword
     * @return
     */
    public static boolean matches(CharSequence rawPassword, String encodedPassword){
        return encoder.matches(rawPassword,encodedPassword);
    }



}
