package week6;

import javax.swing.*;
import java.awt.*;

class SouthPanel extends JPanel{
    public SouthPanel(){
        setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel label = new JLabel("계산 결과");
        label.setForeground(Color.WHITE); // 원하는 텍스트 색상 설정.
        add(label);
        add(new JTextField(25)); //텍스트칸의 크기를 설정
        setBackground(Color.BLACK);
    }
}

class CenterPanel extends JPanel {
    public CenterPanel() {
        setLayout(new GridLayout(4, 4, 5, 5));
        for (int i = 0; i < 10; i++) {// 숫자 버튼 만들기
            add(new JButton(Integer.toString(i)));
        }
        add(new JButton("CE"));
        add(new JButton("계산"));
        JButton[] operation = new JButton[4];//연산자 버튼을 배열로 처리해서 관리를 용의 하게함.
        operation[0] = new JButton("+");
        operation[1] = new JButton("-");
        operation[2] = new JButton("x");
        operation[3] = new JButton("/");
        for (int i = 0; i < 4; i++) {
            operation[i].setBackground(Color.YELLOW);
            add(operation[i]);
        }
    }
}
class NorthPanel extends JPanel{
    public NorthPanel(){
        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(new JLabel("수식입력"));
        add(new JTextField(25)); //텍스트칸의 크기를 설정
        setBackground(Color.GRAY);
    }
}

public class Challenge extends JFrame {
    public Challenge(){
        super("계산기 프레임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new BorderLayout());//JFrame의 기본 Layout이 BorderLayout()이기 때문에 생략가능.
        c.add(new NorthPanel(), BorderLayout.NORTH);
        c.add(new CenterPanel(), BorderLayout.CENTER);
        c.add(new SouthPanel(), BorderLayout.SOUTH);

        setSize(400,400);
        setVisible(true);
    }
    public static void main(String[] args){
        new Challenge();
    }
}
