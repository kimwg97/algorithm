package com.company;

public class Greedy {
    int[] arr;

    public int Find(int v){
        if(arr[v] == v) return v;
        else return arr[v] = Find(arr[v]);
    }

    public void Union(int fa, int fb){
        int a = Find(fa);
        int b = Find(fb);
        if(a != b) arr[a] = b;
    }

}
