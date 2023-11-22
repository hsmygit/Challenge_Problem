package week12;
class Rect implements Shape{
    private int width, height; // 가로와 세로

    public  Rect (int width,int height){
        this.width = width;
        this.height = height;
    }
    @Override
    public void draw(){
        System.out.println(width + "x"+ height +"크기의 사각형 입니다.");
    }
    @Override
    public double getArea(){
        return width * height;
    }
}
