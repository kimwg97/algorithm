package Baekjoon;

import java.util.Scanner;

public class N1052 {
    public void N1052(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();


        int num = n;

        while(true){
            int count = 0;
            String str = Integer.toBinaryString(num);
            for(int i = 0; i < str.length(); i++) if(str.charAt(i) == '1') count++;

            if(count <= k) break;
            num++;
        }

        System.out.println(num - n);

    }
}
