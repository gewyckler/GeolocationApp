import lombok.Getter;
import org.jxmapviewer.JXMapViewer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Getter
public class LocationMap extends JFrame {
    private JPanel rootPanel;
    private JList employeesJList;
    private JButton LdBtn;
    private DefaultListModel model = new DefaultListModel();
    private Employees employees = EmployeeFromFile.loadContentFromFile();

    private JXMapViewer mapViewer = new JXMapViewer();

    public LocationMap() {
        LdBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(employees.getEmployee().size());
                for (Employee emp : employees.getEmployee()) {
                    model.addElement(emp);
                }
                employeesJList.setModel(model);
            }
        });
    }

    public JFrame createMap() {
        JFrame jFrame = new JFrame("JXMapviewer2 Example 2");
        employeesJList.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        employees = EmployeeFromFile.loadContentFromFile();

        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.setTitle("Forest Tracker");
        jFrame.pack();
        jFrame.setSize(700, 500);
        jFrame.setVisible(true);

        mapViewer.setSize(500, 500);
        jFrame.getContentPane().add(this.mapViewer);
        rootPanel.setBackground(Color.gray);
        jFrame.getContentPane().add(this.rootPanel);
        return jFrame;
    }
}
