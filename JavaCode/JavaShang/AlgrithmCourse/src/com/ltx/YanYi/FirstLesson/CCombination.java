package com.ltx.YanYi.FirstLesson;

/**
 * ClassName: CCombination
 * Package:com.ltx.YanYi.FirstLesson
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/9/25 17:24
 */
import java.util.Arrays;

public class CCombination {
    private int n, m;
    private int[] current;

    public CCombination(int n, int m) {
        this.n = n;
        this.m = m;
        this.current = new int[m];
        for (int i = 0; i < m; i++) {
            this.current[i] = i;
        }
    }

    public boolean next() {
        int i = m - 1;
        while (i >= 0 && this.current[i] == this.n - this.m + i) {
            i--;
        }
        if (i < 0) {
            return false;
        }
        this.current[i]++;
        for (int j = i + 1; j < m; j++) {
            this.current[j] = this.current[j - 1] + 1;
        }
        return true;
    }

    public int[] getCurrent() {
        return this.current;
    }

    public static void main(String[] args) {
        int[][] energy = {
                {10, 5, 1, 4, 6},
                {0, 11, 9, 8, 4},
                {5, 3, 9, 9, 7},
                {4, 4, 5, 12, 6},
                {3, 1, 7, 6, 10}
        };

        int n = 5, m = 3;
        CCombination comb = new CCombination(n, m);
        int maxEnergy = Integer.MIN_VALUE;
        int[] bestTeam = null;

        do {
            int[] current = comb.getCurrent();
            int currentEnergy = calculateEnergy(current, energy);
            if (currentEnergy > maxEnergy) {
                maxEnergy = currentEnergy;
                bestTeam = Arrays.copyOf(current, current.length);
            }
        } while (comb.next());

        System.out.println("Best team: " + Arrays.toString(bestTeam) + ", with energy: " + maxEnergy);
    }

    public static int calculateEnergy(int[] combination, int[][] energy) {
        int totalEnergy = 0;
        for (int i = 0; i < combination.length; i++) {
            for (int j = i + 1; j < combination.length; j++) {
                totalEnergy += energy[combination[i]][combination[j]];
            }
        }
        return totalEnergy;
    }
}

