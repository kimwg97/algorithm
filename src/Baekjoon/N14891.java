package Baekjoon;

import java.awt.*;
import java.util.Scanner;

public class N14891 {

    int[] g1 = new int[8];
    int[] g2 = new int[8];
    int[] g3 = new int[8];
    int[] g4 = new int[8];

    int k;
    Point[] turn;
    boolean[] work;

    public void N14891(){
        Scanner sc = new Scanner(System.in);
        String str;

        str = sc.next();
        for (int i = 0; i < 8; i++) {
            int a = Character.getNumericValue(str.charAt(i));
            g1[i] = a;
        }

        str = sc.next();
        for (int i = 0; i < 8; i++) {
            int a = Character.getNumericValue(str.charAt(i));
            g2[i] = a;
        }

        str = sc.next();
        for (int i = 0; i < 8; i++) {
            int a = Character.getNumericValue(str.charAt(i));
            g3[i] = a;
        }

        str = sc.next();
        for (int i = 0; i < 8; i++) {
            int a = Character.getNumericValue(str.charAt(i));
            g4[i] = a;
        }

        k = sc.nextInt();
        turn = new Point[k];
        work = new boolean[3];

        for(int i = 0; i < k; i++){
            turn[i] = new Point(sc.nextInt(), sc.nextInt());
        }

        turnGear();

        int point = 0;

        if(g1[0] == 1) point += 1;
        if(g2[0] == 1) point += 2;
        if(g3[0] == 1) point += 4;
        if(g4[0] == 1) point += 8;

        System.out.println(point);
    }

    public void turnGear(){
        for(int i = 0; i < k; i++){
            int gear = turn[i].x;
            int dir = turn[i].y;

            check();

            if(gear == 1){
                if(work[0]) spin(1, dir);
                else{
                    spin(1, dir);
                    spin(2, -dir);

                    if(!work[1]){
                        spin(3, dir);

                        if(!work[2]) spin(4, -dir);
                    }
                }
            }
            else if(gear == 2){
                if(work[0]) spin(2, dir);
                else{
                    spin(2, dir);
                    spin(1, -dir);
                }

                if(!work[1]){
                    spin(3, -dir);

                    if(!work[2]) spin(4, dir);
                }
            }
            else if(gear == 3){
                if(work[2]) spin(3, dir);
                else{
                    spin(3, dir);
                    spin(4, -dir);
                }

                if(!work[1]){
                    spin(2, -dir);

                    if(!work[0]) spin(1, dir);
                }
            }
            else{
                if(work[2]) spin(4, dir);
                else{
                    spin(4, dir);
                    spin(3, -dir);

                    if(!work[1]){
                        spin(2, dir);

                        if(!work[0]) spin(1, -dir);
                    }
                }
            }

            work = new boolean[3];
        }
    }

    public void check(){
        if(g1[2] == g2[6]){
            work[0] = true;
        }
        if(g2[2] == g3[6]){
            work[1] = true;
        }
        if(g3[2] == g4[6]){
            work[2] = true;
        }
    }

    public void spin(int n, int d){
        if(n == 1){
            if(d == 1) {
                int temp = g1[7];
                for (int i = 7; i > 0; i--) {
                    g1[i] = g1[i-1];
                }
                g1[0] = temp;
            }else{
                int temp = g1[0];
                for (int i = 0; i < 7; i++) {
                    g1[i] = g1[i+1];
                }
                g1[7] = temp;
            }
        }
        else if(n == 2){
            if(d == 1) {
                int temp = g2[7];
                for (int i = 7; i > 0; i--) {
                    g2[i] = g2[i-1];
                }
                g2[0] = temp;
            }else{
                int temp = g2[0];
                for (int i = 0; i < 7; i++) {
                    g2[i] = g2[i+1];
                }
                g2[7] = temp;
            }
        }
        else if(n == 3){
            if(d == 1) {
                int temp = g3[7];
                for (int i = 7; i > 0; i--) {
                    g3[i] = g3[i-1];
                }
                g3[0] = temp;
            }else{
                int temp = g3[0];
                for (int i = 0; i < 7; i++) {
                    g3[i] = g3[i+1];
                }
                g3[7] = temp;
            }
        }
        else{
            if(d == 1) {
                int temp = g4[7];
                for (int i = 7; i > 0; i--) {
                    g4[i] = g4[i-1];
                }
                g4[0] = temp;
            }else{
                int temp = g4[0];
                for (int i = 0; i < 7; i++) {
                    g4[i] = g4[i+1];
                }
                g4[7] = temp;
            }
        }
    }

}
