package com.dragon.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ClassDescription
 * <p>
 * User : Dragon_hht
 * Date : 17-3-17
 * Time : 下午9:38
 */
public class getDate {

    public static String getDate() {
        Date date = new Date();
        SimpleDateFormat formatter;

        formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return formatter.format(date);
    }
}
