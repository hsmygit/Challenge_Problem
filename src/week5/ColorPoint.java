package week5;

class Point{
    private int x,y;
    public Point(int x,int y) {
        this.x = x;
        this.y = y;
    }
    public int getX(){return x;}
    public int getY(){return y;}
    protected void move(int x, int y){ this.x = x; this.y = y;}
    // protected 메서드를 정의 함으로서  private변수를 사용할 수 있다.
}


public class ColorPoint extends Point{
    String color;
    public ColorPoint() {
        this(0,0); //super(0,0);-> 부모 클래스의 생성자를 호출, this -> 같은 클래스 내의 다른 생성자를 호출.
        //this를 사용한 이유는 밑에 생성자의 color을 사용할 수 있기 때문이라고 생각된다.
    }
    public ColorPoint(int x,int y) {
        super(x,y); //super은 생성자의 첫줄에 와야한다.
        this.color="BLACK";
    }
    public void setXY(int x,int y) {
        move(x, y); //생성자의 첫줄에만 super를 사용할 수 있다.
    }
    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        return color + "색의 (" + getX() + "," + getY() + ")의 점";
    }

    public static void main(String[] args) {
        ColorPoint zeroPoint = new ColorPoint(); //BLACK 색에 (0,0) 위치의 점.
        System.out.println(zeroPoint+ "입니다.");

        ColorPoint cp = new ColorPoint(10, 10);
        cp.setXY(10, 11);
        cp.setColor("RED");
        System.out.println(cp.toString() + "입니다.");
    }

}
