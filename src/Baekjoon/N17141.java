package Baekjoon;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N17141 {
    int n, m;
    int[][] map;
    int[][] brick;
    int[][] copied;
    ArrayList<Point> start = new ArrayList<>();

    public void N17141(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][n];
        brick = new int[n][n];
        copied = new int[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                map[i][j] = sc.nextInt();
                if(map[i][j] == 1) brick[i][j] = 1;
                else if(map[i][j] == 2) start.add(new Point(i, j));
            }
        }

        DFS(0, 0);
    }

    // DFS 에서 보내준 조합을 시작점으로 바이러스가 퍼진다
    public void BFS(){

    }

    // 입력에서 받은 시작 후보들을 조합해서 BFS 에 넘긴다
    public void DFS(int l, int c){
        if(true){

        }else{
            for(int i = c; i < m; i++){

            }
        }
    }
}
