import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.InputStream;
import java.util.Scanner;

@Data
@AllArgsConstructor
public class Email {

    private String firstName;
    private String lastname;
    private String department;
    private String email;
    private int mailBoxCapacity = 500;
    private String password;
    private int defaultPasswordLength = 8;
    private String alternateEmail;
    private String companySuffix = "G&D.com";

    public Email(){

    }

    // Constructor

    public Email(String firstName, String lastname) {

        this.firstName = firstName;
        this.lastname = lastname;

        this.department = setDepartment();
        this.password = randomPassword(defaultPasswordLength);

        this.email = this.firstName.toLowerCase() + this.lastname.toLowerCase() + "@" + this.getDepartment() + companySuffix;
    }

    private String setDepartment() {
        System.out.print("Department Codes\n1) Sales\n2) Development\n3) Accounting\n0) None\nEnter Department Codes: ");
        Scanner input = new Scanner(System.in);
        int deptChoice = input.nextInt();

        if (deptChoice == 1) {

            return "Sales";
        } else if (deptChoice == 2) {

            return "Development";
        } else if (deptChoice == 3) {

            return "Accounting";
        } else {
            return "";
        }
    }

    private String randomPassword(int length) {

        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890@#£$%&?#";
        char[] password = new char[length];

        for(int i = 0; i<length; i++) {

            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }

        return new String(password);
    }

    public void showInfo() {
        System.out.println("EMAIL CREATED: " +
                this.getFirstName() + " " +
                this.getLastname() + " in " +
                this.getDepartment() +
                " Department");
        System.out.println("Your Email Address is: " + this.getEmail());
        System.out.println("Your Password is: " + this.getPassword());
        System.out.println("Your Mail Box Capacity is: " + this.getMailBoxCapacity());
    }
}