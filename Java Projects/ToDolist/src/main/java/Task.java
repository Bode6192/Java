import lombok.Data;

import javax.swing.*;
import java.awt.*;

@Data
public class Task extends JPanel {

    private JLabel index;
    private JTextField taskName;
    private JButton done;

    private boolean checked;

    // Constructor
    Task() {

        this.setPreferredSize(new Dimension(40, 20));
        this.setBackground(Color.red);

        this.setLayout(new BorderLayout());

        checked = false;

        index = new JLabel("");
        index.setPreferredSize(new Dimension(20, 20));
        index.setHorizontalAlignment(JLabel.CENTER);
        this.add(index, BorderLayout.WEST);

        taskName = new JTextField("My Task");
        taskName.setBorder(BorderFactory.createEmptyBorder());
        taskName.setBackground(Color.red);
        this.add(taskName, BorderLayout.CENTER);

        done = new JButton("done");
        done.setPreferredSize(new Dimension(40, 20));
        done.setBorder(BorderFactory.createEmptyBorder());
        this.add(done, BorderLayout.EAST);
    }

    public void changeIndex(int number) {

        this.index.setText(number+"");
        this.revalidate();
    }

    public void changeState() {

        this.setBackground(Color.GREEN);
        taskName.setBackground(Color.GREEN);
        checked = true;
    }

    public boolean getState() {

        return checked;
    }
}
