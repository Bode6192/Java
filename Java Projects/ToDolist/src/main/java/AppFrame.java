import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AppFrame extends JFrame {

    private TitleBar title;
    private final List list;
    private ButtonPanel buttonPanel;

    private final JButton addTask;
    private final JButton clear;

    // Constructor
    AppFrame() {

        this.setSize(400, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);

        title = new TitleBar();
        list= new List();
        buttonPanel = new ButtonPanel();

        this.add(title, BorderLayout.NORTH);
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.add(list, BorderLayout.CENTER);

        addTask = buttonPanel.getAddTask();
        clear = buttonPanel.getClear();

        addListeners();
    }

    public void addListeners() {

        addTask.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                Task task = new Task();
                list.add(task);
                list.updateNumbers();

                task.getDone().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        super.mousePressed(e);
                        task.changeState();
                        revalidate();
                    }
                });
                revalidate();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

        });

        clear.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

                list.removeCompletedTasks();
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }
}
