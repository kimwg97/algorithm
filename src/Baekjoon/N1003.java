package Baekjoon;

import java.util.Scanner;

public class N1003 {

    int m;
    int[] dpZero;
    int[] dpOne;
    public void N1003(){
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();

        for(int k = 0; k < m; k++){
            int n = sc.nextInt();
            dpZero = new int[n+1];
            dpOne = new int[n+1];

            for(int i = 0; i <= n; i++) {
                if (i == 0) {
                    dpZero[i] = 1;
                    dpOne[i] = 0;
                } else if (i == 1) {
                    dpZero[i] = 0;
                    dpOne[i] = 1;
                } else {
                    dpZero[i] = dpZero[i - 1] + dpZero[i - 2];
                    dpOne[i] = dpOne[i - 1] + dpOne[i - 2];
                }
            }

            System.out.println(dpZero[n] + " " + dpOne[n]);
        }
    }
}
