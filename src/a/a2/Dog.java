package a.a2;

// 定義一個 Dog 類別，繼承自 Pet 類別。
public class Dog extends Pet {
    // Dog 類別的建構子
    public Dog(String name, String color, int age) {
        super(name, color, age);
    }

    // makeSound() 方法的覆寫（override）
    @Override
    public void makeSound() { // 公開方法
        System.out.println("Woof! Woof!");
    }

    // 這是一個protected方法
    protected void wagTail() {
        System.out.println("The dog is wagging its tail.");
    }
}

