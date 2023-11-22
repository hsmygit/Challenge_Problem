package week12;

import java.util.*;

public class ex5 {
    public static void print(Vector<Integer> v){
        int sum = 0;
        Iterator<Integer> it = v.iterator();
        while(it.hasNext()){// 모든 요소 방문
            int n = it.next();// 다음 요소 리턴
            System.out.print(n + " ");
            sum += n;
        }
        System.out.println();
        System.out.println("현재 평균 " + sum/v.size());
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Vector<Integer> v = new Vector<Integer>();
        while(true){
            System.out.print("강수량 입력 (0 입력시 종료)>> ");
            int precipitation = scanner.nextInt();
            if(precipitation == 0)break;
            v.add(precipitation);
            print(v);
        }
        scanner.close();
    }
}
