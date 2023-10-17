package week5;

public class PositivePoint extends Point{
    public PositivePoint(){
        super(0,0); //this를 하는 이유는 0,0인경우 밑에 생성자의 조건문을 실행할 필요가 없기 때문이라고 생각된다.
    }
    public PositivePoint(int x, int y) {
        super(x, y);
        if(x < 0 || y < 0){ //좌표가 음수일 경우 0,0으로 이동.
            super.move(0,0);
        }
    }
    @Override
    protected void move(int x, int y){// Point의 move() 오버라이딩
        if(x >= 0 && y >= 0)
            super.move(x,y);
        else return;// 점을 이동시키지 않고 그냥 리턴.
    }

    public String toString() {
        return "(" + getX() + "," + getY() + ")의 점";
    }

    public static void main(String[] args) {
        PositivePoint p = new PositivePoint();
        p.move(11,11);
        System.out.println(p.toString() + "입니다.");

        p.move(-5, 5); //객체 p는 음수 공간으로 이동되지 않음
        System.out.println(p.toString() + "입니다.");

        PositivePoint p2 = new PositivePoint();
        System.out.println(p2.toString() + "입니다.");
    }
}
