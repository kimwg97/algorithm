package Baekjoon;

import java.util.Scanner;

public class N9095 {

    int T;
    int[] dp;

    public void N9095(){
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

        while (T > 0){
            int n = sc.nextInt();
            dp = new int[n+1];

            for(int i = 1; i <= n; i++) {
                if(i == 1) dp[i] = 1;
                else if(i == 2) dp[i] = 2;
                else if(i == 3) dp[i] = 4;
                else dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
            }

            System.out.println(dp[n]);

            T--;
        }

    }
}
