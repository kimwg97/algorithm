package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N12851 {
    boolean[] check;
    public void N12851(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        check = new boolean[100001];

        BFS(n, k);
    }

    public void BFS(int n, int k){
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        check[n] = true;
        int count = 0;
        int min = 100000;                       // 최소 횟수
        int way = 0;                            // 방법 수

        while (!q.isEmpty()){
            int len = q.size();

            for(int i = 0; i < len; i++) {
                int temp = q.poll();
                check[temp] = true;

                if(temp == k){
                    min = Math.min(min, count);
                    if(min == count) way++;
                }
                if(temp * 2 <= 100000 && check[temp * 2] == false) q.add(temp * 2);

                if(temp - 1 >= 0 && check[temp-1] == false) q.add(temp-1);

                if(temp + 1 <= 100000 && check[temp + 1] == false) q.add(temp + 1);
            }
            count++;
            if(min < count){
                System.out.println(min);
                System.out.println(way);
                break;
            }
        }
    }
}
