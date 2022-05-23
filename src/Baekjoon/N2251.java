package Baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class N2251 {

    int a, b, c;
    int[] arr = new int[3];
    ArrayList<Integer> water = new ArrayList<>();

    public void N2251(){
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();

        arr[0] = a;
        arr[1] = b;
        arr[2] = c;

        water.add(c);


    }

    public void DFS(){
        if(arr[0] == 0 && arr[1] != 0){
            water.add(arr[2]);
            return;
        }else{

        }
    }
}
