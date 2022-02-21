package Baekjoon;

import javax.crypto.spec.PSource;
import java.util.Scanner;

public class N16956 {
    int r, c;
    boolean flag = true;
    char[][] pasture;
    int[] dx = {0, -1, 0, 1};
    int[] dy = {1, 0, -1, 0};
    public void N16956(){
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        pasture = new char[r][c];

        for(int i = 0; i < r; i++){
            String inp = sc.next();
            for(int j = 0; j < c; j++) pasture[i][j] = inp.charAt(j);
        }

        Loop1 :
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(pasture[i][j] == 'S'){
                    for(int k = 0; k < 4; k++){
                        int x = dx[k] + j;
                        int y = dy[k] + i;
                        if(x >= 0 && x < c && y >= 0 && y < r && pasture[y][x] == 'W'){
                            System.out.println(0);
                            flag = false;
                            break Loop1;
                        }
                    }
                }
                if(pasture[i][j] == 'W'){
                    for(int k = 0; k < 4; k++) {
                        int x = dx[k] + j;
                        int y = dy[k] + i;
                        if(x >= 0 && x < c && y >= 0 && y < r && pasture[y][x] == '.'){
                            pasture[y][x] = 'D';
                        }
                    }
                }
            }
        }
        if(flag){
            System.out.println(1);
            for(int i = 0; i < r; i++){
                for(int j = 0; j < c; j++) System.out.print(pasture[i][j]);
                System.out.println();
            }
        }
    }
}