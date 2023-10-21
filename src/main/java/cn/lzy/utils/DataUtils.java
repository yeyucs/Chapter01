package cn.lzy.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 韦盛彪
 * @creat 2023/10/21  15:35
 **/
public class DataUtils {

    public final static String data1 = "yyyy-MM-dd HH:mm:ss";

    public final static String data2 = "yyyy-MM-dd ";

    public static String getData(String dataType) {
        java.util.Date day = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(dataType);
        return sdf.format(day);
    }
}
