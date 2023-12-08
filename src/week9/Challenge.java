package week9;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

class SouthPanel extends JPanel{
    public SouthPanel(JTextField tf1){
        setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel label = new JLabel("계산 결과");
        label.setForeground(Color.WHITE); // 원하는 텍스트 색상 설정.
        add(label);
        add(tf1);
        setBackground(Color.BLACK);
    }
}

class CenterPanel extends JPanel {
    public CenterPanel() {
        setLayout(new GridLayout(4, 4, 5, 5));
    }
}

class NorthPanel extends JPanel{
    public NorthPanel(JTextField tf2){
        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(new JLabel("수식입력"));
        add(tf2); //텍스트칸의 크기를 설정
        setBackground(Color.GRAY);
    }
}

public class Challenge extends JFrame implements ActionListener{
    JTextField tf1 = new JTextField(25);
    JTextField tf2 = new JTextField(25);
    private String text1 = "";
    public Challenge(){
        super("계산기 프레임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new BorderLayout());//JFrame의 기본 Layout이 BorderLayout()이기 때문에 생략가능.
        NorthPanel northPanel = new NorthPanel(tf1);
        CenterPanel centerPanel = new CenterPanel();
        SouthPanel southPanel = new SouthPanel(tf2);
        c.add(northPanel, BorderLayout.NORTH);
        c.add(centerPanel, BorderLayout.CENTER);
        c.add(southPanel, BorderLayout.SOUTH);

        for (int i = 0; i < 10; i++) { //문자열. Integer.toString(i); 0~10까지
            JButton btn = new JButton(Integer.toString(i));
            btn.addActionListener(this);
            centerPanel.add(btn);
        }
        // 배열에 연산자 버튼 추가
        String[] operators = {"CE", "계산", "+", "-", "x", "/"};
        for (int i = 0;i<operators.length;i++) {
            JButton btn = new JButton(operators[i]);
            if(i > 1) { // 연산자 버튼을 노란색으로.
                btn.setBackground(Color.YELLOW);
            }
            btn.addActionListener(this);
            centerPanel.add(btn);
        }
        setSize(400,400);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        JButton b = (JButton)e.getSource();
        if(b.getText().equals("CE")){ //"CE" 버튼을 클릭할 경우 마지막 문자 제거.
            text1 = text1.substring(0, text1.length() - 1);
            tf1.setText(text1);
        }else if(b.getText().equals("계산")){ //"계산" 버튼을 클릭할 경우.
            String result;
            result = text1;
            text1 = convPostfix(tf1.getText()); // 후위 표기법으로 변경.
            result += " = " + postfixCalculate(text1);
            tf2.setText(result);//연산 결과 출력.
            tf1.setText(""); //tf1 비우기.
            text1 = ""; //text1 비우기 (다음 계산을 위해)
        }
        else {
            text1 += b.getText();
            tf1.setText(text1);
        }
    }

    public static double postfixCalculate(String postfix) {//후위 표기법 계산.
        Stack<Double> stack = new Stack<>(); // Double형의 스택 사용.

        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);

            if (Character.isDigit(c)) {
                stack.push(Double.parseDouble(String.valueOf(c))); // 숫자를 Double로 변환하여 푸시
            } else {
                if (stack.isEmpty()) {
                    throw new IllegalArgumentException("잘못된 후위 표기법 식");
                }

                double op2 = stack.pop();

                if (stack.isEmpty()) {
                    throw new IllegalArgumentException("잘못된 후위 표기법 식");
                }

                double op1 = stack.pop();
                switch (c) {
                    // op2에 먼저 pop한 이유는 후위 표기법으로 변환할 때 순서가 바뀌기 때문
                    // ex) 3+2 => 스택에 저장 시 3, 2 순으로 저장되는데 스택은 마지막에 push한
                    // 데이터가 가장 위에 있으므로
                    case '+':
                        stack.push(op1 + op2);
                        break;

                    case '-':
                        stack.push(op1 - op2);
                        break;

                    case 'x':
                        stack.push(op1 * op2);
                        break;

                    case '/':
                        stack.push(op1 / op2);
                        break;
                    default:
                        throw new IllegalArgumentException("잘못된 연산자: " + c);
                }
            }
        }
        if (stack.size() != 1) {
            throw new IllegalArgumentException("잘못된 후위 표기법 식");
        }

        return stack.pop();
    }
    public static String convPostfix(String infix){//후위 표기법으로 변경.
        char c ;
        Stack<Character> opStack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<infix.length(); i++){
            c = infix.charAt(i);

            // 숫자이면 표현
            if (Character.isDigit(c)){
                sb.append(c);
            }
            // 연산자 스택이 비어있을 경우 값 push
            else if (opStack.isEmpty()){
                opStack.push(c);
            }
            // 숫자가 아니고 연산자 스택이 비어있지 않은 경우 (연산자가 하나라도 스택에 추가된 경우)
            else {
                // 여는 괄호가 나오면 스택에 저장 후 다음 문자로
                if (c == '('){
                    opStack.push(c);
                    continue;
                }
                // 닫는 괄호가 나올 경우
                // 스택에 저장된 모든 연산자를 반환
                else if (c == ')'){
                    char check;
                    while(true) {
                        check = opStack.pop();
                        if (check == '(') {
                            break;
                        }
                        else {
                            sb.append(check);
                        }
                    }
                    continue;
                }

                // 현재 연산자의 우선순위가 더 높은 경우
                // 스택에 연산자 저장
                if (compareOp(opStack.peek(), c) > 0){
                    opStack.push(c);
                }
                // 현재 연산자의 우선순위가 더 낮거나 같은 경우
                // 스택에 있는 우선순위가 높은 연산자를 빼서 표현
                else {
                    while(!opStack.isEmpty()){
                        if (compareOp(opStack.peek(), c) <= 0){
                            sb.append(opStack.pop());
                        }
                        else {
                            break;
                        }
                    }
                    opStack.push(c);
                }
            }
        }

        char check;
        while(!opStack.isEmpty()) {
            check = opStack.pop();
            if (check != '(') {
                sb.append(check);
            }
        }

        return sb.toString();
    }
    // 연산자 우선순위 반환
    public static int getOpPriority(char c){
        switch (c) {
            case 'x':
            case '/':
                return 3;

            case '+':
            case '-':
                return 2;

            case '(':
                return 1;

            default:
                return -1;
        }
    }
    // 연산자 우선순위 비교
    public static int compareOp(char stackOp, char curOp) {
        int stackOpPriority = getOpPriority(stackOp);
        int curOpPriority = getOpPriority(curOp);

        // 현재 우선순위가 더 높은 경우
        if (stackOpPriority < curOpPriority) {
            return 1;
        }
        // 우선순위가 같은 경우
        else if (stackOpPriority == curOpPriority) {
            return 0;
        }
        // 스택의 우선순위가 더 높은 경우
        else {
            return -1;
        }
    }
    public static void main(String[] args){
        new Challenge();
    }
}
