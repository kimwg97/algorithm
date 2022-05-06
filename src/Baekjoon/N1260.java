package Baekjoon;

import java.util.*;

public class N1260 {

    int n, m, v;
    int[][] map;
    int[] check;

    public void N1260(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        v = sc.nextInt();

        map = new int[n+1][n+1];
        check = new int[n+1];
        check[v] = 1;

        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            map[a][b] = 1;
            map[b][a] = 1;
        }

        System.out.print(v + " ");
        DFS(v);

        System.out.println();

        check = new int[n+1];
        check[v] = 1;
        BFS();


    }

    public void DFS(int now){
        for(int i = 1; i < n+1; i++){
            if(map[now][i] == 1 && check[i] == 0){
                check[i] = 1;
                System.out.print(i + " ");
                DFS(i);
            }
        }
    }

    public void BFS(){
        Queue<Integer> q = new LinkedList<>();
        q.add(v);

        System.out.print(v + " ");

        while (!q.isEmpty()){
            int now = q.poll();

            for(int i = 1; i < n+1; i++){
                if(map[now][i] == 1 && check[i] == 0){
                    check[i] = 1;
                    System.out.print(i + " ");
                    q.add(i);
                }
            }
        }

    }

}
