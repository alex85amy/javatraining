package a;

import a.a2.Dog;
import a.a2.Pet;

public class A2 {
    public static void main(String[] args) {
        Pet myPet = new Pet("Buddy", "Brown", 5);
        Dog myDog = new Dog("Max", "Black", 3);

        // 存取 Pet 類別的屬性
        // private,default,protected屬性無法直接存取
        // System.out.println(myPet.name); // Compile Error
        // System.out.println(myPet.color); // Compile Error
        // System.out.println(myPet.age); // Compile Error
        System.out.println(myPet.isHungry); // Output: false

        // 存取 Pet 類別的方法
        myPet.makeSound(); // Output: This is a generic animal sound.
        // private方法無法直接存取
        // myPet.sleep(); // Compile Error
        myPet.sleep(8); // Output: The pet sleeps for 8 hours.

        // 存取 Dog 類別的方法
        myDog.makeSound(); // Output: Woof! Woof!
        // protected方法無法直接存取
        // myDog.wagTail(); // Compile Error
    }
}

