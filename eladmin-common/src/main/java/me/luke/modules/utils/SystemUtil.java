package me.luke.modules.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SystemUtil {

    //获取业务单据类型
    public static String getBizNoteNo(String bizType)
    {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyyMMdd");
        String text = today.format(formatters);
        String result = bizType + text;
        return result;
    }

}
