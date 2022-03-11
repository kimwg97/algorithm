package Baekjoon;

import java.util.Scanner;

public class N2947 {
    int[] list = new int[5];
    int n = 5;

    public void N2947(){
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < n; i++){
            list[i] = sc.nextInt();
        }
        Bubble();
    }

    public void listPrint(){
        for(int i = 0; i < n; i++){
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }

    public void Bubble(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n - 1; j++){
                if(list[j] > list[j + 1]){
                    swap(list, j, j+1);
                    listPrint();
                }
            }
        }
    }

    public void swap(int[] list, int i, int j){
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }
}
