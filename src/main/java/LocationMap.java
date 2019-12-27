import lombok.Getter;
import model.Employee;
import model.Employees;
import org.jxmapviewer.JXMapViewer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Getter
public class LocationMap extends JFrame {
    private Employees employees = JsonToObject.loadContentFromFile();
    private JPanel rootPanel;
    private JList employeesJList;
    private JButton LdBtn;
    private DefaultListModel model = new DefaultListModel();

    private JXMapViewer mapViewer = new JXMapViewer();

    public LocationMap() {
        LdBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Employee emp : employees.getEmployees()) {
                    model.addElement(emp);
                }
                employeesJList.setModel(model);
            }
        });
    }

    public JFrame createMap() {
        JFrame jFrame = new JFrame("JXMapviewer2 Example 2");
        employeesJList.setBorder(BorderFactory.createLineBorder(Color.BLACK));

//        employees = employees.loadContentFromFile();

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
