/**
 * ClassName: ${NAME}
 * Package:
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create ${DATE} ${TIME}
 */
import java.util.Arrays;

public class CPermutation {
    private int[] data;
    private int n;

    public CPermutation(int n, int[] initData) {
        this.n = n;
        this.data = initData.clone();
    }

    private int getNextValue(int index) {
        int currentValue = data[index];
        for (int i = currentValue + 1; i <= n; i++) {
            boolean isUsed = false;
            for (int j = 0; j < index; j++) {
                if (data[j] == i) {
                    isUsed = true;
                    break;
                }
            }
            if (!isUsed) return i;
        }
        return -1;
    }

    private boolean contains(int[] arr, int value) {
        for (int v : arr) {
            if (v == value) return true;
        }
        return false;
    }

    public boolean next() {
        for (int i = data.length - 1; i >= 0; i--) {
            int nextValue = getNextValue(i);
            if (nextValue != -1) {
                data[i] = nextValue;
                int nextFill = 1;
                for (int j = i + 1; j < data.length; j++) {
                    while (contains(Arrays.copyOfRange(data, 0, j), nextFill)) {
                        nextFill++;
                    }
                    data[j] = nextFill;
                    nextFill++;
                }
                return true;
            }
        }
        return false;
    }

    public void print() {
        for (int num : data) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CPermutation perm = new CPermutation(4, new int[]{1, 2, 3});
        do {
            perm.print();
        } while (perm.next());
    }
}
