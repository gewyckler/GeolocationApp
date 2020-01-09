import lombok.Getter;
import model.Employee;
import model.Employees;
import model.Events;
import org.jxmapviewer.JXMapViewer;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


@Getter
public class LocationMap extends JFrame {
    private Employees employees;
    private Events events;
    private JPanel rootPanel;
    private JList employeesJList;
    private JButton LdBtn;
    private DefaultListModel model = new DefaultListModel();
    private JXMapViewer mapViewer = new JXMapViewer();

    private JFileChooser fileChooser = new JFileChooser();
    private FileNameExtensionFilter filter = new FileNameExtensionFilter("txt and json", "txt", "json");

    public LocationMap() {
        LdBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idFilePath;
                String employeesFilePath;

                int returnVal = openWindowDialog();
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    employeesFilePath = fileChooser.getSelectedFile().getPath(); // D:\java\GeolocationApp\test_sd_card\config\employees.txt
                    idFilePath = employeesFilePath.trim().replace("employees.txt", "id.txt"); // D:\java\GeolocationApp\test_sd_card\config\id.txt

                    employees = LoadFromFile.loadJsonToJavaObject(employeesFilePath, idFilePath);

                    for (Employee emp : employees.getEmployees()) {
                        System.out.println(emp);
                        model.addElement(emp);
                    }

                    employeesJList.setModel(model);
                }
            }
        });
    }

    public JFrame createMap() {
        JFrame jFrame = new JFrame("JXMapviewer2 Example 2");
        employeesJList.setBorder(BorderFactory.createLineBorder(Color.BLACK));

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

    private int openWindowDialog() {
        fileChooser.setFileFilter(filter);
        int returnVal = fileChooser.showOpenDialog(getParent());
        return returnVal;
    }
}
