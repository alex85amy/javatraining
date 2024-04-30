package a.a2;

// 定義一個 Pet 類別，實作 Animal 介面。
public class Pet implements Animal {
    // private 屬性
    private String name;
    // default 屬性
    String color;
    // protected 屬性
    protected int age;
    // public 屬性
    public boolean isHungry;

    // Pet 類別的建構子
    public Pet(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
        this.isHungry = false; // 預設為飽食狀態
    }

    // makeSound() 方法的覆寫
    @Override
    public void makeSound() { // 公開方法
        System.out.println("This is a sound.");
    }

    // 這是一個private方法
    private void sleep() {
        System.out.println("The pet is sleeping.");
    }

    // 過載的方法，與上面的方法名稱相同，但參數列表不同
    public void sleep(int hours) {
        System.out.println("The pet sleeps for " + hours + " hours.");
    }
}

