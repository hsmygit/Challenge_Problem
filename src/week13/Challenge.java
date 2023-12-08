package week13;
import java.io.*;
import java.util.*;

public class Challenge {
    private String fileName = "Phone.txt";
    private HashMap<String, String> phoneMap = new HashMap<String, String>();

    public Challenge() {}

    private void readPhoneFile(){
        try{
            Scanner fScanner = new Scanner(new FileReader(new File(fileName)));
            while(fScanner.hasNext()) {//파일에 읽을 것이 있는 동안
                String name = fScanner.nextLine();//이름 읽기
                String number = fScanner.nextLine();//전화번호 읽기
                phoneMap.put(name, number);//해시맵에 저장
            }
            fScanner.close();
        }
        catch (IOException e) {//파일을 저장할 수 없는 경우 예외
        e.printStackTrace();
        }

        System.out.println("총 " + phoneMap.size() + "개의 전화번호를 읽었습니다.");
    }
    private void processQuery(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("이름 >>");
            String name = scanner.next();
            if (phoneMap.get(name) != null) { // 해시맵에서 이름(키)으로 검색.
                System.out.println(phoneMap.get(name));
            } else if(name.equals("그만")) { // 그만이 입력될 경우 검색 종료.
                break;
            } else{ //해시맵에 해당 키가 없을 경우.
                System.out.println("찾는 이름이 없습니다.");
            }
        }
        scanner.close();
    }
        public void run(){
            readPhoneFile();
            processQuery();
        }
        public static void main(String[] args){
            Challenge phoneExplorer = new Challenge();
            phoneExplorer.run();
        }
}
