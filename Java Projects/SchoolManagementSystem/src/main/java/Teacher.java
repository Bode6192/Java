import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

    private int id;
    private String name;
    private int salary;

    public void receiveSalary(int payment) {

        this.salary = payment;
        School.updateTotalMoneySpent(payment);
    }
}