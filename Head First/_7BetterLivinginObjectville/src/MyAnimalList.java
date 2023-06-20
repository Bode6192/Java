public class MyAnimalList {

    private Animal[] animals = new Animal[5];
    private int nextindex = 0;

    public void add(Animal a) {

        if (nextindex < animals.length) {
            animals[nextindex] = a;
            System.out.println("Animal added at " + nextindex);
            nextindex++;
        }
    }
}


class  AnimalTestDrive {

    public static void main(String[] args) {
        MyAnimalList list = new MyAnimalList();
        Dog a = new Dog();
        Cat c = new Cat();
        list.add(a);
        list.add(c);

    }
}

class  Animal {

}

class Dog extends Animal {

}

class Cat extends Animal {

}