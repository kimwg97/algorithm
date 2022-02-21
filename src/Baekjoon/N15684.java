package Baekjoon;

import java.util.Scanner;

public class N15684 {
    int n, m, h, count;
    int[][] arr;
    boolean flag = false;

    public void N15684(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        h = sc.nextInt();
        arr = new int[h+1][n+1];

        for(int i = 0; i < m; i++) {
            int y = sc.nextInt();
            int x = sc.nextInt();

            arr[y][x] = 1;
            arr[y][x+1] = 2;
        }

        for(int i = 0; i <= 3; i++){
            count = i;
            DFS(0);
            if(flag) {
                System.out.println(count);
                break;
            }
        }
        if(!flag) System.out.println(-1);

    }

    public boolean check(){
        for(int j = 1; j <= n; j++) {
            int start = j;
            for (int i = 1; i <= h; i++) {
                if (arr[i][start] == 1) start++;
                else if (arr[i][start] == 2) start--;
            }
            if(j != start) return false;
        }
        return true;
    }

    public void DFS(int l){
        if(flag) return;
        if(count == l){
            if(check()) flag = true;
            return;
        }else{
            for(int i = 1; i <= h; i++){
                for(int j = 1; j < n; j++){
                    if(arr[i][j] == 0 && arr[i][j+1] == 0){
                        arr[i][j] = 1;
                        arr[i][j+1] = 2;
                        DFS(l+1);
                        arr[i][j] = 0;
                        arr[i][j+1] = 0;
                    }
                }
            }
        }
    }
}
