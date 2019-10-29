package com.zss.utils;

public class RegexUtil {
    /**
     * 手机号的正则表达式
     */
    private static final String PHONE_REGEX="^((13[0-9])|(15[^4,\\\\D])|(18[0,5-9]))\\\\d{8}$";


    /**
     *
     * 邮箱的正则表达式
     */
    private static  final  String EMAIL_REGEX="^(\\w)+(\\.\\w+)*@(\\w)+((\\.\\w{2,3}){1,3})$";


    public static boolean isPhone(String value){return value.matches(PHONE_REGEX);}

    public static boolean isEmail(String value){return value.matches(EMAIL_REGEX);}
}
