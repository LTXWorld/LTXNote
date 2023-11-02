package DateEEE.exer2;

import java.time.LocalDateTime;

/**
 * ClassName: Exer02
 * Package:DateEEE.exer2
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/18 08:53
 */
public class Exer02 {
    public static void main(String[] args) {
//        Calendar calendar = Calendar.getInstance();
//        Date date = calendar.getTime();
//        System.out.println("你的生日为： " + date);
//
//        calendar.add(Calendar.DAY_OF_YEAR,100);
//        Date newDate = calendar.getTime();
//        System.out.println("100天以后是 " + newDate);
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        LocalDateTime localDateTime = now.plusDays(100);
        System.out.println("100天以后" + localDateTime);
    }
}
