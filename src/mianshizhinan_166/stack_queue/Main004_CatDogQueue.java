package mianshizhinan_166.stack_queue;

/**
 * @author guoxin
 * @version 2019/8/13
 */
public class Main004_CatDogQueue {

}

class Pet {

    private String type;

    public String getType() {
        return type;
    }

    Pet(String type) {
        this.type = type;
    }
}

class Dog extends Pet {

    public Dog() {
        super("dog");
    }
}

class Cat extends Pet {

    public Cat() {
        super("cat");
    }
}