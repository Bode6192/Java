public class DogTestDrive {
    public static void main(String[] args) {
        
        Dog d = new Dog();

        d.bark();

        System.out.println();
    }
}


class Dog {

    int size = 45;
    String breed;
    String name;

    void bark() {
        System.out.println("Ruff! Ruff!");
    }
}
