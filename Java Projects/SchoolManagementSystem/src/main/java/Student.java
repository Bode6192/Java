import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private int id;
    private String name;
    private int grade;
    private int feesPaid;
    private int tuition;

    public Student(int id, String name, int grade) {

        this.feesPaid = 0;
        this.tuition = 30000;
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public void updateFeesPaid(int fees) {
        
        this.feesPaid += fees;
    }

    public void payFees(int fees) {

        updateFeesPaid(fees);
        School.updateTotalMoneyEarned(fees);
    }

    public int feesOwed() {

        return tuition - feesPaid;
    }
}