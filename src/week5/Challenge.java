package week5;

import java.util.Scanner;

class GameObject {
    protected int distance; //객체가 이동한 거리인거 같으나 사용하지 않았습니다.
    protected int x,y; //객체의 이차원 배열의 좌표로 활용.

    public GameObject(int startX,int startY, int distance){
        this.x = startX;
        this.y = startY;
        this.distance = distance;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public boolean collide(GameObject p){ // 활용하지 않았습니다.
        return true;
    }
    protected void move(){
        // Default move behavior, to be overridden by subclasses
    }
    protected char getShape(){
        // Default shape, to be overridden by subclasses
        return '-';
    }
}

class PacMan extends GameObject{
    private Scanner scan = new Scanner(System.in);

    public PacMan(int startX, int startY, int distance){
        super(startX,startY,distance);
    }
    @Override
    protected void move(){
        System.out.print("왼쪽(a), 위(w), 아래(s), 오른쪽(d) >> ");
        String command = scan.next();
        int newX = getX(), newY = getY();

        switch (command) {
            case "a":
                newY -= 1; // 왼쪽
                break;
            case "d":
                newY += 1; // 오른쪽
                break;
            case "w":
                newX -= 1; // 위
                break;
            case "s":
                newX += 1; // 아래
                break;
            default:
                System.out.println("잘못된 입력입니다.");
        }
        // 새로운 좌표가 맵의 범위를 벗어나는지 확인.
        if (newX >= 0 && newX < 10 && newY >= 0 && newY < 20) {
            // 범위 내에 있을 경우만 이동
            x = newX;
            y = newY;
        } else {
            // 범위를 벗어날 경우 현재 위치 유지.
            System.out.println("맵 밖으로 나갈 수 없습니다.");
        }
    }
    @Override
    protected char getShape(){
        return 'C';
    }
}
public class Challenge {
    private char[][] map = new char[10][20];
    private PacMan pacman;
    private Cookies[] cookies = new Cookies[5]; //최대 5개 쿠키 객체 배열.
    private int numberOfCookies;
    private int cookiesEaten = 0;

    public static void main(String[] args){
        Challenge game = new Challenge();
        game.run();
    }
    public void run(){ //게임 실행.
        System.out.println("** PacMan 게임에 오신 것을 환영합니다 **");
        pacman = new PacMan(0,0,0); //팩맨의 처음 좌표를 0,0으로 설정.
        generateCookies(); // 랜덤한 수의 쿠키를 생성.
        while (true){
            drawMap(); //맵 그리기.
            pacman.move(); //팩맨을 움직임.
            moveCookies(); //쿠키를 움직임.
        }
    }
    private void generateCookies(){ //랜덤하게 생성되는 쿠키 갯수 범위 (2 to 5)
        numberOfCookies = (int) (Math.random() * 4 + 2);
        for(int i = 0 ; i < numberOfCookies;i++){
            cookies[i] = new Cookies((int)(Math.random()*10),(int)(Math.random()*20),0);
        }// 쿠키를 랜덤한 위치에 생성하도록 했습니다.
    }
    class Cookies extends GameObject{
        private int moveCount = 0;

        public Cookies(int startX, int startY, int distance){
            super(startX,startY,distance);
        }
        @Override
        protected void move() {
            moveCount ++; //사용자의 입력 횟수를 파악.
            //입력 횟수가 3의 배수일 때 쿠키가 4가지 방향 중 랜덤하게 한 칸씩 움직임
            if (moveCount % 3 == 0) {
                int newX = getX(), newY = getY();
                do {
                    int randomDirection = (int) (Math.random() * 4);
                    switch (randomDirection) {
                        case 0:
                            newY -= 1; // 왼쪽
                            break;
                        case 1:
                            newY += 1; // 오른쪽
                            break;
                        case 2:
                            newX -= 1; // 위
                            break;
                        case 3:
                            newX += 1; // 아래
                            break;
                    }
                }while (!(newX >= 0 && newX < 10 && newY >= 0 && newY < 20)) ; // 유효한 위치가 아닌 경우 반복.
                    // 유효한 위치로 이동
                    x = newX;
                    y = newY;
            }// 쿠키가 맵의 범위를 벗어나는 경우를 방지하기 위해 do_while문을 사용했습니다.
        }
        @Override
        protected char getShape(){
            return '●';
        }
    }
    private void moveCookies() { //생성된 모든 쿠키를 움직이는 메서드.
        for (int i = 0; i < numberOfCookies; i++) {
            if (cookies[i] != null) {
                cookies[i].move();
                //팩맨이 쿠키를 먹었을 경우 해당 쿠키객체를 쿠키배열에서 삭제.
                if((pacman.getX() == cookies[i].getX())&&(pacman.getY() == cookies[i].getY())) {
                    cookies[i] = null;
                    cookiesEaten++;
                    System.out.println("쿠키 먹기 성공!! 남은 쿠기 : "+(numberOfCookies - cookiesEaten));
                }
            }
        }
    }

    public void drawMap(){//맵을 그리는 메서드.
        for(int i = 0; i < 10; i++)
            for(int k = 0; k < 20; k++)
                map[i][k] = '-';
        map[pacman.x][pacman.y] = pacman.getShape(); //팩맨의 위치를 표시.
        for (int i = 0; i < numberOfCookies; i++){ //쿠키배열에 있는 모든 쿠키객체 위치 표시.
            if (cookies[i] != null){
                map[cookies[i].x][cookies[i].y] = cookies[i].getShape();
            }
        }
        for(int i = 0; i < 10; i++){
            for(int k =0; k<20;k++)
                System.out.print(map[i][k]);
            System.out.println();
        }
    }
}
