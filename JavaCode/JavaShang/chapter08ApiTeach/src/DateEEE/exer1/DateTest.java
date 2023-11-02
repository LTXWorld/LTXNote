package DateEEE.exer1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ClassName: DateTest
 * Package:DateEEE.exer1
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/18 08:12
 */
public class DateTest {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy-MM-dd");
        String pattern = "2023-10-18";
        //将字符串转为指定格式的date，解析
        Date date = sdr.parse(pattern);
        //将date类型转换为sqldate类型，不能直接强转，得找到桥梁
        java.sql.Date date1 = new java.sql.Date(date.getTime());

    }
}
