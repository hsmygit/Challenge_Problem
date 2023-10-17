package week4;

import java.util.Scanner;

class MovieTheater{
    //좌석 배열
    int numRows;
    int numCols;
    String [][] seat;
    //예매 정보 저장 배열
    String [] reseat;
    public MovieTheater(int numRows, int numCols){
        this.numRows = numRows;
        this.numCols = numCols;
        //좌석을 초기화하고 빈 좌석으로 설정.
        seat = new String[numRows+1][numCols+1];
        for(int i =1; i < seat.length;i++)
            for (int k = 1 ;k < seat[i].length;k++) {
                seat[0][0] = " ";
                seat[i][k] = "□"; //'□'는 빈 좌석을 나타냄
                seat[0][k] = String.valueOf(k);// 좌석의 열을 숫자로.
                seat[i][0] = String.valueOf((char)(64+i));// 좌석의 행을 아스키코드를 사용하여 A~ 문자를 넣음.
            }
        reseat = new String[4];// 예매 정보 초기화.
    }

    public void displaySeate(){
        //좌석 조회 메소드
        System.out.println("------영화 좌석------");
        for(int i =0; i < seat.length;i++) {
            for (int k = 0; k < seat[i].length; k++) {
                System.out.print(seat[i][k]+" ");
            }
            System.out.println();
        }
    }

    public boolean reserveSeat(int row, int col, String name, String phoneNumber){
        //예약 하는 메소드
        reseat[0] = String.valueOf(row);
        reseat[1] = String.valueOf(col);
        reseat[2] = name;
        reseat[3] = phoneNumber;
        //'■'는 예약된 좌석을 나타냄.
        if(seat[row][col].equals("■"))return false;
        else  {seat[row][col] = "■"; return true;}
    }

    public boolean cancelReservation(int row, int col){
        //예약 취소 메소드
        if(seat[row][col].equals("□"))return false;
        else {
            seat[row][col] = "□";//'□'는 빈 좌석을 나타냄
            reseat = new String[4];// 예매 정보 초기화
            return true;
        }
    }
    public void displayreservationInfo(String name){
        //예약 정보 조회 메소드
        if (reseat[2].equals(name)){
            System.out.println("예약 정보 >>");
            System.out.println("좌석 : "+(char)(64+Integer.parseInt(reseat[0]))+reseat[1]);
            System.out.println("이름 : "+reseat[2]);
            System.out.println("전화 번호 : "+reseat[3]);
        }else System.out.println("예약 명단에 없는 이름입니다.");
    }
}
public class week4_Challenge {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int numRows = 10;
        int numCols = 10;

        MovieTheater movieTheater = new MovieTheater(numRows, numCols);
        //while(true)를 사용하여 예약 시스템 사용자 입력을 구현.
        while(true){
            System.out.println("1. 좌석 조회");
            System.out.println("2. 좌석 예약");
            System.out.println("3. 좌석 예약 취소");
            System.out.println("4. 예약 정보 조회");
            System.out.println("5. 종료");
            System.out.print("원하는 작업을 선택하세요 (1/2/3/4/5) : ");
            int choice = scanner.nextInt();

        //switch-case문을 사용하여 예약 시스템 구현.
            switch (choice){
                case 1:
                    movieTheater.displaySeate();
                    break;
                case 2:
                    while(true) {
                        System.out.print("좌석을 예약하려면 행(A, B, C, ...)과 열(1, 2, 3, ...)을 입력하세요 (예: A2): ");
                        String row_col = scanner.next();
                        int row = row_col.codePointAt(0)-'A'+1 ; // 사용자가 입력한 문자열에서 첫 번째 문자 (행 정보) 추출: -'A'+1 를 통해 row가 1행부터 시작하도록 함.
                        int col = Integer.parseInt(row_col.substring(1)); // 사용자가 입력한 문자열에서 숫자 부분 (열 정보) 추출 후 정수로 변환
                        System.out.print("이름을 입력하세요: ");
                        String name = scanner.next();
                        System.out.print("전화번호를 입력하세요: ");
                        String phoneNumber = scanner.next();
                        if (movieTheater.reserveSeat(row, col, name, phoneNumber)) {
                            System.out.println("좌석 예약이 완료 되었습니다.");
                            break;
                        }else System.out.println("이미 예약된 좌석이거나 없는 좌석입니다.");
                    }break;
                case 3:
                    while(true) {
                        System.out.print("예약을 취소할 좌석을 입력하세요 (예: A2): ");
                        String row_col = scanner.next();
                        int row = row_col.codePointAt(0)-'A'+1 ; // 사용자가 입력한 문자열에서 첫 번째 문자 (행 정보) 추출: -'A'+1 를 통해 row가 1행부터 시작하도록 함.
                        int col = Integer.parseInt(row_col.substring(1)); // 사용자가 입력한 문자열에서 숫자 부분 (열 정보) 추출 후 정수로 변환
                        if (movieTheater.cancelReservation(row, col)){
                            System.out.println("좌석예약 취소가 완료 되었습니다.");
                            break;
                        }else System.out.println("예약된 좌석이 아닙니다.");
                    }break;
                case 4:
                    System.out.print("예약 정보를 조회할 이름을 입력하세요 : ");
                    String name = scanner.next();
                    movieTheater.displayreservationInfo(name);
                    break;
                case 5:
                    System.out.print("프로그램을 종료합니다.");
                    System.exit(0);
                default:
                    System.out.println("유효하지 않은 선택입니다. 다시 선택하세요.");
            }
        }
    }
}
