package com.pumkins.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: dengKai
 * @date: 2022/02/15 22:09
 * @description:
 */

public class DateUtils {
    public static String getYMD() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }
}
