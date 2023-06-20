public class Main {

    public static void main(String[] args) {

        Teacher lizzy = new Teacher(1, "Lizzy", 500);
        Teacher melissa = new Teacher(2, "Melissa", 700);
        Teacher mike = new Teacher(3, "Mike", 600);
        

        Student tamasha = new Student(1, "Tamasha",4);
        Student ben = new Student(2, "Ben", 9);
        Student rabbi = new Student(3, "Rabbi", 5);

        School grandMates = new School();
        
        grandMates.addTeacher(lizzy);
        grandMates.addTeacher(melissa);
        grandMates.addTeacher(mike);
        
        grandMates.addStudent(tamasha);
        grandMates.addStudent(ben);
        grandMates.addStudent(rabbi);

        System.out.println("GrandMates made a profit of $" + grandMates.getTotalMoneyLeft());

        tamasha.payFees(20000);
        rabbi.payFees(9000);

        System.out.println("GrandMates made a profit of $" + grandMates.getTotalMoneyLeft());

        lizzy.receiveSalary(500);

        System.out.println(grandMates);
    }
}