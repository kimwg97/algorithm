package Baekjoon;
import java.awt.*;
import java.util.*;

public class N2667 {
    public void n2667(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] board = new char[n][n];
        String s;

        for(int i = 0; i < n; i++){
            s = sc.next();
            int j = 0;
            for(char x : s.toCharArray()) {
                board[i][j] = x;
                j++;
            }
        }

        int placeCount = 0;
        ArrayList<Integer> house = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == '1'){
                    placeCount++;
                    board[i][j] = '0';
                    house.add(BFS(board, new Point(j, i), n));
                }
            }
        }

        Collections.sort(house);
        System.out.println(placeCount);
        for(int i = 0; i < house.size(); i++) System.out.println(house.get(i) + " ");
    }

    public int BFS(char[][] board, Point start, int n){
        Queue<Point> q = new LinkedList<>();
        q.offer(start);
        int count = 1;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        while(!q.isEmpty()){
            int len = q.size();

            for(int i = 0; i < len; i++){
                Point temp = q.poll();
                for(int j = 0; j < 4; j++){
                    int x = temp.x + dx[j];
                    int y = temp.y + dy[j];
                    System.out.println("x: " + x + " y: " + y);
                    if(x >= 0 && x < n && y >= 0 && y < n && board[y][x] != '0'){
                        System.out.println("Change Point: " + x + " " + y);
                        board[y][x] = '0';
                        count++;
                        q.offer(new Point(x, y));
                    }
                }
            }
        }
        return count;
    }

}
