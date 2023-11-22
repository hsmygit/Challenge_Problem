package week12;
import java.util.Scanner;
abstract class Converter {
    abstract protected double convert(double src);//추상 메소드
    abstract protected String srcString();
    abstract protected String destString();
    protected double ratio;//비율

    public void run(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(srcString() + "을 "+ destString() + "로 바꿉니다.");
        System.out.print(srcString() + "을 입력하세요 >> ");
        double val = scanner.nextDouble();
        double res = convert(val);
        System.out.println("변환 결과: " + res + destString() + "입니다.");
        scanner.close();
    }
}

public class ex1 extends Converter{
    public ex1(double ratio){
        this.ratio = ratio;
    }
    @Override
    protected double convert(double src){
        return src/ratio;
    }

    @Override
    protected String srcString(){ return "원";}

    @Override
    protected String destString(){ return "달러";}

    public static void main(String[] args){
        ex1 toDollar = new ex1(1200); // 1달러는 1200원
        toDollar.run();
    }
}
