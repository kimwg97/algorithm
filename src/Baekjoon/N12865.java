package Baekjoon;

import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class N12865 {

    int  n, k;
    int[][] dp;
    Point[] thing;

    public void N12865(){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        thing = new Point[n+1];
        dp = new int[n+1][k+1];

        thing[0] = new Point(0, 0);
        for(int i = 1; i <= n; i++) thing[i] = new Point(sc.nextInt(), sc.nextInt());

        Arrays.sort(thing, new MyComparator());

        DP();
    }

    class MyComparator implements Comparator {
        public int compare(Object arg0, Object arg1) {
            Point t1=(Point)arg0;
            Point t2=(Point)arg1;
            if(t1.x != t2.x)
                return t1.x>t2.x? 1:-1;
            else
                return t1.y>t2.y? 1:-1;
        }
    }

    public void DP(){
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= k; j++){
                dp[i][j] = dp[i-1][j];                  // 현재 가방의 무게에서 전에 담았던 물건의 무게를 우선 넣어둠
                if(j - thing[i].x >= 0){                 // 현재 가방의 무게와 현재 물건의 무게에 남는 무게가 있다면
                    // 전에 담았던 물건의 가치 중, 남은 무게의 물건 가치를 찾아 현재 가치와 더하고, 이를 먼저 저장한 값과 비교
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-thing[i].x] + thing[i].y);
                }
            }
        }

        System.out.println(dp[n][k]);
    }
}
