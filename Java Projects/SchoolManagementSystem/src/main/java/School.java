import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class School {

    private List<Teacher> teachers = new ArrayList<>();
    private List<Student> students = new ArrayList<>();
    public static int totalMoneyEarned = 0;
    private static int totalMoneySpent = 0;

    public School(List<Teacher> teachers, List<Student> students) {

        this.students = students;
        this.teachers = teachers;
    }

    public void addTeacher(Teacher teacher){

        teachers.add(teacher);
    }

    public void addStudent(Student student){

        students.add(student);
    }

    public static void updateTotalMoneyEarned(int MoneyEarned) {

        totalMoneyEarned += MoneyEarned;
    }

    public static void updateTotalMoneySpent(int MoneySpent) {

       totalMoneySpent += MoneySpent;
    }

    public int getTotalMoneyLeft () {

        return totalMoneyEarned - totalMoneySpent;
    }
}