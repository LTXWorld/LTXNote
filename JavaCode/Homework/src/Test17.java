import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * ClassName: Test17
 * Package:PACKAGE_NAME
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/12/25 10:05
 */
public class Test17 {
    public static void main(String[] args) {
        Solution2 s2 = new Solution2();
        s2.letterCombinations("23");
    }
}
class Solution2 {
    private String path;
    private List<String> result = new ArrayList<>();
    private final String[] wordsMap ={
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };
    public List<String> letterCombinations(String digits) {
        backtracking(digits,0);
        return result;
    }
    private void backtracking(String digits,int index){
        if (index == digits.length()){
            result.add(path);
            return;
        }
        //定位
        int digit = digits.charAt(index) - '0';//将所给字符串中的字符转换为int类型的数字
        String words = wordsMap[digit];//从哈希表中取出对应数字所代表的字符串
        for (int i = 0; i < words.length(); i++) {
            path += words.charAt(i);//处理结点，加入路径
            backtracking(digits,index + 1);//来到新的集合去搜索
            path = path.substring(0,path.length() - 1);//回溯，使用substring取子串
        }
    }
}

