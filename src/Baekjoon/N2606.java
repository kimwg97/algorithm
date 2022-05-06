package Baekjoon;

import java.util.Scanner;

public class N2606 {

    int n, m;
    int count = 0;
    int[][] map;
    int[] check;

    public void N2606(){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n+1][n+1];
        check = new int[n+1];

        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            map[a][b] = 1;
            map[b][a] = 1;
        }

        check[1] = 1;
        DFS(1);
        System.out.println(count);
    }

    public void DFS(int now){
        for(int i = 1; i < n+1; i++){
            if(map[now][i] == 1 && check[i] == 0){
                check[i] = 1;
                count++;
                DFS(i);
            }
        }
    }
}
