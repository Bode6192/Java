public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        // First method to making the Duck Class
        Duck d = new Duck(12);

        // Second method to making the Duck Class
        // Not Knowing the size:
        Duck2 e = new Duck2();

        // Knowing the size:
        Duck2 f = new Duck2(15);


    }
}


class Duck {

    int size;

    public Duck(int duckSize) {

        System.out.println("Quack");

        size = duckSize;

        System.out.println("size is " + size);
    }
}

// Another way to make a Duck class without using arguments is written below:

class Duck2 {
    int size;

    // To make a Duck size when you don't know the size:
    public Duck2() {
        // supply default size
        size = 27;
    }

    // To make a Duck when you know the size:
    public Duck2(int duckSize) {
        // use duckSize parameter
        size = duckSize;
    }
}