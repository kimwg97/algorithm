package Baekjoon;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N4991 {
    int n, m;
    char[][] map;
    int[][] check;
    int[][] distance;
    ArrayList<Point> points;
    int dirty;
    int min = Integer.MAX_VALUE;

    int[] selected;
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    public void N4991(){
        Scanner sc = new Scanner(System.in);

        while(true){
            m = sc.nextInt();
            n = sc.nextInt();

            if(m == 0) break;

            map = new char[n][m];
            points = new ArrayList<>();
            dirty = 0;

            for(int i = 0; i < n; i++){
                String str = sc.next();
                for(int j = 0; j < m; j++){
                    map[i][j] = str.charAt(j);
                    if(map[i][j] == 'o') points.add(0, new Point(i, j));
                    else if(map[i][j] == '*'){
                        points.add(new Point(i, j));
                        dirty++;
                    }
                }
            }

            // 시작점까지 포함하여 각 거리를 저장할 배열 생성
            distance = new int[dirty+1][dirty+1];
            selected = new int[dirty+1];

            int result = 0;
            for(int i = 0; i < dirty+1; i++){
                if(BFS(i) == 1){
                    result = -1;
                    break;
                }
            }

            if(result == -1) System.out.println(result);
            else{
                selected[0] = 1;
                DFS(0, 0, 0);
                System.out.println(min);
                min = Integer.MAX_VALUE;
            }
        }
    }

    // 순열로 거리합의 최소를 구함함
   public void DFS(int l, int sum, int now){
        if(l == dirty){
            min = Math.min(min, sum);
            return;
        }else{
            for(int i = 1; i < selected.length; ++i){
                if(selected[i] == 0){
                    selected[i] = 1;
                    DFS(l+1, sum+distance[now][i], i);
                    selected[i] = 0;
                }
            }
        }

    }

    // 각 두 포인트끼리의 거리를 구함
    public int BFS(int now){
        Queue<Point> q = new LinkedList<>();
        Point start = points.get(now);
        q.add(start);

        int d = 0;
        check = new int[n][m];
        check[start.x][start.y] = 1;

        while (!q.isEmpty()){
            Point temp = q.poll();

            for(int i = 0; i < 4; i++){
                int nx = dx[i] + temp.x;
                int ny = dy[i] + temp.y;
                if(nx >= 0 && ny >= 0 && nx < n && ny < m && check[nx][ny] == 0 && map[nx][ny] != 'x'){

                    if(map[nx][ny] == 'o' || map[nx][ny] == '*'){
                        for(int h = 0; h < dirty+1; h++){
                            Point node = points.get(h);
                            if(nx == node.x && ny == node.y){
                                distance[now][h] = check[temp.x][temp.y];
                                distance[h][now] = check[temp.x][temp.y];
                                d++;
                            }
                        }
                    }
                    check[nx][ny] = check[temp.x][temp.y] + 1;
                    q.add(new Point(nx, ny));
                }
            }

        }
        if(d == dirty) return 0;
        else return 1;
    }


}
