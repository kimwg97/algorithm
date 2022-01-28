package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {  // 최소 경로 구하기
    public int bfs1(){
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int e = sc.nextInt();
        int[] dis = {-1, 1, 5};
        int[] check = new int [10001];
        int level = 1;

        Queue<Integer> q = new LinkedList();
        q.offer(s);
        check[s] = 1;

        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 0; i < len; i++){
                int x = q.poll();
                for(int j = 0; j < dis.length; j++){
                    int nx = x + dis[j];
                    if( nx == e) return level;
                    if(nx >= 1 && nx <= 10000 && check[nx]==0){
                        q.offer(nx);
                        check[nx] = 1;
                    }
                }
            }
            level++;
        }
        return level;
    }
}
