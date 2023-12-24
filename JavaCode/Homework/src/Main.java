import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: ${NAME}
 * Package:
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create ${DATE} ${TIME}
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.combine(4,2);
    }
}
class Solution{
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    private  void backtracking(int n,int k,int startIndex){
        if (path.size() == k){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n; i++) {
            path.add(i);
            backtracking(n,k,i+1);
            path.remove(path.size() - 1);
        }
    }
    public List<List<Integer>> combine(int n,int k){
        backtracking(n,k,1);
        return result;
    }
}