package Baekjoon;

import java.awt.*;
import java.util.*;

public class N1966 {

    public void N1966(){
        Scanner sc = new Scanner(System.in);
        int g = sc.nextInt();

        // Point 의 x는 순서, y는 중요도
        while(g != 0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            Queue<Point> doc = new LinkedList<>();

            for(int i = 0; i < n; i++){
                int y = sc.nextInt();
                doc.add(new Point(i, y));
            }

            int count = 0;


            while(true){
                Point temp = doc.poll();
                boolean flag = true;

                for(Point x : doc){
                    if(temp.y < x.y) {
                        flag = false;
                        break;
                    }
                }

                if(flag){
                    count++;
                    if(temp.x == m){
                        System.out.println(count);
                        break;
                    }
                }else doc.add(temp);

            }
            g--;
        }
    }
}
