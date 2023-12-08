package week2;

import java.util.Scanner;
public class Challenge {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("현재 시간을 입력하세요(HH 형식): ");
    int H = scanner.nextInt();//현재 시간을 입력받는다.
    System.out.print("현재 분을 입력하세요(mm 형식): ");
    int M = scanner.nextInt();//현재 분을 입력 받는다.
    if (H < 0 || H > 23 || M < 0 || M > 59) {System.out.println("올바르지 않은 입력입니다. 시간은0~23, 분은0~59 사이의 값을 입력하세요.");}
    // 현재 시간을 입력하는 거라서 시간은 24시간을 넘을 수 없고, 분은 60분을 넘길 수 없다. (음수 또한 나올 수 없다.)
    else{
        if (H >= 9 && M > 0) {//알람이 울리고 난 후. 9시일 때 분을 생각 해서(&& M > 0) 조건을 추가 했다.
            System.out.print("알람이 울리고"+ (H - 9) + "시간" + M + "분 지났습니다.");}else if(H < 9) { //알람이 울리기 전.
            System.out.print("알람이 울리기까지"+ (8 - H) + "시간" + (60 - M) + "분 남았습니다.");
        }else{// 위의 두 조건을 제외한 때는 9시 정각만 남아있기 때문에 알람이 울리는 것으로 표현했다.
            System.out.print("찌링 짜링~(알람 울리는 중)");
        }scanner.close();
    }
}
}
