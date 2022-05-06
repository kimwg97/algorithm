package Baekjoon;

import java.awt.*;
import java.util.*;

public class N1260 {

    int n, m, v;
    int[] check;
    ArrayList<ArrayList<Integer>> line = new ArrayList<>();

    public void N1260(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        v = sc.nextInt();

        check = new int[n+1];
        for(int i = 0; i < m+1; i++) line.add(new ArrayList<>());

        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            line.get(a).add(b);
            line.get(b).add(a);
        }

        System.out.print(v + " ");
        BFS();

    }

    public void BFS(){
        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.add(v);
        check[v] = 1;

        while(!q.isEmpty()){
            int len = q.size();

            for(int i = 0; i < len; i++) {
                int now = q.poll();
                int nowSize = line.get(now).size();

                for(int j = 0; j < nowSize; j++){
                    if(check[line.get(now).get(j)] == 0) {
                        check[line.get(now).get(j)] = 1;
                        q.add(line.get(now).get(j));
                    }
                }
            }

            for(int x : q){
                System.out.print(x + " ");
            }
            System.out.println();


        }
    }
}
