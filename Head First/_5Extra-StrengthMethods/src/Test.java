public class Test {
    public static void main(String [] args) {
        Test o = new Test();
        o.go();
    }
    void go() {
        int y = 7;
        for(int x = 1; x < 8; x++) {
            y++;
            if (x > 4) {
                System.out.print(++y + " ");
            }
            if (y > 14) {
                System.out.println("x = " + x);
                break;
            }
        }
    }
}
