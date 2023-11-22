package week12;
public class Challenge {
    static public void main(String[] args){
        Shape [] list = new Shape[3]; // Shape을 상속받은 클래스 객체의 레퍼런스 배열
        list[0] = new Circle(5); //반지음이 5인 원 객체
        list[1] = new Oval(30, 50); // 30x50 사각형에 내접하는 타원
        list[2] = new Rect(20, 40); // 20x40 크기의 사각형

        for(int i = 0 ; i < list.length; i++) list[i].redraw();
        for(int i = 0 ; i < list.length; i++) System.out.println("면적은 " + list[i].getArea());
    }
}

