import javax.swing.*;
import java.awt.*;

public class TitleBar extends JPanel {

    // Constructor
    TitleBar() {

        this.setPreferredSize(new Dimension(400,65));
//        this.setBackground(Color.BLACK);

        JLabel titleText = new JLabel("To Do List");
        titleText.setPreferredSize(new Dimension(200, 45));
        titleText.setFont(new Font("Sans-serif", Font.BOLD, 20));
        titleText.setHorizontalAlignment(JLabel.CENTER);

        this.add(titleText);
    }
}