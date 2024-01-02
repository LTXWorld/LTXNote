import java.util.*;

/**
 * ClassName: Test331
 * Package:PACKAGE_NAME
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/1/2 09:27
 */
public class Test331 {
    public static void main(String[] args) {
        Solution331 s = new Solution331();
        List<List<String>> tickets = Arrays.asList(
                Arrays.asList("JFK", "SFO"),
                Arrays.asList("JFK", "ATL"),
                Arrays.asList("SFO", "ATL"),
                Arrays.asList("ATL", "JFK"),
                Arrays.asList("ATL", "SFO")
        );//这tm是什么创建方式？
        s.findItinerary(tickets);
    }
}
class Solution331 {
    private LinkedList<String> path = new LinkedList<>();
    private LinkedList<String> res ;
    public List<String> findItinerary(List<List<String>> tickets) {
        Collections.sort(tickets,(a, b) -> a.get(1).compareTo(b.get(1)));//先对机票进行了排序，ab代表两张不同的机票比较目的地？
        path.add("JFK");//必须以JFK开头
        boolean[] used = new boolean[tickets.size()];
        backtracking(new ArrayList<>(tickets),used);//注意这里要进行强制类型转换或者创建一个新的ArrayList
        return res;
    }
    private boolean backtracking(ArrayList<List<String>> tickets, boolean[] used){
        if (path.size() == tickets.size() + 1){
            res=new LinkedList(path);//可以这样直接把path加进来吗？
            return true;
        }

        for (int i = 0; i < tickets.size(); i++) {//弊端是每次递归回来都要从0开始
            if (!used[i] && tickets.get(i).get(0).equals(path.getLast())){
                //如果当前机票没被使用过且当前机票的起始地和路径中的最后一个城市相同，证明可以使用
                path.add(tickets.get(i).get(1));//将当前机票的目的地加入到路径中
                used[i] = true;
                //其实这里递归为什么要使用if判断比较疑惑:每次进来其实都在判断结束条件，看是否可以结束了。
                if (backtracking(tickets,used)){
                    return true;
                }
                //走到这里证明此路不通，需要回溯
                used[i] = false;
                path.removeLast();
            }
        }
        return false;
    }
}
