package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class LRU {
    public void sort(){
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int n = sc.nextInt();
        int[] list = new int[n];
        ArrayList cache = new ArrayList();

        for(int h = 0; h < n; h++) list[h] = sc.nextInt();

        for(int i = 0; i < n; i++){
            if(cache.size() < s) {
                if(cache.contains(list[i])) cache.remove(Integer.valueOf(list[i]));
            }else{
                if(!cache.contains(list[i])) cache.remove(s-1);
                else cache.remove(Integer.valueOf(list[i]));
            }
            cache.add(0, list[i]);
        }
        for(int j = 0; j < s; j++) System.out.print(cache.get(j) + " ");
    }
}
