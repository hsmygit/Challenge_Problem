package week12;

import java.util.*;

public class ex4 {
    public static void main(String[] args){
        ArrayList<Character> a = new ArrayList<Character>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("6개의 학점을 빈 칸으로 분리 입력(A/B/C/D/F)>>");
        for(int i = 0; i < 6; i++){
            Character score = scanner.next().charAt(0);
            a.add(score);
        }
        double score=0.0;
        for(int i =0; i < a.size(); i++){
            switch(a.get(i)){
                case 'A' : score += 4.0;
                break;
                case 'B' : score += 3.0;
                break;
                case 'C' : score += 2.0;
                break;
                case 'D' : score += 1.0;
                break;
                default: score += 0.0;
            }
        }
        System.out.print(score/a.size());
        scanner.close();
    }
}
