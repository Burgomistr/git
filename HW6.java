public class HW6 {

    public static void main (String[] args){
        Animal[] animal = {new Cat("Cat-1", 101, 2, 3), new Dog ("Dog-1", 200, 0.5, 5)};
        for (Animal item: animal)
            System.out.println(item + item.run() + item.jump() + item.swim());
    }
}

interface IAnimal{
    String run();
    String jump();
    String swim();
}

abstract class Animal implements IAnimal{
    final double limitCatRun = 200;
    final double limitCatJump = 2;
    final double limitCatSwim = 0;
    final double limitDogRun = 500;
    final double limitDogJump = 0.5;
    final double limitDogtSwim = 10;

    String name; //animal's type (cat, dog, etc.)
    double aRun; // animal's distance to run
    double aJump;// animal's distance to jump
    double aSwim;// animal's distance to swim

    Animal(String name, double aRun, double aJump, double aSwim){
        this.name = name;
        this.aRun = aRun;
        this.aJump = aJump;
        this.aSwim = aSwim;
    }

    @Override
    public String toString() {
        return name;
    }
}


class Cat extends Animal {

    Cat(String name, double cRun, double cJump, double cSwim) {
        super(name, cRun, cJump, cSwim);
    }
    public String run(){
        boolean bRun = true;
        if (aRun > limitCatRun) bRun = false;
        String str = "\n run " + aRun + ": " + bRun;
        return str;
    }
    public String jump(){
        boolean bJump = true;
        if (aJump > limitCatJump) bJump = false;
        String str = "\n jump " + aJump + ": " + bJump;
        return str;
    }
    public String swim(){
        boolean bSwim = true;
        if (aSwim > limitCatSwim) bSwim = false;
        String str = "\n swim " + aSwim + ": " + bSwim;
        return str;
    }
}

class Dog extends Animal {

    Dog(String name, double cRun, double cJump, double cSwim) {
        super(name, cRun, cJump, cSwim);
    }
    public String run(){
        boolean bRun = true;
        if (aRun > limitDogRun) bRun = false;
        String str = "\n run " + aRun + ": " + bRun;
        return str;
    }
    public String jump(){
        boolean bJump = true;
        if (aJump > limitDogJump) bJump = false;
        String str = "\n jump " + aJump + ": " + bJump;
        return str;
    }
    public String swim(){
        boolean bSwim = true;
        if (aSwim > limitDogtSwim) bSwim = false;
        String str = "\n swim " + aSwim + ": " + bSwim;
        return str;
    }
}