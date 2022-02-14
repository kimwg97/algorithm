package Baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class N1759 {
    public void N1759(){
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int c = sc.nextInt();
        char[] chars = new char[c];
        char[] result = new char[l];

        for(int i = 0; i < c; i++) chars[i] = sc.next().charAt(0);
        Arrays.sort(chars);
        DFS(chars, result, 0, 0, 0, 0);
    }

    public void DFS(char[] chars, char[]result, int l, int c, int gather, int consonant){
        if(l == result.length && gather >= 1 && consonant >= 2){
            for(char x : result) System.out.print(x + " ");
            System.out.println();
        }else{
            for(int i = c; i < chars.length; i++){
                result[l] = chars[i];
                if(chars[i] == 'a' || chars[i] == 'e' || chars[i] == 'i' || chars[i] == 'o' || chars[i] == 'u') DFS(chars, result, l+1, i+1, gather+1, consonant);
                else DFS(chars, result, l+1, i+1, gather, consonant+1);
            }
        }
    }
}
