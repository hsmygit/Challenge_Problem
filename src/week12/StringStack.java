package week12;

public class StringStack implements Stack{
    private String[] element; // 스택의 저장 메모리
    private int tos; // index, top of stack

    public StringStack(int capacity){
        tos = 0; //초기 top는 0
        element = new String[capacity];
    }

    //Stack 인터페이스에 선언된 다음 3개의 메소드 오버라이딩 구현
    public int length(){//현재 스택에 저장된 개수 리턴
        int sum = 0;
        for(int i =0;i<element.length;i++){
            if(element[i] != null) sum += 1;
        }
        return sum;
    }
    public int capacity(){//현재 스택에 가능한 개수 리턴
        return element.length;
    }
    public String pop(){
        if(tos >= capacity()) {tos--;}
        String pop_element = element[tos];
        element[tos]=null;
        tos--;
        return pop_element;
    }
    public boolean push(String str){
        if(tos >= capacity()) return false;
        else {
            element[tos] = str;
            tos++;
            return true;
        }
    }
}
