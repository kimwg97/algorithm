package com.company;

public class BinarySearch {
    public int search(int[] list, int start, int end, int m){
        int o = (int) (end + start)/2;
        if (list[o] > m) return search(list, start, o, m);
        else if (list[o] < m) return search(list, o, end, m);
        else return o+1;
    }
}
