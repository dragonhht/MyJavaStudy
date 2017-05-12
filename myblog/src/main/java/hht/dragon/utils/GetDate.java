package hht.dragon.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 获取时间.
 * <p>
 * User : Dragon_hht
 * Date : 17-3-17
 * Time : 下午9:38
 */
public class GetDate {

    /**
     * 获得当前时间(精确到秒).
     *
     * @return 当前时间
     */
    public static String getDate() {
        Date date = new Date();
        SimpleDateFormat formatter;

        formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return formatter.format(date);
    }

    /**
     * 获得当前时间(精确到天).
     *
     * @return 当前时间
     */
    public static String getDateDay() {
        Date date = new Date();
        SimpleDateFormat formatter;

        formatter = new SimpleDateFormat("yyyy-MM-dd");

        return formatter.format(date);
    }

    /**
     * 日期的延后和提前.
     *
     * @param num 天数
     *
     * @return 结果日期
     */    public static String addDateDay(int num) {
        Calendar calendar = Calendar.getInstance();

        calendar.add(Calendar.DAY_OF_MONTH, num);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        return simpleDateFormat.format(calendar.getTime());
    }

}
