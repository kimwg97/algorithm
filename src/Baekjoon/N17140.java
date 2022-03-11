package Baekjoon;

import java.util.*;

public class N17140 {
    int r, c, k;
    int max = 3;
    int count = 0;
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public void N17140(){
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        k = sc.nextInt();

        for(int i = 0; i < 3; i++){
            ArrayList<Integer> a = new ArrayList<>();
            for(int j = 0; j < 3; j++) a.add(sc.nextInt());
            list.add(a);
        }

//        System.out.println();
//        C();

        while(list.get(r-1).get(c-1) != k){

            if(count > 100) break;

            System.out.println();
            System.out.println(list.get(r-1).get(c-1) + " " + k );
            System.out.println("행: " + list.size() + ", 열: " + max);

            if(list.size() >= max) R();
            else C();
            count++;

            for(ArrayList<Integer> x : list){
                for(int i : x) System.out.print(i + " ");
                System.out.println();
            }

        }

        if(count > 100) System.out.println(-1);
        else System.out.println(count);
    }

    // 행(세로)이 더 길 때 가로로 한 줄씩 정렬
    public void R(){
        HashMap<Integer, Integer> map;
        System.out.println("R");
        System.out.println();
        for(ArrayList<Integer> x : list){
            map = new HashMap<>();
            for(int i : x){
                // 해쉬 맵에 해당 인덱스가 몇번 들어가있는지 카운팅
                if(i == 0) continue;
                map.put(i, map.getOrDefault(i, 0) + 1);
            }

            // 기존 리스트 비우기
            x.clear();
            // 카운팅 된 수를 기준으로 내림차순으로 정렬
            List<HashMap.Entry<Integer, Integer>> entryList = new LinkedList<>(map.entrySet());
            entryList.sort(new Comparator<HashMap.Entry<Integer, Integer>>() {
                @Override
                public int compare(HashMap.Entry<Integer, Integer> o1, HashMap.Entry<Integer, Integer> o2) {
                    return o1.getValue() - o2.getValue();
                }
            });

            // 내림차순으로 정렬된 맵을 인덱스, 카운팅 순으로 리스트에 새로 넣어준다
            for(HashMap.Entry<Integer, Integer> entry : entryList){
                x.add(entry.getKey());
                x.add(entry.getValue());
            }
            max = Math.max(max, x.size());                  // 제일 긴 리스트 길이가 max 됨
        }
    }

    // 열(가로)이 더 길 때 세로로 한 줄씩 정렬
    public void C(){
        HashMap<Integer, Integer> map;
        int beforeLen = 0;
        System.out.println("C");
        System.out.println();
        for(int i = 0; i < max; i++){
            map = new HashMap<>();

            for(int j = 0; j < list.size(); j++){
                try {
                    // 인덱스가 없을 수 있으므로 try 작성
                    // i 번째를 꺼내고 i 번째를 지우는 느낌으로 -> 아래에서 다시 i 번째 인덱스에 새로 추가함
                    int x = list.get(j).get(i);

                    if(x == 0) continue;
                    map.put(x, map.getOrDefault(x, 0) + 1);
                    list.get(j).remove(i);
                }catch (Exception e){
                    // catch 되었다면 리스트가 끝났다는 의미이므로 다음 리스트로 넘어간다
                    continue;
                }
            }

            // 카운팅 된 수를 기준으로 내림차순으로 정렬
            List<HashMap.Entry<Integer, Integer>> entryList = new LinkedList<>(map.entrySet());
            entryList.sort(new Comparator<HashMap.Entry<Integer, Integer>>() {
                @Override
                public int compare(HashMap.Entry<Integer, Integer> o1, HashMap.Entry<Integer, Integer> o2) {
                    return o1.getValue() - o2.getValue();
                }
            });
//
//            for(HashMap.Entry<Integer, Integer> entry : entryList) {
//                System.out.println("key: " + entry.getKey() + " value: " + entry.getValue());
//            }
//            System.out.println();
            
            // 세로로 수를 추가할 때 기존 list 의 세로보다 길다면 그만큼 세로 리스트를 추가해준다
            int len = (entryList.size() * 2) - list.size();
            if(0 < len){
                for(int j = 0; j < len; j++){
                    list.add(new ArrayList<>());
                }
            }

            int nowLen = entryList.size() * 2;

            if(nowLen > beforeLen){
                for(int j = 0; j < i; i++){
                    for(int h = 0; h < nowLen; h++){
                        try {
                            list.get(h).get(j);
                        }catch (Exception e){
                            list.get(h).add(0, j);
                        }
                    }
                }
            }

            beforeLen = entryList.size() * 2;

            // 내림차순으로 정렬된 맵을 인덱스, 카운팅 순으로 리스트에 새로 넣어준다
            int j = 0;
            for(HashMap.Entry<Integer, Integer> entry : entryList){
                list.get(j).add(i, entry.getKey());
                j++;
                list.get(j).add(i, entry.getValue());
                j++;
            }
        }

        for(ArrayList<Integer> x : list){
            x.removeAll(Arrays.asList(Integer.valueOf(0)));
        }

    }
}
