// This imports below are examples of static import
import static java.lang.System.out;
import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        out.println("sqrt " + sqrt(2.0));
    }
}


class Foo {
    public static final int X;

    // A static initializer is written below:
    static {
        X = 42;
    }
}