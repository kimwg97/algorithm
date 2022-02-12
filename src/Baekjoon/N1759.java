package Baekjoon;

import com.company.DFS;

import java.util.Scanner;

public class N1759 {
    int consonant = 0, gather = 0;
    public void N1759(){
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int c = sc.nextInt();
        char[] chars = new char[c];
        char[] result = new char[l];

        for(int i = 0; i < c; i++) chars[i] = sc.next().charAt(0);

        DFS(chars, result, 0, 0);
    }

    public void DFS(char[] chars, char[] result, int l, int c){
        if(l == result.length){
            for(char x : result) System.out.print(x + " ");
            System.out.println();
        }else{
            for(int i = c; i < chars.length; i++){
                result[l] = chars[i];
                DFS(chars, result, l+1, i+1);
            }
        }
    }
}
