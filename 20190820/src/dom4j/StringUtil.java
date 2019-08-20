package dom4j;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lz
 * @data 2019-08-20
 * @comment 描述
 */
public class StringUtil {
    public static BigDecimal converStr2Decimal(String string) {
        return new BigDecimal(string);
    }

    public static Integer converStr2Integer(String string) {
        return new Integer(string);
    }

    public static Date convertStr2Date(String string){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return sdf.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object convert(Class tClass, String string) {
        if (tClass.getName().endsWith("BigDecimal")){
            return converStr2Decimal(string);
        } else if (tClass.getName().endsWith("Integer")){
            return converStr2Integer(string);
        } else if (tClass.getName().endsWith("Date")){
            return convertStr2Date(string);
        } else{
            return string;
        }
    }

    public static String convertObj2String(Object object){
        if (object.getClass().getName().endsWith("Date")) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String format = sdf.format(object);
            return format;
        }
        return object.toString();
    }

}
