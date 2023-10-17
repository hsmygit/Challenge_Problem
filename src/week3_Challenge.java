import java.util.Scanner;
import java.util.Arrays;
public class week3_Challenge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 로또 당첨 번호 생성 (중복되지 않는 6개 숫자)
        int [] winningNumbers = new int[6]; //로또 번호.
        int [] userNumbers = new int[6]; //사용자 번호.
        int count = 0; // 번호 일치 갯수.

        winningNumbers = Randomlotto(6);// 1부터 45까지의 무작위 숫자 생성.

        Arrays.sort(winningNumbers); //로또 번호 정렬.

        // 사용자로부터 중복되지 않는 로또 번호 입력 받기.
        for(int i = 0; i < userNumbers.length;i++) {
            System.out.print("로또 번호를 입력하세요 (1부터 45 사이의 숫자, 중복 없이) : ");
            int userNum = scanner.nextInt();
            userNumbers[i] = userNum;
            if(!Duplicatecheck(userNumbers)) { //중복 확인.
                System.out.println("이미 입력한 번호입니다. 중복 없이 입력하세요.");
                i--;}
        }
        Arrays.sort(userNumbers); //사용자 번호 정렬.

        // 로또 번호 출력.
        System.out.println("당첨 번호: "+Arrays.toString(winningNumbers));
        System.out.println("사용자 번호: "+Arrays.toString(userNumbers));

        // 로또 등수 판별.
        for(int i = 0 ; i < winningNumbers.length; i++){
            for(int k = 0 ; k < userNumbers.length ; k++){
                if(winningNumbers[i] == userNumbers[k]) count++;
            }
        }
        // switch-case문을 사용하여 당첨 여부 확인.
        switch (count) {
            case 6: System.out.println("1등입니다. 일치하는 번호가 "+ count +"개입니다.");
                break;
            case 5: System.out.println("2등입니다. 일치하는 번호가 "+ count +"개입니다.");
                break;
            case 4: System.out.println("3등입니다. 일치하는 번호가 "+ count +"개입니다.");
                break;
            case 3: System.out.println("4등입니다. 일치하는 번호가 "+ count +"개입니다.");
                break;
            default: System.out.println("꽝입니다. 일치하는 번호가 "+ count +"개입니다.");
        }
    }
    public static int[] Randomlotto(int length) { // 1에서 45 사이의 무작위 숫자 생성 함수.
        int[] randomArray = new int[length];
        while (true) {
            for (int i = 0; i < length; i++) {
                randomArray[i] = (int) (Math.random() * 45 + 1);
            }
            if(Duplicatecheck(randomArray)) return randomArray; //중복 확인.
        }
    }
    public static boolean Duplicatecheck(int []arry){ //중복 확인 함수.
        for(int i =0;i < arry.length -1;i++){
            if(arry[i] == 0) continue;
            for(int k = i+1 ;k < arry.length;k++){
                if(arry[i] == arry[k]) return false;//중복일 때.
            }
        }return true;//중복 아닐 때.
    }
}


