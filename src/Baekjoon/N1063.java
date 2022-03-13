package Baekjoon;

import java.util.Scanner;

public class N1063 {
    char kx, sx;
    int ky, sy;
    int n;
    String[] command;
    int[][] map = new int[8][8];

    public void N1063(){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        kx = str.charAt(0);
        ky = Character.getNumericValue(str.charAt(1));
        str = sc.next();
        sx = str.charAt(0);
        sy = Character.getNumericValue(str.charAt(1));
        n = sc.nextInt();
        command = new String[n];

        for(int i = 0; i < n; i++){
            command[i] = sc.next();
        }

        int s = sy;
        int k = ky;

        int k2 = kx-65;
        int s2 = sx-65;

        // k2 좌우  k 상하
        for(int i = 0; i < n; i++){
            int nx = 9, ny = 9;
            if(command[i] == "R"){
                ny = k2+1;
                if(ny >= 8) continue;
                if(nx == s && ny == s2){
                    if(s2 + 1 >= 8) continue;
                    else s2++;
                }
            }
            else if(command[i] == "L"){
                ny = k2-1;
                if(ny < 0) continue;
                if(nx == s && ny == s2){
                    if(s2 - 1 < 0) continue;
                    else s2--;
                }
            }
            else if(command[i] == "B"){
                nx = k+1;
                if(nx >= 8) continue;
                if(nx == s && ny == s2){
                    if(s + 1 >= 8) continue;
                    else s++;
                }
            }
            else if(command[i] == "T"){
                nx = k-1;
                if(nx < 0) continue;
                if(nx == s && ny == s2){
                    if(sx - 1 < 0) continue;
                    else s--;
                }
            }
            else if(command[i] == "RT"){
                nx = k-1;
                ny = k2+1;
                if(nx< 0 || ny >= 8) continue;
                if(nx == s && ny == s2){
                    if(s2 + 1 >= 8 || s - 1 < 0) continue;
                    else{
                        s2++;
                        s--;
                    }
                }
            }else if(command[i] == "LT"){
                nx = k-1;
                ny = k2-1;
                if(ny < 0 || nx < 0) continue;
                if(nx == s && ny == s2){
                    if(s2 - 1 < 0 || s - 1 < 0) continue;
                    else{
                        s2--;
                        s--;
                    }
                }
            }
            else if(command[i] == "RB"){
                nx = k+1;
                ny = k2+1;
                if(ny >= 8 || nx >= 8) continue;
                if(nx == s && ny == s2){
                    if(s2 + 1 >= 8 || s + 1 >= 8) continue;
                    else{
                        s2++;
                        s++;
                    }
                }
            }
            else if(command[i] == "LB"){
                nx = k+1;
                ny = k2-1;
                if(ny < 0 || nx >= 8) continue;
                if(nx == s && ny == s2){
                    if(s2 - 1 < 0 || s + 1 >= 8) continue;
                    else{
                        s2--;
                        s++;
                    }
                }
            }
            if(nx != 9 && ny != 9){
                k = nx;
                k2 = ny;
            }
        }

        System.out.println((char)(k2+65) + "" + k);
        System.out.println((char)(s2+65) + "" + s);




    }
}
