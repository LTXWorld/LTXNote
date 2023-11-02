package StringTest.exer1;

/**
 * ClassName: StringT1
 * Package:StringTest.exer1
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/16 15:04
 */
public class StringT1 {
    String str = "good";
    char[] ch = {'t','e','s','t'};

    public void change(String str, char ch[]){
        str = "test ok";
        ch[0] = 'b';
    }

    public static void main(String[] args) {
        StringT1 ex = new StringT1();
        ex.change(ex.str,ex.ch);
        System.out.println(ex.str);
        System.out.println(ex.ch);
    }
}
