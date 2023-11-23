package week11;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Challenge extends JFrame{
    private JLabel resultLabel = new JLabel("계산 결과 출력");
    public Challenge(){
        setTitle("다이얼로그 만들기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();

        c.setLayout(new FlowLayout());
        JButton btn = new JButton("calculate");
        btn.addActionListener(new MyActionListener());//btn에 Action리스너 등록.
        c.add(btn);//모달 다이얼로그를 만드는 버튼 추가.

        resultLabel.setOpaque(true);//Jlabel의 배경을 불투명하게 만든다.
        resultLabel.setBackground(Color.WHITE);
        c.add(resultLabel);//곱의 결과를 출력하는 label 추가.
        setSize(250,200);
        setVisible(true);
    }
    class MyActionListener implements ActionListener{
        private CalcDialog dialog;
        //public MyActionListener(){}//ppt에 부분은 왜 있는지 모르겠다.(나는 사용하지 않았다.)
        public void actionPerformed(ActionEvent e){
            dialog = new CalcDialog(Challenge.this);// 새로운 다이얼로그 객체 생성.
            dialog.setVisible(true); //이벤트가 발생하면, 다이얼로그를 화면에 띄운다.

            int result = dialog.getResult();
            resultLabel.setText(String.valueOf(result));//곱셈 결과를 label에 출력.
        }
    }
    class CalcDialog extends JDialog{
        //private int sum = 0; //ppt에 부분은 왜 있는지 모르겠다.(나는 사용하지 않았다.)
        private boolean bValid = false; //다이얼로그 표시 유무를 표시할 때 사용.
        private JTextField a = new JTextField(10);
        private JTextField b = new JTextField(10);
        private JButton mulBtn = new JButton("    Multiply    ");

        public CalcDialog(JFrame f){
            super(f,"Calculation Dialog",true);//모달 다이얼로그로 설정.
            setLayout(new FlowLayout());
            add(new JLabel("두 수를 곱합니다."));//라벨 추가.
            add(a); //textfield 추가.
            add(b); //textfield 추가.
            add(mulBtn); //Multiply 버튼 추가.
            setSize(200,200);

            mulBtn.addActionListener(new MyActionListener(){ //Multiply 버튼에 Action리스터 등록.
                public void actionPerformed(ActionEvent e){
                    if(isValid()){
                        bValid = false;//모달 다이얼로그를 끈다.
                    }else{//유효한 값이 아니라면 오류 메세지를 출력하는 다이얼로그를 출력하도록 했다.
                        JOptionPane.showMessageDialog(CalcDialog.this,"빈칸 없이 정수만 입력해 주세요.","오류!!",JOptionPane.ERROR_MESSAGE);
                        bValid = true;//모달 다이얼로그를 그대로 둔다.
                    }
                    setVisible(bValid);
                }
            });
        }
        public boolean isValid(){ // 두 텍스트 필드의 값이 정수인지 확인 or 빈칸인지 아닌지 확인.
            if((a == null ) || (b == null ) )return false;//빈칸 확인 null인지 먼저 확인.
            else{
                try{//입력 값이 정수인지 확인.
                    Integer.parseInt(a.getText());
                    Integer.parseInt(b.getText());
                    return true;
                }catch (NumberFormatException ex){
                    return false;
                }

            }
        }
        public int getResult(){//곱셈 결과 리턴.
            return Integer.parseInt(a.getText()) * Integer.parseInt(b.getText());
        }
    }
    static public void main(String[] arg){
        new Challenge();
    }
}
