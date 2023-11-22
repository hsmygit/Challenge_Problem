package week12;

class Oval implements Shape{
    private int width, height; // 가로와 세로

    public  Oval (int width,int height){
        this.width = width;
        this.height = height;
    }
    @Override
    public void draw(){
        System.out.println(width + "x"+ height +"에 내접하는 타원입니다.");
    }
    @Override
    public double getArea(){
        return PI*(width/2.0)*(height/2.0); //타원 면적 공식.
    }
}
