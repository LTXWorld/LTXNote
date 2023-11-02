package com.ltx.YanYi.FirstLesson;

/**
 * ClassName: C
 * Package:com.ltx.YanYi.FirstLesson
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/9/25 17:34
 */
public class CDigital {
    private int[] digits;
    private int[] maxValues;
    private boolean isFirstIteration;

    public CDigital(int[] maxValues) {
        this.maxValues = maxValues;
        digits = new int[maxValues.length];
        isFirstIteration = true;
    }

    public boolean next() {
        if (isFirstIteration) {
            isFirstIteration = false;
            return true;
        }

        int i = digits.length - 1;
        while (i >= 0 && digits[i] == maxValues[i]) {
            digits[i] = 0;
            i--;
        }

        if (i >= 0) {
            digits[i]++;
            return true;
        } else {
            return false;
        }
    }

    public void print() {
        for (int digit : digits) {
            System.out.print(digit + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] maxValues = {3, 4, 2}; // 每个位置上的最大值
        CDigital digital = new CDigital(maxValues);
        digital.print();

        while (digital.next()) {
            digital.print();
        }
    }
}
