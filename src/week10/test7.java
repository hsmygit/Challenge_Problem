package week10;
import javax.swing.*;
import java.awt.*;

public class test7 extends JFrame{
    public test7(){
        setTitle("그래픽 이미지 연습");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.add(new Mypanel());
        contentPane.add(new TitlePanel(),BorderLayout.SOUTH);
        setSize(700,400);
        setVisible(true);
    }
    class Mypanel extends JPanel{
        private ImageIcon icon = new ImageIcon("산리오.jpg");
        private Image img = icon.getImage();
        public Mypanel(){ //패널 배경색 변경
            setBackground(Color.lightGray);
        }
        public void paintComponent(Graphics g){
            super.paintComponent(g);

            int x = getWidth()/4;
            int y = getHeight()/3;

            int img_x = img.getWidth(null)/4;//null은 이미지 관찰자(Observer)를 나타내며, 이미지 크기를 얻기 위해 사용.
            int img_y = img.getHeight(null)/3;

            //첫째 가로 줄
            g.drawImage(img,0,0,x-5,y-5,0,0,img_x,img_y,this);
            g.drawImage(img, x+5, 0, x*2 -5, y-5, img_x, 0, img_x * 2, img_y, this);
            g.drawImage(img, x*2+5, 0, x*3-5, y-5, img_x * 2, 0, img_x * 3, img_y, this);
            g.drawImage(img, x*3+5, 0, x*4, y-5, img_x * 3, 0, img_x * 4, img_y, this);
            //둘째 가로 줄
            g.drawImage(img,0,y+5,x-5,y*2-5,0,img_y,img_x,img_y*2,this);
            g.drawImage(img, x+5, y+5, x*2 -5, y*2-5, img_x, img_y, img_x * 2, img_y*2, this);
            g.drawImage(img, x*2+5, y+5, x*3-5, y*2-5, img_x * 2, img_y, img_x * 3, img_y*2, this);
            g.drawImage(img, x*3+5, y+5, x*4, y*2-5, img_x * 3, img_y, img_x * 4, img_y*2, this);
            //셋째 가로 줄
            g.drawImage(img,0,y*2+5,x-5,y*3,0,img_y*2,img_x,img_y*3,this);
            g.drawImage(img, x+5, y*2+5, x*2 -5, y*3, img_x, img_y*2, img_x * 2, img_y*3, this);
            g.drawImage(img, x*2+5, y*2+5, x*3-5, y*3, img_x * 2, img_y*2, img_x * 3, img_y*3, this);
            g.drawImage(img, x*3+5, y*2+5, x*4, y*3, img_x * 3, img_y*2, img_x * 4, img_y*3, this);

        }
    }
    private class TitlePanel extends JPanel {
        public TitlePanel(){
            setLayout(new FlowLayout(FlowLayout.CENTER));
            setBackground(Color.WHITE);
            JLabel Title = new JLabel("SANRIO CHARATCTERS");
            Title.setForeground(Color.MAGENTA);
            add(Title);
        }
    }
    public static void main(String[] args){
        new test7();
    }
}
