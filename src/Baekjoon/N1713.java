package Baekjoon;

import java.awt.*;
import java.util.*;
import java.util.List;

public class N1713 {
    public void N1713() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<Point> a = new ArrayList<>();

        for(int i = 0; i < m; i++){
            int rec = sc.nextInt();
            boolean flag = true;
            int min = Integer.MAX_VALUE;

            // 아직 사진 자리가 있음
            if(a.size() < n){
                for(Point x : a){
                    // 만약 이미 있던 사진이라면
                    if(x.x == rec){
                        x.y = x.y + 1;
                        flag = false;
                    }
                }
                // 처음 들어오는 사진이라면
                if(flag) a.add(new Point(rec, 1));
            }
            // 사진 자리가 없다면
            else{
                for(Point x : a){
                    // 최소 추천수를 찾는다
                    min = Math.min(x.y, min);

                    // 만약 이미 있던 사진이라면
                    if(x.x == rec){
                        x.y = x.y + 1;
                        flag = false;
                    }
                }
                // 처음 들어오는 사진이라면
                if(flag){
                    // 제일 오래된 최소 추천자를 찾는다
                    for(int j = 0; j < a.size(); j++){
                        if(a.get(j).y == min){
                            a.remove(j);            // 해당 추천자는 제거
                            break;
                        }
                    }
                    // 새로운 추천자를 추가
                    a.add(new Point(rec, 1));
                }
            }
        }
        int[] result = new int[a.size()];
        for(int i = 0; i < a.size(); i++){
            result[i] = a.get(i).x;
        }

        Arrays.sort(result);
        for(int i = 0; i < a.size(); i++) System.out.print(result[i] + " ");

    }
}
