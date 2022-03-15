package Baekjoon;

import java.awt.*;
import java.util.Scanner;

public class N1063 {

    Point king, stone;
    String[] command;
    String[] com = {"R","L","B","T","RT","LT","RB","LB"};

    public void N1063(){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        char ky = str.charAt(0);
        int kx = Character.getNumericValue(str.charAt(1));

        str = sc.next();
        char sy = str.charAt(0);
        int sx = Character.getNumericValue(str.charAt(1));

        int n = sc.nextInt();
        command = new String[n];

        king = new Point(kx, ky-65);
        stone = new Point(sx, sy-65);

        for(int i = 0; i < n; i++){
            command[i] = sc.next();
        }

//        for(int i = 0; i < n; i++) System.out.println(com[4].equals(command[i]));

        for(int i = 0; i < n; i++){
            int nx = 9, ny = 9;

            if(com[0].equals(command[i])) {
                ny = king.y + 1;
                if (ny >= 8) continue;
                if (king.x == stone.x && ny == stone.y) {
                    if (stone.y + 1 >= 8) continue;
                    else stone.y = ny + 1;
                }
                if (nx != 9) king.x = nx;
                if (ny != 9) king.y = ny;
            }

            else if(com[1].equals(command[i])) {
                ny = king.y - 1;
                if (ny < 0) continue;
                if (king.x == stone.x && ny == stone.y) {
                    if (stone.y - 1 < 0) continue;
                    else stone.y = ny - 1;
                }
                if (nx != 9) king.x = nx;
                if (ny != 9) king.y = ny;
            }
            else if(com[2].equals(command[i])) {
                nx = king.x - 1;
                if (nx < 1) continue;
                if (nx == stone.x && king.y == stone.y) {
                    if (stone.x - 1 < 1) continue;
                    else stone.x = nx - 1;
                }
                if (nx != 9) king.x = nx;
                if (ny != 9) king.y = ny;
            }
            else if(com[3].equals(command[i])) {
                nx = king.x + 1;
                if (nx >= 9) continue;
                if (nx == stone.x && king.y == stone.y) {
                    if (stone.x + 1 >= 9) continue;
                    else stone.x = nx + 1;
                }
                if (nx != 9) king.x = nx;
                if (ny != 9) king.y = ny;
            }
            else if(com[4].equals(command[i])) {
                nx = king.x + 1;
                ny = king.y + 1;
                if (nx >= 9 || ny >= 8) continue;
                if (nx == stone.x && ny == stone.y) {
                    if (stone.x + 1 >= 9 || stone.y + 1 >= 8) continue;
                    else {
                        stone.x = nx + 1;
                        stone.y = ny + 1;
                    }
                }
                if (nx != 9) king.x = nx;
                if (ny != 9) king.y = ny;
            }
            else if(com[5].equals(command[i])) {
                nx = king.x + 1;
                ny = king.y - 1;
                if (nx >= 9 || ny < 0) continue;
                if (nx == stone.x && ny == stone.y) {
                    if (stone.x + 1 >= 9 || stone.y - 1 < 0) continue;
                    else {
                        stone.x = nx + 1;
                        stone.y = ny - 1;
                    }
                }
                if (nx != 9) king.x = nx;
                if (ny != 9) king.y = ny;
            }
            else if(com[6].equals(command[i])) {
                nx = king.x - 1;
                ny = king.y + 1;
                if (nx < 1 || ny >= 8) continue;
                if (nx == stone.x && ny == stone.y) {
                    if (stone.x - 1 < 1 || stone.y + 1 >= 8) continue;
                    else {
                        stone.x = nx - 1;
                        stone.y = ny + 1;
                    }
                }
                if (nx != 9) king.x = nx;
                if (ny != 9) king.y = ny;
            }
            else if(com[7].equals(command[i])) {
                nx = king.x - 1;
                ny = king.y - 1;
                if (nx < 1 || ny < 0) continue;
                if (nx == stone.x && ny == stone.y) {
                    if (stone.x - 1 < 1 || stone.y - 1 < 0) continue;
                    else {
                        stone.x = nx - 1;
                        stone.y = ny - 1;
                    }
                }
                if (nx != 9) king.x = nx;
                if (ny != 9) king.y = ny;
            }
        }

        System.out.println((char)(king.y + 65) + "" + king.x);
        System.out.println((char)(stone.y + 65) + "" + stone.x);
    }
}
