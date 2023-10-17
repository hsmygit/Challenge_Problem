package week5;

public class IPTV extends ColorTV{
    private String address;
    public IPTV(String address, int size, int nColors) {
        super(size,nColors);
        this.address = address;
    }
    public void printProperty() {
        System.out.print("나의 IPTV는 "+address+ " 주소의 ");
        super.printProperty();
    }


    public static void main(String[] args) {
        //"192.1.1.2" 주소에 32인치, 2048 해상도
        IPTV iptv = new IPTV("192.1.1.2", 32, 2048);
        iptv.printProperty();
    }

}
