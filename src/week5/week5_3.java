package week5;

//동물 클래스
class Animal{
    void eat() {
        System.out.println("동물이 먹습니다.");
    }

    void sound() {
        System.out.println("동물이 소리를 냅니다.");
    }
}

//고양이 클래스 (동물을 상속받음)
class Cat extends Animal{
    @Override
    void eat() {
        System.out.println("고양이가 생선을 먹습니다.");
    }
    @Override
    void sound() {
        System.out.println("야옹~");
    }


}

//강아지 클래스 (동물을 상속받음)
class Dog extends Animal {
    @Override
    void eat() {
        System.out.println("강아지가 사료를 먹습니다.");
    }
    @Override
    void sound() {
        System.out.println("멍멍!");
    }

}

public class week5_3 {

    public static void main(String[] args) {
        Cat cat = new Cat();
        System.out.println("=== 고양이 ===");
        cat.eat();
        cat.sound();

        Dog dog = new Dog();
        System.out.println("=== 강아지 ===");
        dog.eat();
        dog.sound();
    }

}
