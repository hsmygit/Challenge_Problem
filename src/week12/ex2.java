package week12;
import java.util.Scanner;
class ex2 extends Converter{
    public ex2(double ratio){
        this.ratio = ratio;
    }
    @Override
    protected double convert(double src){
        return src/ratio;
    }
    @Override
    protected String srcString(){return "Km";}
    @Override
    protected String destString(){return "mile";}

    public static void main(String[] args){
        ex2 toMile = new ex2(1.6); //1마일은 1.6Km
        toMile.run();
    }
}
