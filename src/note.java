import java.util.Scanner;
public class note {
    public static void main(String[] args) {
        String a = "asd";
        String b = a;
        int [] c = new int[]{1,2,3};
        int [] d = c;

        System.out.println(a);
        System.out.println(b);
        b = b+"asd"; //String 클래스는 기존 문자열을 수정할 수 없다.
        // 문자열의 내용을 변경하면 새로운 문자열 객체를 생성한다.
        System.out.println(c[0]);
        System.out.println(b);
        d[0] = 3;
        System.out.println(c[0]);
        System.out.println(d[0]);
        Scanner scanner = new Scanner(System.in);
        String h = scanner.next();
        int row = h.codePointAt(0);
        System.out.println(row);
        scanner.close();
    }
}
